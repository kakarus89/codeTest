package com.aside.serviceimpl;

import com.aside.dao.FileDao;
import com.aside.form.FileForm;
import com.aside.service.FileService;
import com.aside.util.FileUpDownload;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Service
public class FileServiceImpl implements FileService {

	@Resource
    FileDao fileDao;

    @Resource
    FileUpDownload fileUpDownload;


    @Override
    public void boardAttachFileDown(FileForm fileForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String fullPath = "C://fileMap/" + fileForm.getFileName();
        File file = new File(fullPath);

        try{
            fileUpDownload.fileDownloadPlay(file,httpServletRequest,httpServletResponse);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void boardFileUpload(ModelMap model, FileForm fileForm) {
        String filePath = "C://fileMap";
        try{
            fileUpDownload.fileUploadPlay(fileForm.getFile(),filePath,fileForm.getFile().getOriginalFilename());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
