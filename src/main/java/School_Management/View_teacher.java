package School_Management;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/View_Teacher")
public class View_teacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		int id= Integer.parseInt(req.getParameter("id"));
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("abc");
		EntityManager EM = EMF.createEntityManager();
		
		Teacher T = EM.find(Teacher.class, 1);
		
		System.out.println(T);
		 RequestDispatcher rd = req.getRequestDispatcher("/CRUD_operation1.html");
	        rd.forward(req, resp);
	}

}
