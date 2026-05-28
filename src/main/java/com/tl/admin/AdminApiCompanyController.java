package com.tl.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tl.global.api.BusinessNoCheckService;
import com.tl.global.api.BusinessNoCheckVO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminApiCompanyController {
	public final BusinessNoCheckService businessNoCheckService;
	
	/**
	 * 사업자 등록번호 진위확인
	 * @param businessNoCheckRequest
	 * @param bindingResult
	 */
	@GetMapping("/company/check-businessno")
	public ResponseEntity<String> checkBusinessNo(@Valid BusinessNoCheckVO.request businessNoCheckRequest
			,BindingResult bindingResult){
		
		if(bindingResult.hasErrors())
			return ResponseEntity.badRequest().build();
		
		businessNoCheckService.checkBusinessNo(businessNoCheckRequest);
		
		return ResponseEntity.ok().build();
	}
}
