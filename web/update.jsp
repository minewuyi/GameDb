<%@ page import="Dao.Game" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: minew
  Date: 2019/8/9
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
    <%
//        pageContext.setAttribute("index",Integer.parseInt(request.getParameter("index")));
//        pageContext.setAttribute("list",request.getAttribute("list"));
//         request.getParameter("number");
//        request.getParameter("gameName");
//        request.getParameter("type");
//        request.getParameter("price");
        pageContext.setAttribute("number", request.getParameter("number"));
        pageContext.setAttribute("gameName",request.getParameter("gameName"));
        pageContext.setAttribute("type",request.getParameter("type"));
        pageContext.setAttribute("price",request.getParameter("price"));
    %>
<%--    /{list[index].number}--%>
</head>
<body>
<h1>你好，用户${username}</h1>
<form action="/AllServlet">
    <input type="hidden" name="number" value=${number}>
    <table align="center">
        <tr>
            <td>游戏名</td>
            <td><input type="text" name="gameName" value=${gameName}></td>
        </tr>
        <tr>
            <td>游戏类型</td>
            <td><input type="text" name="type" value=${type}></td>
        </tr>
        <tr>
            <td>游戏价格</td>
            <td><input type="text" name="price" value=${price}>元</td>
        </tr>
        <tr>
            <td colspan="2">

                <button type="submit" name="opr" value="update" onclick="return confirm('确定提交吗？')">提交</button>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
