package com.examcard.tags;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.OptionsTag;
import org.springframework.web.servlet.tags.form.TagWriter;

import com.examcard.component.common.CodeList;

public class CustomOptionsTag extends OptionsTag {

	private CodeList codeList;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	protected Object getItems() {
		codeList = CodeList.getInstance();
		return codeList.getCodeSet(id);
	}

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException {
		Object items = getItems();
		super.setItems(items);
		super.writeTagContent(tagWriter);
		return SKIP_BODY;
	}
}
