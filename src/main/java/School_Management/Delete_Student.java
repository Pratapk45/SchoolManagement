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
@WebServlet("/Delete_Student")
public class Delete_Student extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		int id= Integer.parseInt(req.getParameter("id"));
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("abc");
		EntityManager EM = EMF.createEntityManager();
        EntityTransaction ET = EM.getTransaction();
		
		Student S = EM.find(Student.class, id);
		if(S!=null)
		{
		ET.begin();
		EM.remove(S);
		ET.commit();
		}
		else
		{
			System.out.println("Data is not present in database");
		}
		 RequestDispatcher rd = req.getRequestDispatcher("/CRUD_operation.html");
	        rd.forward(req, resp);
	}

	}


