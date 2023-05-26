package com.ojas.jpawebapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ojas.jpawebapplication.config.ExcelGenerator;
import com.ojas.jpawebapplication.config.PdfGeneration;
import com.ojas.jpawebapplication.config.SentAttachment;
import com.ojas.jpawebapplication.model.Employee;
import com.ojas.jpawebapplication.serviceimpl.EmployeeServiceImplementation;

//import ch.qos.logback.core.model.Model;

@Controller
public class EmpController {

	@Autowired
	private EmployeeServiceImplementation serviceImpl;

	@RequestMapping(value = { "/", "/loadForm" })
	public String loadForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "addEmployees";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute Employee emp, Model model) {

		boolean saveEmp = serviceImpl.saveEmp(emp);

		String msg = "";
		if (saveEmp) {
			msg = "Employee added succesfully";
		} else {
			msg = "Not added succesfully";
		}
		model.addAttribute("msg", msg);
		return "addEmployees";
	}

	@RequestMapping("/viewEmployees")
	public String viewAllEmployees(Model model) {

		List<Employee> allEmployees = serviceImpl.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return "viewallEmployees";

	}

	@RequestMapping(value = "/editEmployee")
	public String edit(@RequestParam("eid") Integer eid, Model model) {

		Employee employee = serviceImpl.getEmployeeById(eid);
		System.out.println(employee);
		model.addAttribute("employee", employee);
		return "editEmployee";

	}

	@RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
	public String editSave(@ModelAttribute Employee emp, Model model) {
		boolean isSaved = serviceImpl.saveEmp(emp);
		String msg = "";
		if (isSaved) {
			msg = "Updated Succesfully";
		} else {
			msg = "Not Updated";
		}
		model.addAttribute("msg", msg);
		return "redirect:/viewEmployees";

	}

	@RequestMapping(value = "/deleteEmployee")
	public String deleteProduct(Model model, @RequestParam("eid") Integer eid) {

		String msg = "";
		boolean delete = serviceImpl.deleteEmployee(eid);
		if (delete) {
			msg = "deleted";
		} else {
			msg = "not deleted";
		}
		model.addAttribute("msg", msg);
		return "redirect:/viewEmployees";

	}

	@RequestMapping("/pdf")
	public String pdfGenertaor(Model model) {
		List<Employee> list = serviceImpl.getAllEmployees();
		String genetatePdf = PdfGeneration.genetatePdf(list);
		String filepah = "D:\\SpringBootMicroservices\\JpaWebapplication\\src\\main\\resources\\employee.pdf";
		String toMail = "kalyansp12@gmail.com";
		String msg = "";
		String cc = "pendyalajashwanth07@gmail.com,gdivya1232@gmail.com";
		boolean emailSend = SentAttachment.emailSend(toMail,cc, filepah);
		if (emailSend) {
			msg = "pdf generated";

		} else {
			msg = "pdf is not generated";
		}
		model.addAttribute("msg", msg);
		return "pdf";

	}

	@RequestMapping("/excel")
	public String excelGenerator(Model model) {
		List<Employee> allEmployees = serviceImpl.getAllEmployees();
		boolean excelReport = ExcelGenerator.excelReport(allEmployees);
		String filepath = "D:\\SpringBootMicroservices\\JpaWebapplication\\src\\main\\resources\\employee.xlsx";
		String toMail = "kalyansp12@gmail.com";
		String cc = "pendyalajashwanth07@gmail.com,gdivya1232@gmail.com";
		boolean emailSend = SentAttachment.emailSend(toMail,cc, filepath);
		String msg = "";
		if (emailSend)
			msg = "Excel Generated";
		else
			msg = "Excel is not Generated";
		model.addAttribute("msg", msg);
		return "excel";
	}

}
