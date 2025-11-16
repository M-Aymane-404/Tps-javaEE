<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, java.util.*, getstionDesUtilisateur.Client" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<%
	String moteCle = request.getParameter("motCle")	;
	if(moteCle == null){moteCle="";}

	String url_db =  "jdbc:mysql://localhost:3306/master_db";
	String user_db = "root";
	String pwd_db = "";
	List<Client> clients = new ArrayList<Client>();
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_db, user_db,pwd_db);
		
		PreparedStatement ps = conn.prepareStatement("select * from client where nom like ?");
		ps.setString(1,"%"+moteCle+ "%");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Client c = new Client();
			c.setIdClient(rs.getInt("idClient"));
			c.setNom(rs.getString("nom"));
			c.setPrenom(rs.getString("prenom"));
			c.setAge(rs.getInt("age"));
			clients.add(c);
		}
		
		
		
		
		
	}catch(Exception e){
		out.println("<p>"+e.getMessage()+" </P>");
		
	}

%>
  
<div class="container mt-5">

 <div class="card shadow">

    <div class="card-header bg-primary text-white">
      Liste des Clients
    </div>

    <div class="card-body">
    

      <form class="row g-2 align-items-center mb-4" method="get" action="Dashbord.jsp">
        <div class="col-auto">
          <label for="client" class="col-form-label">Client :</label>
        </div>

        <div class="col-auto">
          <input type="text" name="motCle" id="client" class="form-control" placeholder="Nom du client" value="<%= moteCle %>">
        </div>

        <div class="col-auto">
          <button type="submit" class="btn btn-primary">Chercher</button>
        </div>
        <div class="col-auto">
          <button type="button" class="btn btn-warning text-white"> <a class="text-decoration-none text-white" href="AddClient.jsp">Nouveau Client</a> </button>
        </div>
      </form>
      <table class="table table-bordered align-middle text-center">
        <thead class="table-light">
          <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Âge</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
        <%
        
          if (clients.isEmpty()) {
        %>
            <tr>
              <td colspan="5" class="text-center  ">Aucun client trouvé.</td>
            </tr>
        <%
          } else {
        	  int id = 1;
            for (Client c : clients) {
         %>
            <tr>
              <td><%= id %></td>
              <td><%= c.getNom() %></td>
              <td><%= c.getPrenom() %></td>
              <td><%= c.getAge() %></td>
              <td>
              
                <button type="button" class="btn btn-success btn-sm"><a class="text-decoration-none text-white"  href="EditClient.jsp?idClient=<%=c.getIdClient()%>">Éditer</a></button> 
                <button type="button" class="btn btn-danger btn-sm"><a class="text-decoration-none text-white" href="DeleteClient.jsp?idClient=<%=c.getIdClient()%>">Supprimer</a></button>
              </td>
            </tr>
        <%
         id++;
            }
          }
        %>
        </tbody>
      </table>
    </div>
  </div>
</div>

</body>
</html>
