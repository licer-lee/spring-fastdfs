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
    <title>文件上传下载demo</title>
</head>
<body>

    <h1>文件列表</h1>
    <table border="1">
        <thead>
        <tr>
            <td>id</td>
            <td>文件名</td>
            <td>URL</td>
            <td>操作</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${attachmentList}" var="a" >
            <tr>
                <td>${a.fileId}</td>
                <td>${a.fileName}</td>
                <td>${a.filePath}</td>
                <td><a href="${pageContext.request.contextPath}/file/download/${a.fileId}">下载</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>文件上传</h1>
    <form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
        <h3>upload file</h3>
        <input type="file" name="file" /><br>

        <input type="submit" value="upload">

    </form>

</body>
</html>
