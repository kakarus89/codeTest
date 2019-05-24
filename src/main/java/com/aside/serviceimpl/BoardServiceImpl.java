package com.aside.serviceimpl;

import com.aside.dao.BoardDao;
import com.aside.form.BoardForm;
import com.aside.model.BoardModel;
import com.aside.model.CommonModel;
import com.aside.service.BoardService;
import com.aside.util.FileUpDownload;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Resource
    BoardDao boardDao;

    @Resource
    FileUpDownload fileUpDownload;

    @Override
    public void boardList(ModelMap model, BoardForm boardForm) {
        int startNum = boardForm.getPageItemCount()*(boardForm.getPageNum()-1);
        boardForm.setStartNum(startNum);
        boardForm.setEndNum(boardForm.getPageItemCount());

        List<BoardModel> boardList = boardDao.boardSerach(boardForm);
        model.addAttribute("list",boardList);
        model.addAttribute("pag",paging(boardForm));
    }

    @Override
    public void boardPaging(ModelMap model, BoardForm boardForm) {
        model.addAttribute("pag",paging(boardForm));
    }

    public HashMap<String, String> paging(BoardForm boardForm){
        HashMap<String, String> hm = new HashMap<String, String>();

        int totalCount = boardDao.boardTotalCount();
        int listCount = boardForm.getPageItemCount();
        int totalPage = totalCount / listCount;
        int page = boardForm.getPageNum();
        int pageCount = 10;



        if(totalCount % listCount > 0){
            totalPage++;
        }

        if(totalPage < page){
            page = totalPage;
        }

        int startPage = ((page-1)/pageCount)*pageCount+1;
        int endPage = startPage + pageCount - 1;

        if(endPage > totalPage){
            endPage = totalPage;
        }

        hm.put("pageNum",page+"");
        hm.put("startPage",startPage+"");
        hm.put("endPage",endPage+"");
        hm.put("totalPage",totalPage+"");
        hm.put("totalCount",totalCount+"");
        hm.put("listCount",listCount+"");

        return hm;
    }

    @Override
    public void boardConent(ModelMap model, BoardForm boardForm) {

        model.addAttribute("attach",boardDao.boardContentAttachList(boardForm));
        model.addAttribute("content",boardDao.boardSerach(boardForm));
    }

    @Override
    public void boardWrite(ModelMap model, BoardForm boardForm) {
        System.out.println(boardForm.toString());
        boardDao.boardWrite(boardForm);
        //fileUpDownload
        try {
            if(boardForm.getFile() != null && !boardForm.getFile().isEmpty()) {
                fileUpDownload.fileUploadPlay(boardForm.getFile(),"C://fileMap",boardForm.getFile().getOriginalFilename());
                boardForm.setFileName(boardForm.getFile().getOriginalFilename());
                boardDao.boardAttacFileUpload(boardForm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

       // model.addAttribute("content",boardDao.boardWrite(boardForm));
    }

    @Override
    public void boardDelete(ModelMap model, BoardForm boardForm) {
        boardDao.boardDelete(boardForm);
        boardDao.boardAttachFileDelete(boardForm);
    }

    @Override
    public void boardUpdate(ModelMap model, BoardForm boardForm) {
        boardDao.boardUpdate(boardForm);
        try {
            if(boardForm.getFile() != null && !boardForm.getFile().isEmpty()) {
                if(boardForm.getFile() != null){
                    fileUpDownload.fileUploadPlay(boardForm.getFile(),"C://fileMap",boardForm.getFile().getOriginalFilename());
                    boardForm.setFileName(boardForm.getFile().getOriginalFilename());
                }
                boardDao.boardAttacFileUpload(boardForm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void boardViewCount(ModelMap model, BoardForm boardForm) {
        boardDao.boardViewCount(boardForm);
    }

    @Override
    public void boardAttachDelete(ModelMap model, BoardForm boardForm) {
        boardDao.boardAttachFileDelete(boardForm);
    }


}
