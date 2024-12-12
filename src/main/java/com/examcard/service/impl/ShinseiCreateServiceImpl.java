package com.examcard.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.constant.ShinseiStatus;
import com.examcard.dto.ShinseiCreateInputDto;
import com.examcard.dto.ShinseiCreateOutputDto;
import com.examcard.exception.BusinessException;
import com.examcard.repository.ShinseiRepository;
import com.examcard.repository.entity.ShinseiEntity;
import com.examcard.service.ShinseiCreateService;
import com.examcard.util.common.OperationDateUtil;

@Service
public class ShinseiCreateServiceImpl implements ShinseiCreateService {

	@Autowired
	private ShinseiRepository shinseiRepository;
	
	@Autowired
	private SequenceServiceImpl sequenceService;
	
	@Transactional
	public ShinseiCreateOutputDto execute(ShinseiCreateInputDto inputDto) {
		String id = sequenceService.getSequence("m_customer_apl");
		ShinseiEntity shinseiEntity = new ShinseiEntity();
		BeanUtils.copyProperties(inputDto, shinseiEntity);
		shinseiEntity.setId(id);
		shinseiEntity.setCreateDate(OperationDateUtil.getDate());
		shinseiEntity.setUpdateDate(OperationDateUtil.getDate());
		shinseiEntity.setApplicationStatus(ShinseiStatus.APPLICATION.getCode());
		long count = shinseiRepository.insert(shinseiEntity);
		if (count == 0) {
			throw new BusinessException("申請の登録に失敗しました。");
		}
		ShinseiCreateOutputDto outputDto = new ShinseiCreateOutputDto();
		return outputDto;
	}
	
	@Transactional
	public ShinseiCreateOutputDto update(ShinseiCreateInputDto inputDto) {
		ShinseiEntity shinseiEntity = new ShinseiEntity();
		BeanUtils.copyProperties(inputDto, shinseiEntity);
		shinseiEntity.setId(inputDto.getId());
		shinseiEntity.setUpdateDate(OperationDateUtil.getDate());
		long count = shinseiRepository.update(shinseiEntity);
		if (count == 0) {
			throw new BusinessException("申請の更新に失敗しました。");
		}
		ShinseiCreateOutputDto outputDto = new ShinseiCreateOutputDto();
		return outputDto;
	}
}
