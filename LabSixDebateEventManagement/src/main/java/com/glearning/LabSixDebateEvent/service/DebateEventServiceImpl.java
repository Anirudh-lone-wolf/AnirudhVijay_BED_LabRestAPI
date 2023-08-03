package com.glearning.LabSixDebateEvent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.LabSixDebateEvent.dao.DebateEventRepository;
import com.glearning.LabSixDebateEvent.model.Student;

@Service
public class DebateEventServiceImpl implements DebateEventService {

	@Autowired
	private DebateEventRepository debateEventRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students = this.debateEventRepository.findAll();
		return students;
	}

	@Override
	public Student findById(long theId) {
		Optional<Student> optionalStudent = this.debateEventRepository.findById(theId);
		if (optionalStudent.isEmpty())
			throw new IllegalArgumentException("The ID you Entered is Invalid");
		else
			return optionalStudent.get();
	}

	@Override
	public void save(Student theStudent) {
		this.debateEventRepository.save(theStudent);
	}

	@Override
	public void deleteById(long theId) {
		Student student = findById(theId);
		if (student != null)
			this.debateEventRepository.deleteById(theId);
	}

}
