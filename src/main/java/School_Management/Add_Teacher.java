package School_Management;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Teacher")
public class Add_Teacher extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String id=req.getParameter("id");
		String name =req.getParameter("name");
		String sal=req.getParameter("sal");
		String subject=req.getParameter("subject");
		int Id = Integer.parseInt(id);
		double Sal = Double.parseDouble(sal);
		
		Teacher t = new Teacher();
		
		t.setId(Id);
		t.setName(name);
		t.setSal(Sal);
		t.setSub(subject);
		
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("abc");
		EntityManager EM = EMF.createEntityManager();
		EntityTransaction ET = EM.getTransaction();
		
		ET.begin();
		EM.persist(t);
		ET.commit();
		
		
	}
}
