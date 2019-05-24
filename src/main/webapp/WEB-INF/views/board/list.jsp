<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>NxApp</title>
	<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css'/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/signin.css'/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/board.css'/>" />
</head>
<body>

<div class="container">

	<table class="table table-hover" id="boardListTable">
		<caption>
			<input type="button" class="btn btn-danger btn-lg" value="글쓰기" id="btnBoardWrite">
		</caption>
		<thead>
			<tr>
				<th >#</th>
				<th>TITLE</th>
				<th>Writer</th>
				<th>REG_DATE</th>
				<th>ViEWS</th>
			</tr>
		</thead>
		<tbody id="boardList">
			<c:set var="cnt" value="${pag.totalCount}"/>
			<c:forEach var="item" items="${list}">
				<tr id="board_${item.seq}" onClick="boardContentView(this,${item.seq})">
					<td>${cnt}</td>
					<td>${item.b_title}</td>
					<td>${item.b_writename}</td>
					<td>
						<fmt:formatDate value="${item.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>${item.b_views}</td>
				</tr>
				<c:set var="cnt" value="${cnt-1}"/>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<ul class="pagination" id="paging"></ul>
				</td>
			</tr>
		</tfoot>
	</table>
<div id="bbb"></div>
	<div class="container boardContentMain" id="boardConentViewDiv">


		<div>
			<div id="contentTitle">
			</div>
			<div id="contentWriteName">
				작성자 : <span></span>
			</div>
		</div>
		<div>
			<div id="contentInfo">
			</div>
		</div>
		<div id="contenAttachFiles">
			<div id="itemAttachFiles">
			</div>
		</div>

		<div>
			<div id="contentBody">
			</div>
		</div>

		<div>
			<div>
				<input type="button" class="btn btn-default btn-lg" value="수정" id="btnBoardUpdateGoView">
				<input type="button" class="btn btn-default btn-lg" value="삭제" id="btnBoardDelete">
				<input type="hidden" id="contentSeq">
			</div>
			<div>
				<input type="button" class="btn btn-default btn-lg" value="목록" id="moveBoardList">
			</div>
		</div>

	</div>

	<div class="container boardWriteMain" id="boardWriteDiv">
		<div>
			<div>작성자</div>
			<div><input type="text" class="form-control" id="b_writename" name="b_writename"></div>
		</div>
		<div>
			<div>첨부파일</div>
			<div id="updateAttach"><input type="file" class="form-control" id="attachFile" name = ""></div>
		</div>
		<div>
			<div>제목</div>
			<div><input type="text" class="form-control" id="b_title" name = "b_title"></div>
		</div>
		<div>
			<div>내용</div>
			<div><textarea class="form-control" id="b_contents"></textarea></div>
		</div>
		<div>

			<div>
				<input type="button" class="btn btn-lg btn-danger" value="작성" id="btnBoardWritePlay">
				<input type="button" class="btn btn-lg btn-danger" value="수정" id="btnBoardUpdatePlay">
				<input type="hidden" id="writeSeq">
				<input type="button" class="btn btn-lg btn-primary" value="뒤로가기" id="btnBoardWriteGoList">
			</div>
		</div>

	</div>






</div> <!-- /container -->


<script type="text/javascript" src="<c:url value='/js/jquery-1.11.2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.tmpl.js'/>"></script>
<script src="<c:url value='/js/common.js'/>"></script>
<script src="<c:url value='/js/ie10-viewport-bug-workaround.js'/>"></script>
<script>
    var startPage = ${pag.startPage};
    var endPage = ${pag.endPage};
    var totalPage = ${pag.totalPage};
</script>
<script src="<c:url value='/js/board.js'/>"></script>
<jsp:include page="/templete/templeteMap"/>
</body>
</html>
