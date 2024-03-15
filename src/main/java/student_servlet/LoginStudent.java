package student_servlet;

import java .io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import student_servlet.dao.StudentDao;
import student_servlet.dto.Student;

@WebServlet("/login")
public class LoginStudent extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String mail=req.getParameter("email");
		String pwd=req.getParameter("password");
		System.out.println(mail+pwd);
		StudentDao dao=new StudentDao();
		
		try {
			Student db = dao.fetch(mail);
			System.out.println(db.getEmail()+db.getPwd());			
			if(db.getPwd().equals(pwd)) {
				List<Student> list = dao.fetchAll();
				req.setAttribute("list", list);     //store  the data in database within the servlet context,request/session scope.
				System.out.println("Login success");
				RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
				dispatcher.forward(req, res);
			}else {
				req.setAttribute("msg", "wrong password");
				System.out.println("Password  wrong");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, res);
			}
		} catch (Exception e) {	
			req.setAttribute("msg", "Email is wrong");
			System.out.println("email is wrong");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, res);
			e.printStackTrace();
		}
		
	}

}
