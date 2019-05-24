<%--
  Created by IntelliJ IDEA.
  User: Hyun
  Date: 2019-01-02
  Time: 오후 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html ng-app="board">
    <head>
        <title>Title</title>
        <link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css'/>" />
        <link type="text/css" rel="stylesheet" href="<c:url value='/css/signin.css'/>" />
    </head>
    <body>
    <div class="container" ng-controller="list">
        <table class="table table-striped">
            <thead>
            <tr>
                <th >#</th>
                <th>TITLE</th>
                <th>Writer</th>
                <th>REG_DATE</th>
                <th>ViEWS</th>
            </tr>
            </thead>
            <tbody>
                <tr ng-repeat="boardList in boardList" ng-click="gotoContent(boardList.seq)" style="cursor: pointer;">
                    <td>{{ boardList.cnt }}</td>
                    <td>{{ boardList.b_title }}</td>
                    <td>{{ boardList.b_writename }}</td>
                    <td>
                        {{ boardList.reg_date }}
                    </td>
                    <td>{{ boardList.b_views }}</td>
                </tr>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="5">
                    <ul class="pagination" id="paging">
                    </ul>
                </td>
            </tr>
            </tfoot>
        </table>

    </div>


    <script type="text/javascript" src="<c:url value='/js/jquery-1.11.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/angular-1.7.5/angular.js'/>"></script>
    <%--<script type="text/javascript" src="<c:url value='/js/angular.min.js'/>"></script>--%>
    <script type="text/javascript" src="<c:url value='/js/jquery.tmpl.js'/>"></script>
    <script src="<c:url value='/js/common.js'/>"></script>
    <jsp:include page="/templete/angular"/>
    <script>
        var startPage = ${pag.startPage};
        var endPage = ${pag.endPage};
        var totalPage = ${pag.totalPage};
        var boardApp = angular.module("board",[]);
        boardApp.controller('list', ['$scope','$http', '$compile', 'boardService', function ($scope,$http,$compile,boardService) {

            $scope.gotoContent = function(rowNum){
                location.href="/angularBoardContents?seq="+rowNum;
            }

            $scope.gotoBoardList = function(pageNum){
                boardService.newList($scope,$http,boardService, pageNum , $compile);
            };
            $scope.gotoAfterAndBefore = function(type){
                if(type === "end"){
                    startPage = endPage+1;
                    endPage = startPage + 10 -1;

                    if(endPage > totalPage){
                        endPage = totalPage;
                    }

                }

                if(type === "start"){
                    startPage = startPage-10;
                    endPage = endPage - 10;

                    if(startPage <= 0){
                        startPage = 1;
                    }

                }

                boardService.paging(startPage,endPage,totalPage,$scope ,$compile);
            };
            // boardService.newList($scope,$http,boardService, 5 , $compile);
            boardService.newList($scope,$http,boardService, null, $compile);
        }]);


        boardApp.service('boardService',function(){
            this.newList = function($scope,$http,boardService, pageNum, $compile){
                $http({
                    method: 'POST',
                    url: '/board',
                    params : {
                        "pageNum" : pageNum
                    },
                    headers: {
                        'Content-Type': 'application/json; charset=utf-8'
                    }
                })
                    .then(function onSuccess(response) {
  //                      console.log(response);
                        var data = response.data.list;
                        var cnt = (response.data.pag).totalCount-(((response.data.pag).pageNum-1)*(response.data.pag).listCount);
                        $.each(data, function(i,value){
                            data[i].reg_date = new Date(data[i].reg_date).format("yyyy-MM-dd hh:mm:ss");
                            data[i].cnt  = cnt;
                            cnt--;
                        });
                        $scope.boardList = data;
//                        console.log(response.data.pag);
                        var startPage = response.data.pag.startPage;
                        var endPage = response.data.pag.endPage;
                        var totalPage = response.data.pag.totalPage;
                        boardService.paging(startPage,endPage,totalPage,$scope,$compile);


                    }, function onError(response) {
                        console.log(response);
                    });
            };

            this.paging = function(p_startPage,p_endPage,p_totalPage,$scope,$compile){
                angular.element("#paging").empty();
                if(p_startPage > 10){
                    setTemplete("#templete_pagingStart",null,$compile,$scope);
                }


                for(var i=p_startPage*1; i<=p_endPage*1; i++){
                    setTemplete("#templete_pagingNumber",[{
                        "i" : i
                    }],$compile,$scope);
                }

                if((p_totalPage - p_endPage) > 0){
                    setTemplete("#templete_pagingEnd",null,$compile,$scope);
                }
            }

        });

        function setTemplete(obj,value,$compile,$scope){
            var templete = $(obj).tmpl(value);
            $("#paging").append(templete);
            $compile(templete)($scope);
        }



    </script>
</body>
</html>
