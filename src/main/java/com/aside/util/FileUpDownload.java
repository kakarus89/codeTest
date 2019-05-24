package com.aside.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

public class FileUpDownload {

    private FileOutputStream fos;

    public void fileUploadPlay(MultipartFile file, String path, String fileName) throws Exception {

        File isCkeck = new File(path);
        if(!isCkeck.exists() || !isCkeck.isDirectory()){
            isCkeck.mkdir();
        }

        isCkeck = null;


        //파일이 저장될 path 설정
        try{

            byte fileData[] = file.getBytes();

            fos = new FileOutputStream(path + "/" + fileName);


            fos.write(fileData);


        }catch(Exception e){

            e.printStackTrace();

        }finally{

            if(fos != null){

                try{
                    fos.close();
                }catch(Exception e){}

            }
        }// try end;


    }


    public void fileDownloadPlay(File file, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("DownloadView --> file.getPath() : " + file.getPath());
        System.out.println("DownloadView --> file.getName() : " + file.getName());

        httpServletResponse.setContentType("application/download; utf-8");
        httpServletResponse.setContentLength((int)file.length());

        String userAgent = httpServletRequest.getHeader("User-Agent");

        boolean ie = userAgent.indexOf("MSIE") > -1;

        String fileName = null;

        if(ie){

            fileName = URLEncoder.encode(file.getName(), "utf-8");

        } else {

            fileName = new String(file.getName().getBytes("utf-8"),"8859_1");

        }// end if;

        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        httpServletResponse.setHeader("Content-Transfer-Encoding", "binary");
        OutputStream out = httpServletResponse.getOutputStream();
        FileInputStream fis = null;

        try {

            fis = new FileInputStream(file);

            FileCopyUtils.copy(fis, out);


        } catch(Exception e){

            e.printStackTrace();

        }finally{

            if(fis != null){

                try{
                    fis.close();
                }catch(Exception e){}
            }

        }// try end;

        out.flush();

    }
}