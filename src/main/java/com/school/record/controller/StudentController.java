package com.school.record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.record.datamodel.Student;
import com.school.record.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	   private StudentService studentService;
	   
	   @Autowired
	   public StudentController(StudentService studentService) {
		   this.studentService = studentService;
	   }
	   
	   @GetMapping("/all")
	   public ResponseEntity<List<Student>> getAllStudent(){
		   return ResponseEntity.ok(studentService.getAllStudents());
	   }
	   
	   @GetMapping("/{id}")
	   public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		   return ResponseEntity.ok(studentService.getStudentById(id));
	   }
	   
	   @PostMapping("/")
	   public ResponseEntity<Student> createStudent(@RequestBody Student student){
		   return ResponseEntity.ok(studentService.createStudent(student));
	   }

	   @PatchMapping("/update/address/{id}")
	   public ResponseEntity<Student> updateStudentAddress(@PathVariable Long id,@RequestParam String address){
		   Student updatedStudent = studentService.updateStudentAddress(id, address);
		   return ResponseEntity.ok(updatedStudent);
	   }
	   
	   @PatchMapping("/update/age/{id}")
	   public ResponseEntity<Student> updateStudentAge(@PathVariable Long id,@RequestParam int age){
		   Student updatedStudent = studentService.updateAge(id, age);
		   return ResponseEntity.ok(updatedStudent);
	   }
	   
	   @PatchMapping("/update/mobile/{id}")
	   public ResponseEntity<Student> updateStudentMobileNumber(@PathVariable Long id,@RequestParam Long mobileNo){
		   Student updatedStudent = studentService.updateMobileNumber(id, mobileNo);
		   return ResponseEntity.ok(updatedStudent);
	   }
	   
	   @PutMapping("/update/{id}")
	   public ResponseEntity<Student> updateStudentDetails(@PathVariable Long id,@RequestBody Student student){
		   return ResponseEntity.ok(studentService.updateStudent(id, student));
	   }
	   
	   @DeleteMapping("/delete/{id}")
	   public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
		   studentService.deleteStudentById(id);
		   return ResponseEntity.ok("Student with id "+id+" has been deleted succefully.");
	   }
	   
	   @DeleteMapping("/delete/all")
	   public ResponseEntity<String> deleteAllStudentRecord(){
		   studentService.deleteAllStudent();
		   return ResponseEntity.ok("Delete all student succefully.");
	   }
	   
	   
}
