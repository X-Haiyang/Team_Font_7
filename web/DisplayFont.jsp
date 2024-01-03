<%--
  Created by IntelliJ IDEA.
  User: XHY
  Date: 2023/12/24
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DisplayFont</title>

    <link rel="stylesheet" href="styles.css">
<style>
    body {
        background: linear-gradient(45deg, #8B5EC2,#B79DD1, #FCEAFF,#00C9AB);
        height: 100vh;
        margin: 0;
    }
.div1{
    width: 100px;
    height: 100px;
    font-size: 40px;
    margin: 10px auto;
}
.div2,.div3,.div4{
    width: 400px;
    height: 100px;
    font-size: 30px;
    float: left;
}
.div2{
    margin: 0 80px;
}
.div3{
    margin: 0 80px;
}

.div5{
    width: auto;
    height: 100px;
    text-align:center;

    margin: 100px auto;
}
.div6{
    width: 1520px;
    height: 200px;
    margin: 0 auto;

}
</style>
</head>
<body>
<div class="div1">
<%
    String character = (String) session.getAttribute("character");
    if (character != null) {

        out.write(character);

    } else {
        out.write("请返回主页面输入字符");
    }
%>
</div>

<div class="div6">
<div class="div2">
毛泽东：
<p class="session-data1">
    <%
        out.write(character);
    %>
</p>
</div>
<div class="div3">
颜真卿：
<p class="session-data2">
    <%
        out.write(character);
    %>
</p>
</div>
<div class="div4">
王羲之：
<p class="session-data3">
    <%
        out.write(character);
    %>
</p>
</div>
</div>
<div class="div5">

<a href="
<%
    String urlDB = (String) session.getAttribute("urlDB");
    out.write(urlDB);
%>" target="_blank">点击此处播放书写视频</a>

<a href="FontMain.jsp">返回</a>
</div>
</body>
</html>
