package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.beans.Student;
import com.zensar.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	Student student;
	
	@RequestMapping("/studentLogin")
	public ModelAndView checkLogin(@RequestParam("studRoll") int studRoll,
			@RequestParam("studPassword") String studPassword) {

		System.out.println("Student Roll:" + studRoll);
		System.out.println("Student Password:" + studPassword);

		Student student = studentService.findbyIdStudent(studRoll);

		ModelAndView modelAndView;
		if ((student != null) && (student.getStudPassword().equals(studPassword))) {
			modelAndView = new ModelAndView("StudentPanel.jsp");
			modelAndView.addObject("studRoll",studRoll);
		} else {
			modelAndView = new ModelAndView("Login.jsp");
			modelAndView.addObject("message3", "Invalid Login Credentials....please try again!!!");
		}

		return modelAndView;

	}
	
	@RequestMapping("/viewStudent")
	public ModelAndView searchStudent(@RequestParam("studRoll") int studRoll)
	{
		System.out.println("Inside student view profile !");
		System.out.println("studRoll : "+studRoll);
		Student student = studentService.findbyIdStudent(studRoll);
		
		System.out.println(student);
		
		ModelAndView modelAndView = new ModelAndView("ViewStudentProfile.jsp");
		modelAndView.addObject("student", student);
		
		return modelAndView;
	}
	
	@RequestMapping("/downloadFeeReceipt")
	public ModelAndView downloadReceipt(@RequestParam("studRoll") int studRoll) {
		System.out.println("Inside downloadFeeReceipt");
		Student student = studentService.findbyIdStudent(studRoll);
		System.out.println("student to download : "+student);
		ModelAndView modelAndView = new ModelAndView("downloadReceipt.jsp");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	
	@RequestMapping("/changePasswordForm")
	public ModelAndView changePasswordForm() {
		ModelAndView modelAndView = new ModelAndView("changePasswordForm.jsp");
		//modelAndView.addObject("studRoll", studRoll);
		return modelAndView;
	}
	
	@RequestMapping("/changePassword")
	public ModelAndView changePassword(@RequestParam("studRoll") int studRoll,@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword) {
		
		System.out.println("Into Students change password method");
		System.out.println("Old Password" + oldPassword);
		System.out.println("New Password" + newPassword);
		Student student = studentService.findbyIdStudent(studRoll);
		ModelAndView mv;
		
		if (student != null && (student.getStudPassword().equals(oldPassword)) && newPassword.equals(confirmPassword)) {
			
			student.setStudPassword(newPassword);
			studentService.save(student);
			mv = new ModelAndView("changePasswordForm.jsp");
			mv.addObject("message1", "Password updated Successfully !");
			
		} else {
			mv = new ModelAndView("changePasswordForm.jsp");
			mv.addObject("message1", "Invalid Password/Confirm password mismatch..Please try again!");
		}
		System.out.println(mv);
		return mv;
	}

}
