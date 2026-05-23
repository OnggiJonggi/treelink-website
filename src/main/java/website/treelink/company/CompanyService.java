package website.treelink.company;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import website.treelink.global.exception.CustomException;

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
