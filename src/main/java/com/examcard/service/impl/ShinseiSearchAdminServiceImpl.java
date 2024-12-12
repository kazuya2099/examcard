package com.examcard.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.examcard.component.common.MessageHelper;
import com.examcard.dto.ShinseiDto;
import com.examcard.dto.ShinseiSearchAdminInputDto;
import com.examcard.dto.ShinseiSearchAdminOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.repository.ShinseiRepository;
import com.examcard.repository.entity.ShinseiEntity;
import com.examcard.repository.entity.ShinseiSerchParamEntity;
import com.examcard.service.ShinseiSearchAdminService;

@Service
public class ShinseiSearchAdminServiceImpl implements ShinseiSearchAdminService {

	@Autowired
	private ShinseiRepository shinseiRepository;
	
	@Autowired
	private MessageHelper messageHelper;

	@Value("${rows.per.page}")
	private int ROWS_PER_PAGE;

	@Value("${pagenation.size}")
	private int PAGENATION_SIZE;

	@Value("${customer.application.search.max.count}")
	private int SEARCH_MAX_COUNT;

	public ShinseiSearchAdminOutputDto search(ShinseiSearchAdminInputDto inputDto) {
		long searchCount = count(inputDto);
		int pageNo = (inputDto.getPageNo() == null || inputDto.getPageNo() < 1) ? 1 : inputDto.getPageNo();
		int pageCount = (int) searchCount / ROWS_PER_PAGE;
		
		if (searchCount > SEARCH_MAX_COUNT) {
			throw new BusinessException(messageHelper.getMessage(
					"business.error.search.max.count", new String[] {String.valueOf(SEARCH_MAX_COUNT)}));
		}
		
		ShinseiSerchParamEntity searchParam = new ShinseiSerchParamEntity();
		BeanUtils.copyProperties(inputDto, searchParam);
		searchParam.setStart((pageNo - 1) * PAGENATION_SIZE);
		searchParam.setEnd(PAGENATION_SIZE);
		List<ShinseiEntity> shinseiEntityList = shinseiRepository.selectForJudgement(searchParam);
		List<ShinseiDto> shinseiDtoList = shinseiEntityList.stream().map(e -> {
			ShinseiDto shinseiDto = new ShinseiDto();
			BeanUtils.copyProperties(e, shinseiDto);
			return shinseiDto;
			}).collect(Collectors.toList());
		ShinseiSearchAdminOutputDto outputDto = new ShinseiSearchAdminOutputDto();
		outputDto.setPageNo(pageNo);
		outputDto.setPageCount(pageCount);
		outputDto.setPageSize(PAGENATION_SIZE);
		outputDto.setSearchCount(searchCount);
		outputDto.setCustomerApplicationDtoList(shinseiDtoList);
		return outputDto;
	}

	private long count(ShinseiSearchAdminInputDto inputDto) {
		ShinseiEntity customerApplication = new ShinseiEntity();
		BeanUtils.copyProperties(inputDto, customerApplication);
		return shinseiRepository.countForJudgement(customerApplication);
	}
}
