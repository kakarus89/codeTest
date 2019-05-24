package com.aside.controller;

import com.aside.form.BoardForm;
import com.aside.form.FileForm;
import com.aside.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController extends SuperController{
	
	@Resource
	BoardService boardservice;


	@RequestMapping(value = "/board", method = RequestMethod.POST)
	public String boardListPost(ModelMap model, BoardForm boardForm) {
		boardservice.boardList(model,boardForm);
		return jsonView;
	}

	@RequestMapping(value = "/board/content", method = RequestMethod.POST)
	public String boardContent(ModelMap model, BoardForm boardForm) {
		boardservice.boardViewCount(model,boardForm);
		boardservice.boardConent(model,boardForm);
		return jsonView;
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String boardWrite(ModelMap model, BoardForm boardForm) {
		boardservice.boardWrite(model,boardForm);
		return jsonView;
	}

	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String boardUpdate(ModelMap model, BoardForm boardForm) {
		boardservice.boardUpdate(model,boardForm);
		return jsonView;
	}

	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String boardDelete(ModelMap model, BoardForm boardForm) {
		boardservice.boardDelete(model,boardForm);
		return jsonView;
	}

	@RequestMapping(value = "/board/attach/delete", method = RequestMethod.POST)
	public String attachDelete(ModelMap model, BoardForm boardForm) {
		boardservice.boardAttachDelete(model,boardForm);
		return jsonView;
	}
	

}
