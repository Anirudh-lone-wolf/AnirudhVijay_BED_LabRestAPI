package com.glearning.LabSixDebateEvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.LabSixDebateEvent.model.Student;

@Repository
public interface DebateEventRepository extends JpaRepository<Student, Long> {

}
