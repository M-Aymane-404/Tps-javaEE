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
            <div class="card border-danger shadow-sm">
                <div class="card-header bg-danger text-center text-white fw-bold">
					tu veux Supprimer ${pm.nom} ?
                </div>
                <div class="card-body">
                  
                    <form  method="POST" action="DeleteClient.do?idClient=${pm.idClient}" class="d-flex flex-row-reverse">
                        <button type="submit" class="btn btn-danger">Supprimer</button>
                        <button type="button" class="me-2 btn btn-white border border-black"><a href="client.do" class="text-decoration-none text-black">Annuler</a></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>