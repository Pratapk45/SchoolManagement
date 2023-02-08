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
@WebServlet("/update")
public class U_Teacher extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		int id= Integer.parseInt(req.getParameter("id"));
		String name =req.getParameter("name");
		double sal = Double.parseDouble(req.getParameter("salary"));
		String sub = req.getParameter("sub");
	 

		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("abc");
		EntityManager EM = EMF.createEntityManager();
		EntityTransaction ET = EM.getTransaction();
		
		Teacher p = new Teacher();
		p.setId(id);
		p.setName(name);
		p.setSal(sal);
		p.setSub(sub);
		
	    ET.begin();
	    EM.merge(p);
	    ET.commit();
	    RequestDispatcher rd = req.getRequestDispatcher("/CRUD_operation1.html");
       rd.include(req, resp);
	}

}
