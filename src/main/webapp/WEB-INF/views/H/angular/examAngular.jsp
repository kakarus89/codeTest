<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>NxApp</title>
	<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css'/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/signin.css'/>" />

</head>
<body>

<div class="container">


<%--
		<div ng-controller="UserCtrl">
			<p class="username">Welcome, {{ user.details.username }}</p>
			<p class="id">User ID: {{ user.details.id }}</p>
		</div>--%>

</div> <!-- /container -->

<script type="text/javascript" src="<c:url value='/js/jquery-1.11.2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/angular.min.js'/>"></script>
<script>
    var myApp = angular.module('myApp', []);

    myApp.controller('MainCtrl', ['$scope', function ($scope) {
        $scope.text = 'Hello!';
    }]);

$(function(){
    $('body').append(
        '<div ng-controller="MainCtrl">' +
        '{{ text }}' +
        '</div>');
})

</script>
</body>
</html>