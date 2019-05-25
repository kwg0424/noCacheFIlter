package com.filter;

import com.util.UUIDShiftBit;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ParseContent {

	private static ParseContent instance;

	public static ParseContent getInstance() {
		if (instance == null) {
			instance = new ParseContent();
		}
		return instance;
	}

	public String setNoCache(String content, String resourcesList, String patternType) {
		String value;
		Calendar calendar = Calendar.getInstance();
		if (patternType != null && !patternType.equals("")) {
			if(patternType.startsWith("v=")){
				value = patternType;
			}
			else{
				SimpleDateFormat sdf = new SimpleDateFormat(patternType);
				value = sdf.format(calendar.getTime());
			}
		} else {
			UUIDShiftBit uuidShiftBit = new UUIDShiftBit();
			value = uuidShiftBit.randomUUID();
		}

		String element;
		String noCacheElement;
		for (String resourcesInfo : resourcesList.split(",")) {
			resourcesInfo = resourcesInfo.trim();
			String targetElement = resourcesInfo.split("=")[0];
			String src = resourcesInfo.split("=")[1];

			element = src + "=(\\'|\\\")([\\S]+)." + targetElement + "(\\?[\\S]+)(\\'|\\\")";
			noCacheElement = src + "=\"$2." + targetElement + "$3&_noCache=" + value + "\"";
			content = content.replaceAll(element, noCacheElement);

			element = src + "=(\\'|\\\")([\\S]+)." + targetElement + "(\\'|\\\")";
			noCacheElement = src + "=\"$2." + targetElement + "?_noCache=" + value + "\"";
			content = content.replaceAll(element, noCacheElement);
		}

		return content;
	}
}
