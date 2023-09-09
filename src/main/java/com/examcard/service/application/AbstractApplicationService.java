package com.examcard.service.application;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.common.CodeList;
import com.examcard.constant.CodeMapKey;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.entity.CustomerApplication;
import com.examcard.repository.application.CustomerApplicationRepository;

@Service
@Transactional
public abstract class AbstractApplicationService {

	@Autowired
	private CodeList codeList;

	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;
	
	public void setCodeName(ApplicationDto applicationDto) {
		applicationDto.setDispCompanyIndustryType(codeList.getValue(
				CodeMapKey.COMPANY_INDUSTRY_TYPE, applicationDto.getCompanyIndustryType()));
		applicationDto.setDispEmploymentStatus(codeList.getValue(
				CodeMapKey.EMPLOYMENT_STATUS, applicationDto.getEmploymentStatus()));
		applicationDto.setDispSetaiFamily(codeList.getValue(
				CodeMapKey.SETAI_FAMILY, applicationDto.getSetaiFamily()));
		applicationDto.setDispSetaiLoan(codeList.getValue(
				CodeMapKey.SETAI_LOAN, applicationDto.getSetaiLoan()));
		applicationDto.setDispSetaiStatus(codeList.getValue(
				CodeMapKey.SETAI_STATUS, applicationDto.getSetaiStatus()));
		applicationDto.setDispApplicationStatus(codeList.getValue(
				CodeMapKey.APPLICATION_STATUS, applicationDto.getApplicationStatus()));
	}
	
	public ApplicationDto getApplication(String id) {
		CustomerApplication customerApplication = customerApplicationRepository.selectById(id);
		ApplicationDto customerApplicationDto = new ApplicationDto();
		BeanUtils.copyProperties(customerApplication, customerApplicationDto);
		setCodeName(customerApplicationDto);
		return customerApplicationDto;
	}
	
	protected boolean isOptimisticLockError(String id, Date updateDate) {
		ApplicationDto before = getApplication(id);
		Date beforeUpdateDate = before.getUpdateDate();
		if (updateDate.compareTo(beforeUpdateDate) != 0) {
			return true;
		}
		return false;
	}
	
	protected ApplicationDto getApplicationForUpdate(String id) {
		CustomerApplication customerApplication = customerApplicationRepository.selectByIdForUpdate(id);
		ApplicationDto customerApplicationDto = new ApplicationDto();
		BeanUtils.copyProperties(customerApplication, customerApplicationDto);
		setCodeName(customerApplicationDto);
		return customerApplicationDto;
	}
}
