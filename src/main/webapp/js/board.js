$(function () {
    $("#moveBoardList").on("click",function(){changeView("list")});
    $("#btnBoardWrite").on("click",function(){changeView("write")});
    $("#btnBoardWriteGoList").on("click",function(){changeView("list")});
    $("#btnBoardWritePlay").on("click",function(){

        var files = $('#attachFile')[0].files;
        var fileData = new FormData();console.log(files);
        $.each(files,function(i,value){
            fileData.append("file",files[i]);
        });

        fileData.append("b_title",$("#b_title").val().trim());
        fileData.append("b_contents",$("#b_contents").val().trim());
        fileData.append("b_writename",$("#b_writename").val().trim());



        jQuery.ajax({
            type:"POST",
            url:"/board/write",
            data:fileData,
            async:false,
            cache:false,
            contentType:false,
            processData:false,
            dataType:"json",
            success : function(result) {
                console.log(result);
                location.href="/board";
            }
        });
    });

    $("#btnBoardDelete").on("click",function(){
        jQuery.ajax({
            type:"POST",
            url:"/board/delete",
            data:{
                "seq" :$("#btnBoardDelete").parent().eq(0).children().eq(2).val().trim()
            },
            dataType:"json",
            success : function(result) {
                console.log(result);
                location.reload();
            }
        });
    });

    $("#btnBoardUpdateGoView").on("click",function(){

        var seq = $("#contentSeq").val().trim();
        var title = $("#contentTitle").text().trim();
        var name = $("#contentWriteName > span").text().trim();
        var content = $("#contentBody").text().trim();
        var attach = $("#itemAttachFiles").eq(0).children("a");
        changeView("update");

        $("#b_title").val(title);
        $("#b_contents").val(content);
        $("#b_writename").val(name);
        $("#writeSeq").val(seq);

        if(attach.length != 0){
            var fileName = attach.attr("href").split("fileName=")[1].split("'")[0].trim();
            $("#updateAttach").html(attach);
            $("#updateAttach").append(getTemplete("#templete_btnUpdateAttach",[{
                "fileName" : fileName,
                "seq" : seq
            }]));
        }
    });

    $("#btnBoardUpdatePlay").on("click",function(){
        var dt = {
            "b_title" :$("#b_title").val().trim(),
            "b_contents" : $("#b_contents").val().trim(),
            "b_writename" : $("#b_writename").val().trim(),
            "seq" : $("#writeSeq").val().trim()
        };

        var fileData = new FormData();



        if($('#attachFile').length !== 0){
            var files = $('#attachFile')[0].files;
            $.each(files,function(i,value){
                fileData.append("file",files[i]);
            });

        }


        fileData.append("b_title",$("#b_title").val().trim());
        fileData.append("b_contents",$("#b_contents").val().trim());
        fileData.append("b_writename",$("#b_writename").val().trim());
        fileData.append("seq",$("#writeSeq").val().trim());
        fileData.append("boardSeq",$("#writeSeq").val().trim());


        jQuery.ajax({
            type:"POST",
            url:"/board/update",
            data:fileData,
            async:false,
            cache:false,
            contentType:false,
            processData:false,
            dataType:"json",
            success : function(result) {
                changeUpdate(dt);
                changeView("list");
            }
        });
    });

    pageSetting();
});

function attachDelete(fileName,seq){
    jQuery.ajax({
        type:"POST",
        url:"/board/attach/delete",
        data:{
            "fileName" : fileName,
            "seq" : seq
        },
        dataType:"json",
        success : function(result) {
            $("#updateAttach").html(getTemplete("#templete_attachDeleteAppendBtn",null));
        }
    });
}

function changeUpdate(dt){
    var list = $("#boardListTable").children("tbody").eq(0).children("tr");
    var seq = dt.seq;
    $.each(list,function(i,value){
        var tmpSeq = list.eq(i).attr("id").split("_")[1].trim();
        if(seq === tmpSeq){
            list.eq(i).children("td").eq(1).text(dt.b_title);
            list.eq(i).children("td").eq(2).text(dt.b_writename);
            return false;
        }
    });
}


