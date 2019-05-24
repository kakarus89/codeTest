package com.aside.controller;


import com.aside.form.FileForm;
import com.aside.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController extends SuperController {

	@Resource
	FileService fileService;

/*	@Scheduled(cron = "1/2 * * * * *")
    public void vCubeConnector(){
		mm.addAttribute("list", "oho");
		System.out.println("loading...");
    }*/




	@RequestMapping(value = "/file/upload", method = RequestMethod.POST)
	public String fileUpload(ModelMap model, FileForm form) {
		checkParameter(form.getFile());
		fileService.boardFileUpload(model,form);
		return jsonView;
	}

	@RequestMapping(value = "/file/download", method = RequestMethod.GET)
	public void fileDownload(ModelMap model, FileForm fileForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		fileService.boardAttachFileDown(fileForm,httpServletRequest,httpServletResponse);
	}


}
