package com.examcard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.common.MessageHelper;
import com.examcard.dto.ShinseiDto;
import com.examcard.dto.ShinseiSearchInputDto;
import com.examcard.dto.ShinseiSearchOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.repository.ShinseiRepository;
import com.examcard.repository.entity.ShinseiEntity;
import com.examcard.repository.entity.ShinseiSerchParamEntity;
import com.examcard.service.ShinseiSearchService;

@Service
@Transactional
public class ShinseiSearchServiceImpl implements ShinseiSearchService {

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

	public ShinseiSearchOutputDto search(ShinseiSearchInputDto inputDto) {
		long searchCount = count(inputDto);
		int pageNo = (inputDto.getPageNo() == null || inputDto.getPageNo() < 1) ? 1 : inputDto.getPageNo();
		int pageCount = (int) searchCount / ROWS_PER_PAGE;
		
		if (searchCount > SEARCH_MAX_COUNT) {
			throw new BusinessException(messageHelper.getMessage(
					"business.error.search.max.count", new String[] {String.valueOf(SEARCH_MAX_COUNT)}));
		}
		
		ShinseiSerchParamEntity customerApplicationSearchParam = new ShinseiSerchParamEntity();
		BeanUtils.copyProperties(inputDto, customerApplicationSearchParam);
		customerApplicationSearchParam.setStart((pageNo - 1) * PAGENATION_SIZE);
		customerApplicationSearchParam.setEnd(PAGENATION_SIZE);
		List<ShinseiEntity> shinseiEntityList = shinseiRepository.select(customerApplicationSearchParam);
		List<ShinseiDto> shinseiDtoList = new ArrayList<>();
		for (ShinseiEntity e : shinseiEntityList) {
			ShinseiDto dto = new ShinseiDto();
			BeanUtils.copyProperties(e, dto);
			shinseiDtoList.add(dto);
		}
		ShinseiSearchOutputDto outputDto = new ShinseiSearchOutputDto();
		outputDto.setPageNo(pageNo);
		outputDto.setPageCount(pageCount);
		outputDto.setPageSize(PAGENATION_SIZE);
		outputDto.setSearchCount(searchCount);
		outputDto.setShinseiDtoList(shinseiDtoList);
		return outputDto;
	}

	private long count(ShinseiSearchInputDto inputDto) {
		ShinseiEntity customerApplication = new ShinseiEntity();
		BeanUtils.copyProperties(inputDto, customerApplication);
		return shinseiRepository.count(customerApplication);
	}
}
