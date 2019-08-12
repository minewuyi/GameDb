package Servlet;

import Dao.Game;
import Dao.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * @author wuyi
 * @date 2019/8/8 17:00
 */
public class AllServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String opr = req.getParameter("opr");
//        System.out.println(opr);
        if ("login".equals(opr)) {
            System.out.println("login");
            login(req, resp);
        } else if ("delete".equals(opr)) {
            delete(req, resp);
        } else if ("update".equals(opr)) {
            update(req, resp);
        } else if ("add".equals(opr)) {
            add(req, resp);
        } else if ("select".equals(opr)) {
            select(req, resp);
        }
    }
//    //点击改的a标签调用此服务 获取修改的值并跳转至修改界面
//    public void up(HttpServletRequest req,HttpServletResponse resp) throws IOException {
//        String value = req.getParameter("value");
//        req.setAttribute("number",Integer.parseInt(value));
//        resp.sendRedirect("update.jsp");
//    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String delete = req.getParameter("number");
        int number = Integer.parseInt(delete);
        try {
            Show.delete(number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("index.jsp");


    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        try {
            User user = Show.selectUser(userName, passWord);
            if (user == null) {
                System.out.println("hell");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            } else {
                System.out.println("hello");
                //创建会话对象
                HttpSession session=req.getSession();
                //将username值加入会话内，接下来多个页面都可以使用
                session.setAttribute("username",user.getUserName());
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void select(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String select = req.getParameter("number");
        int number = Integer.parseInt(select);
        PrintWriter out = resp.getWriter();
        try {
            Game game = Show.showOne(number);
            if (game == null) {
                out.println("<script type='text/javascript'>\n" +
                        "    alert('查不到结果');\n" +
                        "   history.back();\n " +
                        "  </script>");
                return;
            }

            req.setAttribute("game", game);
            req.getRequestDispatcher("select.jsp").forward(req, resp);
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }


    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String type = req.getParameter("type");
        String gameName = req.getParameter("gameName");
        int price = Integer.parseInt(req.getParameter("price"));
        try {
            Show.add(gameName, type, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("index.jsp");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String gameName = req.getParameter("gameName");
        String type = req.getParameter("type");
        int number = Integer.parseInt(req.getParameter("number"));
        int price = Integer.parseInt(req.getParameter("price"));
        try {
            Show.update(number, gameName, type, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("index.jsp");
    }


}
