<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--$('#theTmpl').tmpl(aaa);--%>
<%--getTemplete--%>

<script id="theTmpl" type="text/x-jQuery-tmpl">
	<span>{{= name}}</span>
</script>

<script id="templete_btnUpdateAttach" type="text/x-jQuery-tmpl">
	 <input type="button" class="btn btn-default btn-xs" value="삭제" onClick="attachDelete('{{= fileName}}','{{= seq}}')">
</script>

<script id="templete_attachDeleteAppendBtn" type="text/x-jQuery-tmpl">
	 <input type="file" class="form-control" id="attachFile" name = "">
</script>

<script id="templete_boardList" type="text/x-jQuery-tmpl">
   <tr onClick="boardContentView(this,'{{= seq}}')">
         <td>{{= cnt}}</td>
         <td>{{= b_title}}</td>
         <td>{{= b_writename}}</td>
         <td>{{= reg_date}}</td>
         <td>{{= b_views}}</td>
   </tr>
</script>

<script id="templete_pagingStart" type="text/x-jQuery-tmpl">
	 <li><a href="javascript:pageMoveSetting('start')"><span>«</span></a></li>
</script>

<script id="templete_pagingEnd" type="text/x-jQuery-tmpl">
	 <li><a href="javascript:pageMoveSetting('end')"><span>»</span></a></li>
</script>

<script id="templete_pagingNumber" type="text/x-jQuery-tmpl">
	 <li><a href="javascript:setBoardList('{{= i}}')" >{{= i}}</a></li>
</script>

<script id="templete_fileDownloadA" type="text/x-jQuery-tmpl">
	 <a href="javascript:location.href='{{= fileUrl}}'">{{= fileName}}</a>
</script>

