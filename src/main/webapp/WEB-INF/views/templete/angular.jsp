<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--$('#theTmpl').tmpl(aaa);--%>
<%--getTemplete--%>
<%--
<script id="templete_boardList" type="text/x-jQuery-tmpl">
   <tr onClick="boardContentView(this,'{{= seq}}')">
         <td>{{= cnt}}</td>
         <td>{{= b_title}}</td>
         <td>{{= b_writename}}</td>
         <td>{{= reg_date}}</td>
         <td>{{= b_views}}</td>
   </tr>
</script>

--%>


<script id="templete_pagingStart" type="text/x-jQuery-tmpl">
	 <li><a href="javascript:void(0)"ng-click="gotoAfterAndBefore('start')"><span>«</span></a></li>
</script>

<script id="templete_pagingEnd" type="text/x-jQuery-tmpl">
	 <li><a href="javascript:void(0)"ng-click="gotoAfterAndBefore('end')"><span>»</span></a></li>
</script>

<script id="templete_pagingNumber" type="text/x-jQuery-tmpl">
	 <%--<li><a ng-click="gotoBoardList('{{= i}}')">{{= i}}</a></li>--%>
	 <li><a href="javascript:void(0)" ng-click="gotoBoardList('{{= i}}')">{{= i}}</a></li>
</script>
