package org.smart4j.chapter1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO :写一个HelloServlet,接收GET类型的/hello请求,转发到
 * TODO :-> /WEB-INF/jsp/hello.jsp页面，在hello.jsp页面上显示当前系统时间
 *
 * @author Wangminze
 * @version 2016/12/8
 * @description: 使用WebServlet注解并配置请求路径，对外发布Servlet服务，
 *      不需要再web.xml中添加任何配置(Servlet3.0规范)。
 */
@WebServlet( "/hello" )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //super.doGet(req, resp);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        req.setAttribute("currentTime",currentTime);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);

    }
}
