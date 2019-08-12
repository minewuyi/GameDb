package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author wuyi
 * @date 2019/8/10 16:34
 */
public class LimitsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        // 获得用户请求的URI
        String path = request.getRequestURI();
        System.out.println(path);
        // 从session里取员工工号信息
        String username = (String) session.getAttribute("username");
  /*创建类Constants.java，里面写的是无需过滤的页面
  for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {
   if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
    chain.doFilter(servletRequest, servletResponse);
    return;
   }
  }*/
        System.out.println(username);
//        System.out.println(path);
        // 登陆页面无需过滤
        if(path.equals("/login.jsp")||path.equals("/")||path.equals("/limit.jsp")||path.equals("/error.jsp")||path.equals("/AllServlet")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 判断如果没有取到员工信息,就跳转到登陆页面
        if (username == null || "".equals(username)) {
            // 跳转到登陆页面
            response.sendRedirect("limit.jsp");
        } else {
            // 已经登陆,继续此次请求
            filterChain.doFilter(request, response);
        }
    }



    @Override
    public void destroy() {

    }
}
