package com.aside.service;

import com.aside.form.FileForm;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {
    void boardAttachFileDown(FileForm fileForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
    void boardFileUpload(ModelMap model, FileForm fileForm);
}
