package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.beans.Student;
import com.zensar.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public Student findbyIdStudent(int studRoll) {
		
		Student student = studentRepository.findById(studRoll).orElse(null);	
		return  student;
	}
	
	public void save(Student student) {
		studentRepository.save(student);
		System.out.println("Password Changed");
		
	}

}
