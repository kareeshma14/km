package com.student.StudentForm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.StudentForm.entity.StudentClass;
import com.student.StudentForm.exception.NoStudentException;
import com.student.StudentForm.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/students/{id}")
	public StudentClass getStudentById(@PathVariable int id) {
		Optional<StudentClass> student = service.getStudentById(id);
		if (student.isEmpty())
			throw new NoStudentException(id);
		return student.get();

	}
	
	@GetMapping("/students")
	public List<StudentClass> getStudents(){
		return service.getAllStudents();
	}
	
	@GetMapping("/studentsbyascendingorder")
	public List<StudentClass> getStudentsByAscendingOrder(){
		return service.getAllStudentsAscendingOrder();
	}
	
	@PostMapping("/students")
	public StudentClass saveStudent(@RequestBody StudentClass student) {	
		return service.addStudent(student);	
	}
	
	@PutMapping("/students")
	public StudentClass editStudent(@RequestBody StudentClass student) {
		return service.editStudent(student);
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
}
