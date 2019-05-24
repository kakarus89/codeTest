package com.aside.dao;

import com.aside.form.BoardForm;
import com.aside.model.BoardModel;
import com.sun.org.apache.bcel.internal.generic.BIPUSH;

import java.util.List;

public interface BoardDao {
/*	public List<SampleCP> testApi(SampleCP cp);

	public List<SampleSP> testlogin(SampleCP cp);*/

    List<BoardModel> boardSerach(BoardForm boardForm);
    int boardWrite(BoardForm boardForm);
    int boardDelete(BoardForm boardForm);
    int boardUpdate(BoardForm boardForm);
    int boardViewCount(BoardForm boardForm);
    int boardTotalCount();
    List<BoardModel> boardContentAttachList(BoardForm boardForm);
    int boardAttacFileUpload(BoardForm form);
    int boardAttachFileDelete(BoardForm form);

}
