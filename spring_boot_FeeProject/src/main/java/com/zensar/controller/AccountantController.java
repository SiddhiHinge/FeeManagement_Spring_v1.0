package com.zensar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.beans.Accountant;
import com.zensar.beans.Student;
import com.zensar.service.AccountantService;

@Controller
public class AccountantController {

	@Autowired
	AccountantService accountantService;

	@Autowired
	Accountant accountant;

	@Autowired
	Student student;

	@RequestMapping("/accountantLogin")
	public ModelAndView adminLogin(@RequestParam("accEmail") String accEmail,
			@RequestParam("accPassword") String accPassword) {
		System.out.println("Into accountant login check !");
		System.out.println("accEmail" + accEmail);
		System.out.println("accPassword" + accPassword);

		Accountant accountant = accountantService.findByIdAccountant(accEmail);
		ModelAndView modelAndView;
		if (accountant != null && (accountant.getAccPassword().equals(accPassword))) {
			modelAndView = new ModelAndView("AccountantPanel.jsp");
		} else {
			modelAndView = new ModelAndView("Login.jsp");
			modelAndView.addObject("message2", "Invalid login credentials..Please try again !");
		}
		return modelAndView;
	}

	@RequestMapping("/addStudentForm")
	public ModelAndView addStudentForm() {
		System.out.println("Into addStudentForm !");
		ModelAndView modelAndView = new ModelAndView("AddStudent.jsp");
		return modelAndView;
	}

	@RequestMapping("/addStudent")
	public ModelAndView addAccountant(@RequestParam("studName") String studName, @RequestParam("studRoll") int studRoll,
			@RequestParam("studGender") String studGender, @RequestParam("studContact") String studContact,
			@RequestParam("studEmail") String studEmail, @RequestParam("studCourse") String studCourse,
			@RequestParam("studTotalFee") int studTotalFee, @RequestParam("studPaidFee") int studPaidFee) {
		System.out.println("Inside addStudent() method");
		student.setStudName(studName);
		student.setStudRoll(studRoll);
		student.setStudGender(studGender);
		student.setStudGender(studGender);
		student.setStudContact(studContact);
		student.setStudEmail(studEmail);
		student.setStudCourse(studCourse);
		student.setStudTotalFee(studTotalFee);
		student.setStudPaidFee(studPaidFee);
		int studDueFee = studTotalFee - studPaidFee;
		student.setStudDueFee(studDueFee);

		String[] tokenOfName = studName.split(" "); // split line on string separated by " "
		String studPassword = tokenOfName[0]+tokenOfName[1]+studRoll;
		System.out.println("Password : "+studPassword);
		student.setStudPassword(studPassword);

		System.out.println(student);
		accountantService.save(student);

		ModelAndView modelAndView = new ModelAndView("AddStudent.jsp");
		modelAndView.addObject("message", "Student added successfully !");
		return modelAndView;
	}

	@RequestMapping("/accountantButtons")
	public ModelAndView LogoutOrAccountantPanel(@RequestParam("requestAction") String requestAction) {
		System.out.println("Into LogoutOrAccountantPanel !");
		ModelAndView modelAndView = null;
		if (requestAction.equals("Logout Accountant")) {
			modelAndView = new ModelAndView("Login.jsp");
			modelAndView.addObject("message2", "Logged Out Successfully !");
		} else if (requestAction.equals("Accountant Panel")) {
			modelAndView = new ModelAndView("AccountantPanel.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("/viewAllStudent")
	public ModelAndView viewAllStudent() {
		System.out.println("Inside View All Student !");
		ArrayList<Student> listOfAllStudents = accountantService.findAll();
		System.out.println(listOfAllStudents);
		ModelAndView modelAndView = new ModelAndView("ViewStudent.jsp");
		modelAndView.addObject("listOfAllStudents", listOfAllStudents);
		return modelAndView;
	}

	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam("studRoll") int studRoll) {
		accountantService.deleteById(studRoll);
		ModelAndView modelAndView = new ModelAndView("AccountantPanel.jsp");
		return modelAndView;
	}

	@RequestMapping("/updateStudentForm")
	public ModelAndView editStudent(@RequestParam("studRoll") int studRoll) {
		Student student = accountantService.findByIdStudent(studRoll);
		ModelAndView modelAndView = new ModelAndView("EditStudent.jsp");
		modelAndView.addObject("student", student);
		return modelAndView;
	}

	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam("studName") String studName,
			@RequestParam("studRoll") Integer studRoll, @RequestParam("studGender") String studGender,
			@RequestParam("studContact") String studContact, @RequestParam("studEmail") String studEmail,
			@RequestParam("studCourse") String studCourse, @RequestParam("studTotalFee") int studTotalFee,
			@RequestParam("studPaidFee") int studPaidFee) {

		student.setStudName(studName);
		student.setStudRoll(studRoll);
		student.setStudGender(studGender);
		student.setStudContact(studContact);
		student.setStudEmail(studEmail);
		student.setStudCourse(studCourse);
		student.setStudTotalFee(studTotalFee);
		student.setStudPaidFee(studPaidFee);
		int studDueFee = studTotalFee - studPaidFee;
		student.setStudDueFee(studDueFee);

		accountantService.save(student);

		ModelAndView modelAndView = new ModelAndView("AccountantPanel.jsp");
		return modelAndView;

	}

	@RequestMapping("/viewStudentDue")
	public ModelAndView viewStudentDue() {
		System.out.println("Inside View All Due Student !");
		ArrayList<Student> listOfAllStudents = new ArrayList<Student>();
		ArrayList<Student> studentList = accountantService.findAll();
		for (Student student : studentList) {
			if (student.getStudDueFee() > 0) {
				listOfAllStudents.add(student);
			}
		}
		System.out.println(listOfAllStudents);
		ModelAndView modelAndView = new ModelAndView("ViewStudentDue.jsp");
		modelAndView.addObject("listOfAllStudents", listOfAllStudents);
		return modelAndView;
	}

	@RequestMapping("/searchStudentForm")
	public ModelAndView searchStudentForm() {
		ModelAndView modelAndView = new ModelAndView("SearchStudentForm.jsp");
		return modelAndView;
	}

	@RequestMapping("/searchStudent")
	public ModelAndView searchStudent(@RequestParam("studRoll") int studRoll) {
		Student student = accountantService.findByIdStudent(studRoll);
		ModelAndView modelAndView;
		if (student != null) {
			modelAndView = new ModelAndView("SearchStudent.jsp");
			modelAndView.addObject("student", student);
		} else {
			modelAndView = new ModelAndView("SearchStudentForm.jsp");
			modelAndView.addObject("message", "Student Not Found !");
		}
		return modelAndView;
	}

}
