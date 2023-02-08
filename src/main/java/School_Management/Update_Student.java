package School_Management;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update_Student extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		int id= Integer.parseInt(req.getParameter("id"));
		String name =req.getParameter("name");
		double fees = Double.parseDouble(req.getParameter("fees"));
	  String Stream = req.getParameter("stream");


		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("abc");
		EntityManager EM = EMF.createEntityManager();
		EntityTransaction ET = EM.getTransaction();
		
		Student p = new Student();
		p.setId(id);
		p.setName(name);
		p.setFees(fees);
		p.setStream(Stream);
	    
	    
	    ET.begin();
	    EM.merge(p);
	    ET.commit();
	    RequestDispatcher rd = req.getRequestDispatcher("/CRUD_operation.html");
        rd.forward(req, resp);
		
	}

}
