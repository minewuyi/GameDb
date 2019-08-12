<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minew
  Date: 2019/8/8
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Servlet.Show" %>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
  <title>$Title$</title>
  <%
    try {
      pageContext.setAttribute("list", Show.showTo());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  %>


  <script>

    function onPrompt()

    {
      var number=prompt("请输入要查询的编码！");
      window.location.href="AllServlet?opr=select&number="+number;
    }


  </script>

</head>
<body>
<h1>你好，用户${username}</h1>
<table border="1" align="center" style="">
  <thead>
  <tr>
    <th>编号</th>
    <th>游戏名</th>
    <th>类型</th>
    <th>价格</th>
    <th>操作</th>
  </tr>
  </thead>
  <tbody>
  <c:if test="${list!=null}">
    <c:forEach items="${list}" var="game" varStatus="s">
      <tr>
        <td>${game.number}</td>
        <td>${game.gameName}</td>
        <td>${game.type}</td>
        <td>${game.price}元</td>
        <td>
          <a href="AllServlet?opr=delete&number=${game.number}" onclick="return confirm('确定删除吗？')">删除</a>
          <a href="update.jsp?number=${game.number}&gameName=${game.gameName}&type=${game.type}&price=${game.price}">修改</a>
        </td>
      </tr>
    </c:forEach>
  </c:if>
  <tr>
    <td colspan="5" align="center">
      <button type="button"><a href="add.jsp">添加</a></button>
      <button type="button" onclick="onPrompt()">查询</button>
    </td>
  </tr>
  </tbody>
</table>
</body>
</html>
