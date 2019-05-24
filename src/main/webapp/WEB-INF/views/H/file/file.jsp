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
</head>
<body>
    <div class="container">
        <h2>파일 업로드 <small>by</small></h2>
        <form id="f" action="file/upload" enctype="multipart/form-data" METHOD="post">
            <input type="file" class="form-control" name="bfile">
            <input type="submit" value="전송">
        </form>
    </div>



</body>
</html>