<%@page import="School_Management.Student"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc");
	EntityManager em = emf.createEntityManager();
	Student s = em.find(Student.class,id1);
	%>

	<form action="update" method="post">
		id: <input type="text" value="<%=s.getId()%>" name="id">
		name: <input type="text" value="<%=s.getName()%>" name="name">
		Fees: <input type="text" value="<%=s.getFees()%>" name="fees">
		Stream: <input type="text" value="<%=s.getStream()%>" name="stream">
		
		
		<input type="submit">
	</form>


	
</body>
</html>