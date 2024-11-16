package com.school.record.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.stereotype.Service;

import com.school.record.datamodel.Student;
import com.school.record.exception.StudentNotFoundException;
import com.school.record.repository.StudentRepository;

@Service
public class StudentService {

	      private StudentRepository studentRepository;
	      
	      @Autowired
	      public StudentService(StudentRepository studentRepository) {
	    	  this.studentRepository = studentRepository;
	      }
	      
	      public List<Student> getAllStudents(){
	    	  return studentRepository.findAll();
	      }
	      
	      
	      public Student getStudentById(Long id) {
	    	  return studentRepository.findById(id)
	    			  .orElseThrow(()-> new StudentNotFoundException("Student with ID "+ id +" not found"));
	      }
	      
	      
	      public Student updateStudent(Long id,Student updateStudent) {
	    	  Student exisitingStudent = getStudentById(id);
	    	  exisitingStudent.setFirstName(updateStudent.getFirstName());
	    	  exisitingStudent.setLastName(updateStudent.getLastName());
	    	  exisitingStudent.setAddress(updateStudent.getAddress());
	    	  exisitingStudent.setAge(updateStudent.getAge());
	    	  exisitingStudent.setClassName(updateStudent.getClassName());
	    	  exisitingStudent.setClassDivision(updateStudent.getClassDivision());
	    	  exisitingStudent.setMobileNo(updateStudent.getMobileNo());
	    	  
	    	  return studentRepository.save(exisitingStudent);
	      }
	      
	      public Student updateStudentAddress(Long id,String address) {
	    	  Student existingStudent = getStudentById(id);
	    	  existingStudent.setAddress(address);
	    	  return studentRepository.save(existingStudent);
	      }
	      
	      
	      public Student updateAge(Long id,int age) {
	    	  Student existingStudent = getStudentById(id);
	    	  existingStudent.setAge(age);
	    	  return studentRepository.save(existingStudent);
	      }
	      
	      public Student updateMobileNumber(Long id,Long mobileNo) {
	    	  Student existingStudent = getStudentById(id);
	    	  existingStudent.setMobileNo(mobileNo);
	    	  return studentRepository.save(existingStudent);
	      }
	      
	      public void deleteStudentById(Long id) {
	    	  Student existingStudent = getStudentById(id);
	    	  studentRepository.delete(existingStudent);
	      }
	      
	      public void deleteAllStudent() {
	    	  studentRepository.deleteAll();
	      }
	      
	      public Student createStudent(Student student) {
	    	  return studentRepository.save(student);
	      }
	      
	      
}
