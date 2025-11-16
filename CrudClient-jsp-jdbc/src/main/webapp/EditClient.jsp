<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, getstionDesUtilisateur.Client"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 

 
  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
   String url_db = "jdbc:mysql://localhost:3306/master_db";
   String user_db = "root";
   String pwd_db = "";
  String P_nom =	"" ;
  String P_prenom = "";
	int P_age = 0;
   int id = Integer.parseInt(request.getParameter("idClient"));
 
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_db, user_db,pwd_db);
		
		PreparedStatement ps1 = conn.prepareStatement("select * from client where idClient = ?");
		ps1.setInt(1,id);
		ResultSet rs1 = ps1.executeQuery();
		
		while(rs1.next()){
  			P_nom =	 rs1.getString("nom");
			P_prenom = rs1.getString("prenom");
			P_age = rs1.getInt("age");
 		}
		
		
		
		
		
	}catch(Exception e){
		out.println("<p>"+e.getMessage()+" </P>");
	}
		
	


 

  
   if ("POST".equals(request.getMethod())) {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection(url_db, user_db, pwd_db);

           String newNom = request.getParameter("nom");
           String newPrenom = request.getParameter("prenom");
           int newAge = Integer.parseInt(request.getParameter("age"));

           PreparedStatement ps = conn.prepareStatement(
               "UPDATE client SET nom=?, prenom=?, age=? WHERE idClient=?"
           );
           ps.setString(1, newNom);
           ps.setString(2, newPrenom);
           ps.setInt(3, newAge);
           ps.setInt(4, id);

           int n = ps.executeUpdate();
           conn.close();

            response.sendRedirect("Dashbord.jsp");
           return;

       } catch (Exception e) {
           out.println("<p class='text-danger'>Erreur mise à jour : " + e.getMessage() + "</p>");
       }
   }

%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card border-primary shadow-sm">
                <div class="card-header bg-primary text-white fw-bold">
                    Mettre à jour les informations du client
                </div>
                <div class="card-body">
                  
                    <form  method="POST">
                        <div class="mb-3">
                            <label for="nom" class="form-label fw-semibold">Nom Client :</label>
                            <input type="text" id="nom" name="nom" class="form-control" value = <%=P_nom %> >
                        </div>

                        <div class="mb-3">
                            <label for="prenom" class="form-label fw-semibold">Prénom Client :</label>
                            <input type="text" id="prenom" name="prenom" class="form-control" value = "<%=P_prenom %>" >
                        </div>

                        <div class="mb-3">
                            <label for="age" class="form-label fw-semibold">Âge :</label>
                            <input type="text" id="age" name="age" class="form-control" value ="<%=P_age %>"  >
                        </div>

                        <button type="submit" class="btn btn-primary">Modifier</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>