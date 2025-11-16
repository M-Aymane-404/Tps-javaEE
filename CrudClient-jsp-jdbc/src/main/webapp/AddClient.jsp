	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>



<%
		String url_db = "jdbc:mysql://localhost:3306/master_db";
 		String user_db = "root";
		String pwd_db ="";
		
		if("POST".equals(request.getMethod())){
 
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_db, user_db, pwd_db);
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
 
			PreparedStatement ps = conn.prepareStatement("insert into client (nom, prenom, age) values(?,?,?) ");
			ps.setString(1,nom);
			ps.setString(2,prenom);
			ps.setInt(3,age);
			int n = ps.executeUpdate();
			  response.sendRedirect("Dashbord.jsp");
	           return;
		}catch(Exception e){
			out.println ("<p>"+ e.getMessage()+"</p>");
		}
		}
		
		%>





<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card border-primary shadow-sm">
                <div class="card-header bg-primary text-white fw-bold">
                   Ajouter les informations du client
                </div>
                <div class="card-body">
                  
                    <form  method="POST">
                        <div class="mb-3">
                            <label for="nom" class="form-label fw-semibold">Nom Client :</label>
                            <input type="text" id="nom" name="nom" class="form-control"  >
                        </div>

                        <div class="mb-3">
                            <label for="prenom" class="form-label fw-semibold">Prénom Client :</label>
                            <input type="text" id="prenom" name="prenom" class="form-control"   >
                        </div>

                        <div class="mb-3">
                            <label for="age" class="form-label fw-semibold">Âge :</label>
                            <input type="text" id="age" name="age" class="form-control"   >
                        </div>

                        <button type="submit" class="btn btn-primary">Ajouter</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>