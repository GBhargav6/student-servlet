package student_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import student_servlet.dao.StudentDao;
import student_servlet.dto.Student;
@WebServlet("/save")
public class StudentRegister extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		System.out.println(name+email+gender+phone+password+address);
		PrintWriter writer = res.getWriter();
		writer.print(name+" | "+email+" | "+gender+" | "+phone+" | "+password+" | "+address);		
		Student student=new Student(name,email,Long.parseLong(phone),gender,password,address);
		System.out.println(student);
		StudentDao dao=new StudentDao();		
		try {
			dao.saveStudent(student);
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, res);
		}catch(Exception e){
			RequestDispatcher dispatcher = req.getRequestDispatcher("register.html");
			dispatcher.include(req, res);
		}			
	}
}
