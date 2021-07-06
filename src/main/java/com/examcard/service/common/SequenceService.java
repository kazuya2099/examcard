package com.examcard.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.dao.common.Sequence;
import com.examcard.dao.common.SequenceDao;
import com.examcard.dto.common.UserDto;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SequenceService {

	@Autowired
	private SequenceDao sequenceDao;
	
	public String getSequence(String tableName) {
		Sequence result = sequenceDao.selectSequence(tableName);
		Integer id = result.getId();
		id++;
		UserDto userDto = AuthenticationUtil.getUserDto();
		Sequence param =  new Sequence();
		param.setId(id);
		param.setTableName(tableName);
		param.setUpdateDate(OperationDateUtil.getDate());
		param.setUpdateUser(userDto.getId());
		sequenceDao.updateSequence(param);
		String paddedId = String.format("%" + result.getLength() + "s", id, result.getPaddingChar())
				.replace(" ", result.getPaddingChar());
		return paddedId;
	}
}
