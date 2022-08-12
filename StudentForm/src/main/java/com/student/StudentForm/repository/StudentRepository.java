package com.student.StudentForm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.StudentForm.entity.StudentClass;

public interface StudentRepository extends JpaRepository<StudentClass, Integer>{

}

