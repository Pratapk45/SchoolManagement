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

@WebServlet("/servlet")
public class Driver extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	super.doPost(req, resp);
		int id= Integer.parseInt(req.getParameter("id"));
		String name =req.getParameter("name");
		String gmail =req.getParameter("email");
		long MoNumber = Long.parseLong(req.getParameter("MoNumber"));
		int Age = Integer.parseInt(req.getParameter("age"));
	  String pass = req.getParameter("password");


		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Pratap");
		EntityManager EM = EMF.createEntityManager();
		EntityTransaction ET = EM.getTransaction();
		
		Principal p = new Principal();
		p.setId(id);
		p.setName(name);
		p.setEmail(gmail);
	    p.setAge(Age);
	    p.setPass(pass);
	    p.setMoNumber(MoNumber);
	    
	    ET.begin();
	    EM.persist(p);
	    ET.commit();
	    RequestDispatcher rd = req.getRequestDispatcher("/login.html");
	     rd.forward(req, resp);

}
}
