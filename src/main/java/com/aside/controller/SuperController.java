package com.aside.controller;

import com.aside.common.CommonException;
import com.aside.common.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class SuperController {
	final static String jsonView = "JSON";
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

/*	public void checkParameter(Object obj) {
		if (obj == null) {
			throw new CommonException(ResultCode.PARAMETER_ERROR);
		}
		else if(obj instanceof String){
			if (obj == null
					|| obj.equals("")) {
				throw new CommonException(ResultCode.PARAMETER_ERROR);
			}
		}
	}*/
	public void checkParameter(Object obj){
		boolean isCheck = false;
		if (obj == null) { isCheck =  true; }
		if ((obj instanceof String) && (((String)obj).trim().length() == 0)) { isCheck =  true; }
		if (obj instanceof Map) { isCheck =  ((Map<?, ?>)obj).isEmpty(); }
		if (obj instanceof List) { isCheck =  ((List<?>)obj).isEmpty(); }
		if (obj instanceof Object[]) { isCheck =  (((Object[])obj).length == 0); }
		if (obj instanceof MultipartFile) { isCheck = (((MultipartFile) obj).getSize() == 0); }
		if(isCheck){
			throw new CommonException(ResultCode.PARAMETER_ERROR);
		}
	}
}
