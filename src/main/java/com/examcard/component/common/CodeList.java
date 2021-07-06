package com.examcard.component.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class CodeList {

	private static CodeList codeList = new CodeList();

	public static CodeList getInstance() {
		return codeList;
	}

	private Map<String, Map<String, String>> codeMap = new HashMap<>();

	public Map<String, Map<String, String>> getCodeMap() {
		return codeMap;
	}

	public void setCodeMap(Map<String, Map<String, String>> codeMap) {
		this.codeMap = codeMap;
	}

	public Map<String, String> getCodeMap(String group) {
		return codeMap.get(group);
	}

	public Set<Entry<String, String>> getCodeSet(String group) {
		Map<String, String> map = codeMap.get(group);
		return map.entrySet();
	}

	public String getValue(String group, String key) {
		return codeMap.get(group).get(key);
	}
}
