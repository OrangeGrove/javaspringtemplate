<%-- 
    Document   : index
    Created on : 2017.09.01., 17:19:17
    Author     : Pócsi Kornél
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
        <style>
           #tbl tr td{text-align: center} 
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>${msg}</h2>
        <table id="tbl" width="400" >
            <tr>
		<th>ID</th>
		<th>First name</th>
		<th>Last name</th>
		<th>Login name</th>		
            </tr>
            <c:forEach items="${userList}" var="item" varStatus="status">
                <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getFname()}</td>
                    <td>${item.getLname()}</td>
                    <td>${item.getLoginname()}</td>
                </tr>
            </c:forEach>    
        </table>
    </body>
</html>
