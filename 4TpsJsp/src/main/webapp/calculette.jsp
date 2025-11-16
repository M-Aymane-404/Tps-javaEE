<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="" method="Post">
       Nombre 1 : <input type="text" name="nb1">
       Nombre 2 : <input type="text" name="nb2">

       <select name="oper"  >
        <option value="sou">-</option>
        <option value="add">+</option>
        <option value="div">/</option>
        <option value="mul">x</option>
       </select>
       <input type="submit" value="calculer">
    </form>
    <br>    
    
    <%
    String param1 = request.getParameter("nb1");
    String param2 = request.getParameter("nb2");
    String operation = request.getParameter("oper");
    float res = 0 ;

    if(param1 != null && param2 != null){
	    float nb1 = Float.parseFloat( param1);
	    float nb2 = Float.parseFloat(param2);
	   
	    
 	    if("sou".equals(operation)){
	    	  res = nb1 - nb2;
	    	  out.println("le resultat "+res);
	    	
	    }else if("add".equals(operation)){
	    	  res = nb1 + nb2;
	    	  out.println("le resultat "+res);
	    	
	    }else if("div".equals(operation)){
	    	
		    	if(nb2 == 0){
		    		out.println( "le nombre doit être différent de 0 "); 
		    		 
		    		 
		    	}else{
		    	  res = nb1 / nb2;
		    	  out.println("le resultat "+res);
		    	  }
	    	
	    }else{
	    	  res = nb1 * nb2;
	    	  out.println("le resultat "+res);
	    	
	    }
 	    
 	    
	   }

    
 
    
    %>
    
   
</body>
</html>