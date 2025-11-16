<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card border-primary shadow-sm">
                <div class="card-header bg-primary text-white fw-bold">
                   Ajouter les informations du client
                </div>
                <div class="card-body">
                  
<form  method="POST" action="${pageContext.request.contextPath}/addClient.do">
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
</body>
</html>