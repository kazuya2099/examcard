package com.examcard.tags;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.AbstractHtmlElementTag;
import org.springframework.web.servlet.tags.form.TagWriter;

public class PagenationTag extends AbstractHtmlElementTag {

	private int pageNo = 1;
	
	private int pageSize;
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageCount(Integer pageCount) {
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException {
		int position = pageNo % pageSize;
		if (position < pageSize) {
			for (int i=0; i<position ; i++) {
				
			}
		}
		return 0;
	}

}
