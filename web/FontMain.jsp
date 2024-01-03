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
    <style>
        body {
            background: linear-gradient(45deg, #2E5F70,#00C9A7, #C4FCEF,#4D8076);
            height: 100vh;
            margin: 0;
        }
        #search-box{
            width: 200px;
            height: 30px;
        }
        #search{
            height: 30px;
            width: 50px;
        }
        .div1{
            height: 100px;
            width: 300px;

            text-align:center;
            font-family: Arial, sans-serif;
            margin: 100px auto;
            padding: 0;


        }

    </style>
</head>
<body>

<div CLASS="div1">
<form action="search" method="post">

    <p style="text-align:center;font-size: 40px;" >百字查</p>
    <label>
        <input type="text"  id="search-box" name="character">
    </label>



    <input type="submit" id="search" value="我C">

</form>
</div>
<% if (request.getAttribute("log") != null) {
    String str = (String) request.getAttribute("log");
    if (str.equals("err"))
        out.println("<br><span style=\"color:red\">该字不在数据库中或服务器出现问题</span>" +
                "<br><span style=\"color:red\">请重新输入或联系管理员</span>");
} %>

<a href="UpDate.jsp">填充数据库</a>

</body>
</html>
