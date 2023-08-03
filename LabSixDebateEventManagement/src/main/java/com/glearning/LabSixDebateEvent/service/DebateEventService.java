package com.glearning.LabSixDebateEvent.service;

import java.util.List;

import com.glearning.LabSixDebateEvent.model.Student;

public interface DebateEventService {

	List<Student> findAll();

	Student findById(long theId);

	void save(Student theStudent);

	void deleteById(long theId);

}