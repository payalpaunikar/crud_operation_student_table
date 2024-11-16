package com.school.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.record.datamodel.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long>{

}
