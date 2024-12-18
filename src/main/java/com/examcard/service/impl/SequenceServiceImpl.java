package com.examcard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.repository.SequenceRepository;
import com.examcard.repository.entity.Sequence;
import com.examcard.service.SequenceService;
import com.examcard.service.dto.UserDto;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SequenceServiceImpl implements SequenceService {

	@Autowired
	private SequenceRepository sequenceRepository;
	
	public String getSequence(String tableName) {
		Sequence result = sequenceRepository.selectSequence(tableName);
		Integer id = result.getId();
		id++;
		UserDto userDto = AuthenticationUtil.getUserDto();
		Sequence param =  new Sequence();
		param.setId(id);
		param.setTableName(tableName);
		param.setUpdateDate(OperationDateUtil.getDate());
		param.setUpdateUser(userDto.getId());
		sequenceRepository.updateSequence(param);
		String paddedId = String.format("%" + result.getLength() + "s", id, result.getPaddingChar())
				.replace(" ", result.getPaddingChar());
		return paddedId;
	}
}
