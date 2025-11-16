<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<%
	String url_db= "jdbc:mysql://localhost:3306/master_db";
	String user_db= "root";
	String pwd_db= "";
	String client = request.getParameter("idClient");
	int clientId = Integer.parseInt(client);
	String clientName = ""; 
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn1 = DriverManager.getConnection(url_db,user_db,pwd_db);
		PreparedStatement ps1 = conn1.prepareStatement("SELECT * FROM client where idClient = ?");
		ps1.setInt(1,clientId);
		ResultSet rs = ps1.executeQuery();
		
		while(rs.next()){
			clientName = rs.getString("nom");
			
		}

		
	}catch(Exception e){
		out.print("<p>"+ e.getMessage()+"</p>");
	}
	
	
	
	if("POST".equals(request.getMethod())){
	try{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_db,user_db,pwd_db);
		PreparedStatement ps = conn.prepareStatement("DELETE FROM client where idClient = ?");
		ps.setInt(1,clientId);
		int n = ps.executeUpdate();
		if (n>0){
			response.sendRedirect("Dashbord.jsp");
	        return;
		}
		
		
	}catch(Exception e){
		out.print("<p>"+ e.getMessage()+"</p>");
	}}
 %>



<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card border-danger shadow-sm">
                <div class="card-header bg-danger text-center text-white fw-bold">
					tu veux Supprimer  <%= clientName %>  ?
                </div>
                <div class="card-body">
                  
                    <form  method="POST" class="d-flex flex-row-reverse">
                        <button type="submit" class="btn btn-danger">Supprimer</button>
                        <button type="button" class="me-2 btn btn-white border border-black"><a href="Dashbord.jsp" class="text-decoration-none text-black">Annuler</a></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

 
</body>
</html>