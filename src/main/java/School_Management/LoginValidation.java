package School_Management;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginValidation extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String email = req.getParameter("email");
		long password = Long.parseLong(req.getParameter("password"));
	
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("pratap");
		EntityManager EM = EMF.createEntityManager();
		EntityTransaction ET = EM.getTransaction();
		
		Query q = EM.createQuery("select u from Principal u where u.email=?1 and u.pass=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		List<Principal> user = q.getResultList();
		// System.out.println(user);
		//if(user!=null)
		if( user.size()>0)
		{
			System.out.println("Welcome");
			System.out.println("Login Successfull");
		}
		else
		{
			System.out.println("Invalid Details");
		}

	}
	}



