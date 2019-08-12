目前已问题

1. 用户直接url输入update.jsp 进行更新会出500错误 原因是updateServlet没有增加gameId为空的排错手段
<br>
方法： 限制进入页面的条件(添加过滤器)
或者增加排错
<br>
2.过滤器如果url为/* 会过滤掉包括servlet 方法的所有请求，具体实现还有待优化
  