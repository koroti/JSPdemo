package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;
import com.Dao.UserDaoImpl;
import com.Entity.USER;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name"); //得到jsp页面传过来的参数  
        String pwd = request.getParameter("pwd");  
          
        UserDao ud = new UserDaoImpl();  
          
        if(ud.login(name, pwd)){  
            request.setAttribute("message", "欢迎用户"+name); //向request域中放置信息  
            List<USER> userlist = ud.getUserAll();
            request.setAttribute("users", userlist);
            request.getRequestDispatcher("/success.jsp").forward(request, response);//转发到成功页面  
        }else{  
            response.sendRedirect("index.jsp"); //重定向到首页  
        }  
	}

}
