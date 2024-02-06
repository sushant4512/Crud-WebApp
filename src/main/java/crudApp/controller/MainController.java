package crudApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crudApp.dao.ProductDao;
import crudApp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products= productDao.getProducts();
		m.addAttribute("product", products);
		return "index";
	}
	
	//show the Add Product form
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	
	//handle the product form
	@RequestMapping(value="/handle-product", method=RequestMethod.POST)
	public  RedirectView handldeProduct(@ModelAttribute Product product,HttpServletRequest request) {
		RedirectView redirectView= new RedirectView();
		System.out.println(product);
		productDao.createProduct(product);
		redirectView.setUrl(request.getContextPath()+"/");
		
		return redirectView;
	}
	//Delete Handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deletePProduct(@PathVariable("productId")int productId,HttpServletRequest request) {
		productDao.deleteProduct(productId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	//update handler
	@RequestMapping("/update/{productId}")

	public String updateForm(@PathVariable("productId") int pid, Model model) {
	Product product = this.productDao.getProduct(pid); 
	model.addAttribute("product", product);

	return "update_form";

	}
	
	

}
