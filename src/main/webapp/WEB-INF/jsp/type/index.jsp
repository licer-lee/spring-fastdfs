<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/02/12
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>type demo</title>
</head>
<body>

    <h1>列表</h1>
    <table border="1">
        <thead>
        <tr>
            <td>id</td>
            <td>编号</td>
            <td>名称</td>
            <td>操作</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${types}" var="t" >
            <tr>
                <td>${t.typeId}</td>
                <td>${t.typeCode}</td>
                <td>${t.typeName}</td>
                <td><a href="${pageContext.request.contextPath}/file/download/${a.fileId}">下载</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>新增</h1>
    <form action="${pageContext.request.contextPath}/type/save" method="post" >
        <h3>upload file</h3>
        <input type="text" name="typeId" /><br>
        <input type="text" name="typeCode" /><br>
        <input type="text" name="typeName" /><br>

        <input type="submit" value="save">

    </form>

</body>
</html>