function allNone() {
    $("#boardConentViewDiv").css("display","none");
    $("#boardListTable").css("display","none");
    $("#boardWriteDiv").css("display","none");
    $("#attachFile").val("");


    $("#contentTitle").text();
    $("#contentWriteName").text();
    $("#contentInfo").text();
    $("#contentBody").text();
    $("#contentSeq").val();
    $("#contenAttachFiles").children("div").eq(0).text("");

    $("#b_writename").val("");
    $("#b_title").val("");
    $("#b_contents").val("");
    $("#btnBoardUpdatePlay").css("display","none");
    $("#btnBoardWritePlay").css("display","");
    $("#updateAttach").html(getTemplete("#templete_attachDeleteAppendBtn",null));

}

function setBoardList(a){
    jQuery.ajax({
        type:"POST",
        url:"/board",
        data:{
            "pageNum" : a
        },
        dataType:"json",
        success : function(result) {
           console.log(result);
            $("#boardList").empty();
           var list = result.list;
           var cnt = (result.pag).totalCount-(((result.pag).pageNum-1)*(result.pag).listCount);
           $.each(list,function(i,value){
               var dt = [{
                   "seq" : list[i].seq,
                   "cnt" : cnt,
                   "b_title" : list[i].b_title,
                   "b_writename" : list[i].b_writename,
                   "reg_date" : new Date(list[i].reg_date).format("yyyy-MM-dd hh:mm:ss"),
                   "b_views" : list[i].b_views
               }];
               console.log(getTemplete("#attachDeleteAppendBtn",dt));
               $("#boardList").append(getTemplete("#templete_boardList",dt));
               cnt--;
           });
        }
    });

}

function pageSetting(){
    console.log("pageSetting");
    $("#paging").empty();
    if(startPage > 10){
        $("#paging").append(getTemplete("#templete_pagingStart",null));
    }

    for(var i=startPage; i<=endPage; i++){
        $("#paging").append(getTemplete("#templete_pagingNumber",[{
            "i" : i
        }]));
    }

    if((totalPage - endPage) > 0){
        $("#paging").append(getTemplete("#templete_pagingEnd",null));
    }
}

function pageMoveSetting(type){
    if(type === "end"){
        startPage = endPage+1;
        endPage = startPage + 10 -1;

        if(endPage > totalPage){
            endPage = totalPage;
        }

        pageSetting();
    }

    if(type === "start"){
        startPage = startPage-10;
        endPage = endPage - 10;

        if(startPage <= 0){
            startPage = 1;
        }

        pageSetting();
    }
}

function getTemplete(obj,value){
    return $(obj).tmpl(value);
}

function boardContentView(divInfo,seq){

    jQuery.ajax({
        type:"POST",
        url:"/board/content",
        data:{
            "seq" : seq
        },
        dataType:"json",
            success : function(result) {
            changeView("content");

            var r = (result.content)[0];
            $("#contentTitle").text(r.b_title);
            $("#contentWriteName > span").text(r.b_writename);
            $("#contentInfo").text(getInfo(r.b_views,new Date(r.reg_date).format("yyyy-MM-dd hh:mm:ss"),new Date(r.b_regdate).format("yyyy-MM-dd hh:mm:ss")));
            $("#contentBody").text(r.b_contents);
            $("#contentSeq").val(r.seq);

            var f = (result.attach);
            $.each(f , function(i,value){
                var fileUrl = '/file/download?fileName='+f[i].fileName;
                $("#contenAttachFiles").children("div").eq(0).append(getTemplete("#templete_fileDownloadA",[{
                    "fileUrl" : fileUrl,
                    "fileName" : f[i].fileName
                }]));
            });
            $(divInfo).children("td").eq(4).text(r.b_views);
         }
    });

}


function changeView(type){
    allNone();
    pageSetting();
    if(type === "content"){
        $("#boardConentViewDiv").css("display","block");
    }

    if(type === "list"){
        $("#boardListTable").removeAttr("style");
    }

    if(type === "write"){
        $("#boardWriteDiv").css("display","block");
    }

    if(type === "update"){
        $("#boardWriteDiv").css("display","block");
        $("#btnBoardWritePlay").css("display","none");
        $("#btnBoardUpdatePlay").css("display","");
    }

}

function getInfo(views,dates,lastDate){
    return "  등록일 :  "+ dates+ "   최종 수정일 : " + lastDate+"    조회 수 :  "+views ;
}





