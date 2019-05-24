package com.aside.controller;

import com.aside.form.BoardForm;
import com.aside.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class PageController {
    @Resource
    BoardService boardservice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, ModelMap model, HttpServletRequest request) {
        return "index";
    }


    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String boardList(ModelMap model, BoardForm boardForm) {
        boardservice.boardList(model,boardForm);
        return "board/list";
    }

    @RequestMapping(value = "/angularBoard", method = RequestMethod.GET)
    public String angularBoardList(ModelMap model, BoardForm boardForm) {
        boardservice.boardPaging(model,boardForm);
        return "H/angularBoard";
    }

    @RequestMapping(value = "/angularBoardContents", method = RequestMethod.GET)
    public String angularBoardContents(ModelMap model, BoardForm boardForm) {
        boardservice.boardViewCount(model,boardForm);
        boardservice.boardConent(model,boardForm);
        return "H/angularBoardContents";
    }


    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public String filePage(Locale locale, ModelMap model) {
        //new AgentStatusController();
        return "file/file";
    }


    @RequestMapping(value = "/templete/templeteMap", method = RequestMethod.GET)
    public String templeteMap(Locale locale, ModelMap model) {
        return "templete/templete";
    }

    @RequestMapping(value = "/templete/angular", method = RequestMethod.GET)
    public String angularTempleteMap(Locale locale, ModelMap model) {
        return "templete/angular";
    }


    @RequestMapping(value = "/angular/examAngular", method = RequestMethod.GET)
    public String examAngular(Locale locale, ModelMap model) {
        return "angular/examAngular";
    }




}
