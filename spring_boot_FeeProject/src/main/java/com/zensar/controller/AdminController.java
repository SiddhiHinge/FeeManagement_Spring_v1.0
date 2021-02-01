package com.zensar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.beans.Accountant;
import com.zensar.beans.Login;
import com.zensar.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	Accountant accountant;

	@RequestMapping("/")
	public ModelAndView openLoginPage() {
		System.out.println("Into login page !");
		ModelAndView modelAndView = new ModelAndView("Login.jsp");
		return modelAndView;
	}

	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(@RequestParam("adminEmail") String adminEmail,
			@RequestParam("adminPassword") String adminPassword) {
		System.out.println("Into admin login check !");
		System.out.println("adminEmail" + adminEmail);
		System.out.println("adminPassword" + adminPassword);

		Login login = adminService.findByIdAdmin(adminEmail);
		ModelAndView modelAndView;
		if (login != null && (login.getPassword().equals(adminPassword))) {
			modelAndView = new ModelAndView("AdminPanel.jsp");
		} else {
			modelAndView = new ModelAndView("Login.jsp");
			modelAndView.addObject("message1", "Invalid login credentials..Please try again !");
		}
		return modelAndView;
	}

	@RequestMapping("/addAccountantForm")
	public ModelAndView openAccountantForm() {
		System.out.println("Into openAccountantForm page !");
		ModelAndView modelAndView = new ModelAndView("AddAccountant.jsp");
		return modelAndView;
	}

	@RequestMapping("/addAccountant")
	public ModelAndView addAccountant(@RequestParam("accName") String accName,
			@RequestParam("accEmail") String accEmail, @RequestParam("accPassword") String accPassword,
			@RequestParam("accContact") String accContact) {
		System.out.println("Inside addAccountant() method");
		System.out.println(accName);
		System.out.println(accEmail);
		System.out.println(accPassword);
		System.out.println(accContact);

		accountant.setAccName(accName);
		accountant.setAccEmail(accEmail);
		accountant.setAccPassword(accPassword);
		accountant.setAccContact(accContact);

		adminService.save(accountant);

		ModelAndView modelAndView = new ModelAndView("AddAccountant.jsp");
		modelAndView.addObject("message", "Accountant added successfully !");
		return modelAndView;

	}

	@RequestMapping("/adminButtons")
	public ModelAndView LogoutOrAdminPanel(@RequestParam("requestAction") String requestAction) {
		System.out.println("Into LogoutOrAdminPanel !");
		ModelAndView modelAndView = null;
		if (requestAction.equals("Logout Admin")) {
			modelAndView = new ModelAndView("Login.jsp");
			modelAndView.addObject("message1", "Logged Out Successfully !");
		} else if (requestAction.equals("Admin Panel")) {
			modelAndView = new ModelAndView("AdminPanel.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("/viewAccountant")
	public ModelAndView viewAccountant() {
		System.out.println("Inside View All !");
		ArrayList<Accountant> listOfAllAccountants = adminService.findAll();
		System.out.println("listOfAllAccountants : " + listOfAllAccountants);
		ModelAndView modelAndView = new ModelAndView("ViewAccountant.jsp");
		modelAndView.addObject("listOfAllAccountants", listOfAllAccountants);
		return modelAndView;
	}

	@RequestMapping("/updateAccountantForm")
	public ModelAndView update(@RequestParam("accEmail") String accEmail) {
		Accountant accountant = adminService.findByIdAccountant(accEmail);
		ModelAndView modelAndView = new ModelAndView("EditAccountant.jsp");
		modelAndView.addObject("accountant", accountant);
		return modelAndView;
	}

	@RequestMapping("/updateAccountant")
	public ModelAndView updateEmployee(@RequestParam("accName") String accName,
			@RequestParam("accEmail") String accEmail, @RequestParam("accPassword") String accPassword,
			@RequestParam("accContact") String accContact) {

		System.out.println("In updateAccountant !");

		accountant.setAccName(accName);
		accountant.setAccEmail(accEmail);
		accountant.setAccPassword(accPassword);
		accountant.setAccContact(accContact);

		adminService.save(accountant);
		System.out.println("Accountant Updated");

		ModelAndView modelAndView = new ModelAndView("AdminPanel.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/deleteAccountant")
	public ModelAndView deleteAdmin(@RequestParam("accEmail") String accEmail)
	{
		adminService.deleteById(accEmail);
		ModelAndView modelAndView = new ModelAndView("AdminPanel.jsp");
		return modelAndView;
	}

}
