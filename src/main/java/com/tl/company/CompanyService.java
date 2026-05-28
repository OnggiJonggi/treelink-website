package com.tl.company;

import org.springframework.stereotype.Service;

import com.tl.global.exception.CustomException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {
	private final CompanyMapper companyMapper;

	public CompanyVO.Detail getCompanyBasicInfo(int companyNo) {
		
		CompanyVO.Detail result = companyMapper.selectCompanyDetail(companyNo);
		
		if(result == null) throw new CustomException(null);
		
		return result;
	}

}
