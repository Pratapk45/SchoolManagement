package School_Management;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/View_Student")
public class View_Student extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		int id= Integer.parseInt(req.getParameter("id"));
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("abc");
		EntityManager EM = EMF.createEntityManager();
		
		Query q = EM.createQuery("select s from Student s");
		List<Student> S = q.getResultList();
		
		PrintWriter pw = resp.getWriter();
	for (Student s : S) {
		pw.write(s.getId());
		pw.write(s.getName());
		pw.write(s.getStream());
		
	}
		
		
//		 RequestDispatcher rd = req.getRequestDispatcher("/CRUD_operation.html");
//	        rd.include(req, resp);

}
}

