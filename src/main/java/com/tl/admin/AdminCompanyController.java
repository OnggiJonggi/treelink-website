package com.tl.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.company.CompanyVO;
import com.tl.global.api.BusinessNoCheckVO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/company")
public class AdminCompanyController {
	AdminCompanyService adminService;
	public AdminCompanyController(AdminCompanyService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 사업체 등록 페이지로
	 */
	@GetMapping("/registor")
	public String goCompanyRegistor(Model model) {
		model.addAttribute("companyRegistor", new CompanyVO.Registor());
		model.addAttribute("BusinessNoCheckRequest", new BusinessNoCheckVO.request());
		return "admin/company/registor";
	}
	
	/**
	 * 사업체 등록
	 */
	@PostMapping("/registor")
	public String companyRegistor(
			@Valid CompanyVO.Registor companyRegistor
			,BindingResult bindingResult
			,Model model){
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("companyRegistor", new CompanyVO.Registor());
			model.addAttribute("BusinessNoCheckRequest", new BusinessNoCheckVO.request());
			return "admin/company/registor";
		}
		
		return "redirect:/company/"+adminService.companyRegistor(companyRegistor);
	}
	

	
}
