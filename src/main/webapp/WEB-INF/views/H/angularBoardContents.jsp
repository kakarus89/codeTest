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
        <link type="text/css" rel="stylesheet" href="<c:url value='/css/angularBoardContents.css'/>" />
    </head>
    <body>
    <div class="container">
        <div class="container boardContentMain" id="boardConentViewDiv">

            <c:forEach var="bc" items="${content}">
                <div>
                    <div id="contentTitle">
                            ${bc.b_title}
                    </div>
                    <div id="contentWriteName">
                            ${bc.b_writename}
                    </div>
                </div>
                <div>
                    <div id="contentInfo">
                            ${bc.b_contents}
                    </div>
                </div>
                <div id="contenAttachFiles">
                    <div id="itemAttachFiles">
                        <c:forEach var="at" items="${attach}">

                        </c:forEach>
                    </div>
                </div>

                <div>
                    <div id="contentBody">
                    </div>
                </div>

            </c:forEach>



            <div>
                <div>
                    <input type="button" class="btn btn-default btn-xs" value="수정" id="btnBoardUpdateGoView">
                    <input type="button" class="btn btn-default btn-xs" value="삭제" id="btnBoardDelete">
                    <input type="hidden" id="contentSeq">
                </div>
                <div>
                    <input type="button" class="btn btn-default btn-xs" value="목록" id="moveBoardList">
                </div>
            </div>

        </div>

    </div>


    <script type="text/javascript" src="<c:url value='/js/jquery-1.11.2.js'/>"></script>
    <script src="<c:url value='/js/common.js'/>"></script>
</body>
</html>
