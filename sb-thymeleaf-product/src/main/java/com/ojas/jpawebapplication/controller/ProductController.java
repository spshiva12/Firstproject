package com.ojas.jpawebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ojas.jpawebapplication.model.Product;
import com.ojas.jpawebapplication.serviceimpl.ProductServiceImpl;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl serviceImpl;

	@RequestMapping(value = { "/", "/loadform" })
	public String loadForm(Model model) {

		Product pro = new Product();
		model.addAttribute("product", pro);

		return "addProduct";
	}
	
	public String addProduct(@ModelAttribute("product") Product pro, BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "addProduct";
		}
		
		boolean saveProduct = serviceImpl.saveProduct(pro);
		String msg = "";
		if(saveProduct) {
			msg = "Product Added succesfully";
		}
		else {
			msg = "not added";
		}
		model.addAttribute("msg",msg);
		return "addProduct";
	}

}
