package com.aside.form;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class BoardForm extends  CommonForm{
    private String seq;
    private String b_title;
    private String b_contents;
    private String b_writename;
    private String fileName;
    private MultipartFile file;
    private MultipartFile[] files;

    @Override
    public String toString() {
        return "BoardForm{" +
                "seq='" + seq + '\'' +
                ", b_title='" + b_title + '\'' +
                ", b_contents='" + b_contents + '\'' +
                ", b_writename='" + b_writename + '\'' +
                ", fileName='" + fileName + '\'' +
                ", file=" + file +
                ", files=" + Arrays.toString(files) +
                '}';
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getB_title() {
        return b_title;
    }

    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    public String getB_contents() {
        return b_contents;
    }

    public void setB_contents(String b_contents) {
        this.b_contents = b_contents;
    }

    public String getB_writename() {
        return b_writename;
    }

    public void setB_writename(String b_writename) {
        this.b_writename = b_writename;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
