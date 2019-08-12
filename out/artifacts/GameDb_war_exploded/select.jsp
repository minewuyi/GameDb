<%--
  Created by IntelliJ IDEA.
  User: minew
  Date: 2019/8/9
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>你好，用户${username}</h1>
<table border="1" align="center">
    <tr>
        <td>游戏编号: ${game.number}</td>
    </tr>
    <tr>
        <td>游戏名: ${game.gameName}</td>
    </tr>
    <tr>
        <td>游戏类型: ${game.type}</td>
    </tr>
    <tr>
        <td>游戏价格: ${game.price} 元</td>
    </tr>
</table>

</body>
</html>
