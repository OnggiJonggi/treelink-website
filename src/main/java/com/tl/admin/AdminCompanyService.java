package com.tl.admin;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tl.company.CompanyMapper;
import com.tl.company.CompanyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminCompanyService{
	private final CompanyMapper companyMapper;
	
	@Transactional
	public int companyRegistor(CompanyVO.Registor companyRegistor) {
		// 회사 등록
		companyMapper.insertCompany(companyRegistor);
		
		// 주 종목 등록
		if(companyRegistor.getOption() != null) {
			companyMapper.insertCompanySpecialty(
					companyRegistor.getCompanyNo()
					,companyRegistor.getOption()
					,companyRegistor.getEtcMemo());
		}
		
		return companyRegistor.getCompanyNo();
	}

}
