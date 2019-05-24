package com.aside.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;





public class ExceptionHandlerResolver implements HandlerExceptionResolver,
		MessageSourceAware {

	@Autowired
	private MessageSource messageSource;

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception error) {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		if (error instanceof BindException) {
			error.getMessage();
			mav.addObject("error", error.getMessage());
			return mav;
		}else if (error instanceof CommonException) {
			CommonException userError = (CommonException) error;
			//에러랑 status 찍는 부분
			mav.addObject("status", userError.getCode());
			mav.addObject("error", getMessage(userError.getMessage()));
			RequestContext context = (RequestContext)request.getAttribute(Constants.REQUEST_CONTEXT);
			context.setResultCode(userError.getCode());
		}else if (error instanceof Exception) {
			error.getMessage();
			mav.addObject("error", error.getMessage());
			mav.addObject("messageSource", getMessage());
			mav.addObject("status", ResultCode.DATABASE_ERROR.value());
		}
		return mav;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		// TODO Auto-generated method stub
		this.messageSource = messageSource;
	}

	public String getMessage(String message) {
		// 메세지타입 , String[], default, locale
		// messageSource.getMessage(arg0, arg1, arg2, arg3);
		String string = messageSource.getMessage(message, null, "디폴트 오류",  // message : common.duplicate.user
				null);	
		
		return string;
	}

	public String getMessage() {
		// 메세지타입 , String[], default, locale
		// messageSource.getMessage(arg0, arg1, arg2, arg3);
		String string = messageSource.getMessage("common.unknown", null, "알 수 없는 오류",
				null);
		return string;
	}
}
