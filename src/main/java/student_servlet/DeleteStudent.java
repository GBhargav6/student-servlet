package student_servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import student_servlet.dto.Student;
@WebServlet("/delete")
public class DeleteStudent extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt((req.getParameter("id")));
		System.out.println(id);
//		Student db=delete(id);
		
	}
}
