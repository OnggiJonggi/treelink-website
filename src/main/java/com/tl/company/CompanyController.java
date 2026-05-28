package com.tl.company;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.global.exception.CustomException;
import com.tl.global.exception.ErrorCodeEnum;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
	private final CompanyService companyService;
	
	@GetMapping("/{companyNo}")
	public String goView(@PathVariable("companyNo") int companyNo
			,Model model) {
		
		CompanyVO.Detail detail = companyService.getCompanyBasicInfo(companyNo);
		if(detail==null) throw new CustomException(ErrorCodeEnum.COMPANY_NOT_FOUND);
		
		model.addAttribute("companyDetail", detail);
		
		return "company/detail";
	}
}
