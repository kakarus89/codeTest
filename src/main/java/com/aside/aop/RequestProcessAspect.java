package com.aside.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@Aspect
@Configurable
public class RequestProcessAspect {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("requestMapping()")
	public void beforeController(JoinPoint jp) throws Throwable {
		System.out.println("############## beforeController ###########");
		boolean debug = false;
		logger.debug("Method : " + jp.getSignature().getName());
		
		
		for(Object obj : jp.getArgs()){
//			logger.debug("Obejct : "+obj);
//			logger.debug(jp.getSourceLocation() + "Method Name : " + "("+jp.getSignature().getName()+")");
//			logger.debug("jp.getKind()"+jp.getKind());
//			logger.debug("jp.getThis()"+jp.getThis());
//			System.out.println("jp.getTarget()"+jp.getTarget());
			
//			@Valid 값이 Exception???�어�?�� ?�기 ??
			if(obj instanceof BindingResult){
				BindingResult result = (BindingResult)obj;
				if(result.hasErrors()){
					throw new BindException(result);
				}
			}else if(obj instanceof ModelMap){ // 메소?�의 ?�라미터 값을 모델?�서 �?�� 주기 ?�해 
				System.out.println("############## instance of ModelMap ###########");				
				ModelMap modelMap= (ModelMap)obj;
				modelMap.clear();
			}
		}
	}
	
	@After("requestMapping()")
	public void afterController(JoinPoint joinPoint) {
		System.out.println("############## afterController ###########");		
		
		logger.debug("Method : " + joinPoint.getSignature().getName());
		for (Object arg : joinPoint.getArgs()) {
			if (arg instanceof ModelMap) {
				ModelMap model = (ModelMap) arg;
				if (!model.containsAttribute("status")) {
					System.out.println("############## model.addAttribute(status, 0) ###########");
					model.addAttribute("status", 0);
				}
			}
		}
	}

	@AfterReturning(pointcut = "requestMapping()", returning = "result")
	public void afterControllerReturning(JoinPoint joinPoint, Object result) {
		System.out.println("############## afterControllerReturning ###########");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
	}

	@AfterThrowing(pointcut = "requestMapping()", throwing = "error")
	public void afterControllerThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("############## afterControllerThrowing ###########");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		for(Object obj : joinPoint.getArgs()){
			if(obj instanceof ModelMap){
				ModelMap model = (ModelMap) obj;
				if (model.containsAttribute("error")) {
//					model.addAttribute("status", 999);
					model.addAttribute("error", error.getMessage());
				}
			}
			
		}
		
//		for(Object obj : joinPoint.getArgs()){
//			if(obj instanceof ModelMap){
//				System.out.println("afterControllerThrowing : ModelMap");
//				ModelMap modelmap = (ModelMap)obj;
//				modelmap.clear();
//				modelmap.addAttribute("error", error.getMessage());
//			}
//		}
	}
	
	public void tLog(){
		 String className = this.getClass().getSimpleName();
		 String mehodName = new Exception().getStackTrace()[0].getLineNumber()+"";
	}
	
	
	@Pointcut("controller() && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void requestMapping() {
	}
	
	@Pointcut("execution(public * com..controller..*Controller.*(..)) && @target(org.springframework.stereotype.Controller)")
	public void controller() {
	}
}
