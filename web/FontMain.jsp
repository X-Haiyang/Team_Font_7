<%--
  Created by IntelliJ IDEA.
  User: XHY
  Date: 2023/12/24
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FontSearch</title>
</head>
<body>


<form action="search" method="post">
    输入您要查找的字体:
    <label>
        <input type="text" name="character">
    </label><br>


    <input type="submit" value="查找">
</form>

<% if (request.getAttribute("log") != null) {
    String str = (String) request.getAttribute("log");
    if (str.equals("err"))
        out.println("<br><span style=\"color:red\">该字不在数据库中或服务器出现问题</span>" +
                "<br><span style=\"color:red\">请重新输入或联系管理员</span>");
} %>


</body>
</html>
