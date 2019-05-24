package com.aside.service;

import com.aside.form.BoardForm;
import org.springframework.ui.ModelMap;

public interface BoardService {
	//public List<SampleCP> testApi(ModelMap model, SampleCP sampleCP);
	
	
	//public String testlogin(ModelMap model, SampleCP sampleCP);

    void boardList(ModelMap model, BoardForm boardForm);
    void boardConent(ModelMap model, BoardForm boardForm);
    void boardWrite(ModelMap model, BoardForm boardForm);
    void boardDelete(ModelMap model, BoardForm boardForm);
    void boardUpdate(ModelMap model, BoardForm boardForm);
    void boardViewCount(ModelMap model, BoardForm boardForm);
    void boardAttachDelete(ModelMap model, BoardForm boardForm);
    void boardPaging(ModelMap model, BoardForm boardForm);

}
