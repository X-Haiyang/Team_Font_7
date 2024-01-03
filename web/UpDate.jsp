<%--
  Created by IntelliJ IDEA.
  User: XHY
  Date: 2023/12/30
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpDate</title>
</head>
<body>


<form action="Update" method="post">
    请输入要上传的字:
    <label>
        <input type="text" name="character">
    </label><br>

    请输入该字体网址:
    <label>
        <input type="url" name="urlDB">
    </label><br>

    <input type="submit" value="上传" >
    <input type="reset" value="重置" >
</form>

<% if (request.getAttribute("log") != null) {
    String str = (String) request.getAttribute("log");
    if (str.equals("err"))
        out.println("<br><span style=\"color:red\">上传失败</span>" +
                "<br><span style=\"color:red\">请重新上传</span>");
} %>

<a href="FontMain.jsp">返回</a>

</body>
</html>
