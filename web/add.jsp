<%--
  Created by IntelliJ IDEA.
  User: minew
  Date: 2019/8/9
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<h1>你好，用户${username}</h1>
<form action="/AllServlet">
    <table align="center">
        <tr>
            <td>游戏名</td>
            <td><input type="text"  name="gameName"  ></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><input type="text"  name="type"  ></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text"  name="price"  >元</td>
        </tr>
        <tr>
        <td colspan="2"><button type="submit" name="opr" value="add" onclick="return confirm('确定添加吗？')" > 添加</button></td>
        </tr>
    </table>
</form>
</body>
</html>
