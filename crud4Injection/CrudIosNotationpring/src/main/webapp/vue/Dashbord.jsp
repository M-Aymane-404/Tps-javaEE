<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="jakarta.tags.core" prefix="c"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-5">

 <div class="card shadow">

    <div class="card-header bg-primary text-white">
      Liste des Clients
    </div>

    <div class="card-body">
    

      <form class="row g-2 align-items-center mb-4" method="get" action="clients.do">
        <div class="col-auto">
          <label for="client" class="col-form-label">Client :</label>
        </div>

        <div class="col-auto">
          <input type="text" name="motCle" id="client" class="form-control" placeholder="Nom du client"  >
        </div>

        <div class="col-auto">
          <button type="submit" class="btn btn-primary">Chercher</button>
        </div>
        <div class="col-auto">
          <button type="button" class="btn btn-warning text-white"> <a class="text-decoration-none text-white" href="addClient.do">Nouveau Client</a> </button>
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
 
            
            <c:forEach items="${pm}" var="client" varStatus="loop">
                <tr>
                  <td>${client.idClient}</td>  
                  <td>${client.nom}</td>
                  <td>${client.prenom}</td>
                  <td>${client.age}</td>
                  <td>
                  
                    <button type="button" class="btn btn-success btn-sm">
                        <a class="text-decoration-none text-white" href="EditClient.do?idClient=${client.idClient}">Éditer</a>
                    </button> 
                    <button type="button" class="btn btn-danger btn-sm">
                        <a class="text-decoration-none text-white" href="DeleteClient.do?idClient=${client.idClient}">Supprimer</a>
                    </button>
                  </td>
                </tr>
            </c:forEach>
            
    
</tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>