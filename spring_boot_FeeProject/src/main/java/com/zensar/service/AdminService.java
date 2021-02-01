package com.zensar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.beans.Accountant;
import com.zensar.beans.Login;
import com.zensar.repository.AccountantRepository;
import com.zensar.repository.LoginRepository;

@Service
public class AdminService {

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	AccountantRepository accountantRepository;

	public Login findByIdAdmin(String adminEmail) {
		Login login = loginRepository.findById(adminEmail).orElse(null);
		return login;
	}

	public void save(Accountant accountant) {
		accountantRepository.save(accountant);
		System.out.println("Saved accountant into table !");
	}

	public ArrayList<Accountant> findAll() {
		return (ArrayList<Accountant>) accountantRepository.findAll();
	}
	
	public Accountant findByIdAccountant(String accEmail) {
		Accountant accountant = accountantRepository.findById(accEmail).get();
		return accountant;
	}
	
	public void deleteById(String accEmail)
	{
		accountantRepository.deleteById(accEmail);
		System.out.println("Accountant record Deleted Successfully");
	}
}
