package com.student.StudentForm.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.StudentForm.entity.StudentClass;
import com.student.StudentForm.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;

	// to add the student
	public StudentClass addStudent(StudentClass student) {
		return repository.save(student);
	}

	// to get the student based on his id
	public Optional<StudentClass> getStudentById(int id) {
		return repository.findById(id);
	}

	// to get all the students
	public List<StudentClass> getAllStudents() {
		return repository.findAll();
	}

	// to get the element based on ascending order
	public List<StudentClass> getAllStudentsAscendingOrder() {
		List<StudentClass> list = repository.findAll();

		list.sort(new Comparator<StudentClass>() {
			@Override
			public int compare(StudentClass o1, StudentClass o2) {
				return o1.getName().compareTo(o2.getName());
			}

		});

		return list;
	}

	// to edit the student
	public StudentClass editStudent(StudentClass student) {
		StudentClass ExistingStudent = repository.findById(student.getId()).orElse(null);
		ExistingStudent.setName(student.getName());
		ExistingStudent.setMarks(student.getMarks());
		return repository.save(ExistingStudent);
	}

	// to delete the student
	public String deleteStudent(int id) {
		repository.deleteById(id);
		return "student deleted";
	}
}
