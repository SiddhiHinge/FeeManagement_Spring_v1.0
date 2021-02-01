package com.zensar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.beans.Accountant;
import com.zensar.beans.Student;
import com.zensar.repository.AccountantRepository;
import com.zensar.repository.StudentRepository;

@Service
public class AccountantService {

	@Autowired
	AccountantRepository accountantRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public Accountant findByIdAccountant(String accEmail) {
		Accountant accountant = accountantRepository.findById(accEmail).orElse(null);
		return accountant;
	}
	
	public Student findByIdStudent(int studRoll) {
		Student student = studentRepository.findById(studRoll).orElse(null);
		return student;
	}
	
	public ArrayList<Student> findAll() {
		return (ArrayList<Student>) studentRepository.findAll();
	}
	
	public void deleteById(int studRoll)
	{
		studentRepository.deleteById(studRoll);
		System.out.println("Student record Deleted Successfully");
	}
	
	public void save(Student student) {
		studentRepository.save(student);
		System.out.println("Saved/Updated student into table !");
	}
}
