package com.aside.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.aside.service.SampleService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SampleController extends SuperController{
	
	@Resource
	SampleService sampleservice;
	
/*	@Scheduled(cron = "1/2 * * * * *")
    public void vCubeConnector(){
		mm.addAttribute("list", "oho");
		System.out.println("loading...");
    }*/
	

}
