<%-- 
    Document   : sessao
    Created on : 14 de ago. de 2022, 17:50:12
    Author     : lgcp1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="WEB-INF/style.css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String usuario =(String) session.getAttribute("usuario");
            if(usuario == null){
                response.sendRedirect("principal.jsp");
            }            
            
        %>
        <h1>Home</h1>
        <form action="">
            <br><br>
             
            <a href="EncerraSessao" >
                <input name="sair" type="button" value="Sair"  >
            </a> 
            <a href="cadastro.jsp">
                <input name="cadastrar" type="button" value="Cadastrar" >
            </a> 
        </form>
    </body>
</html>
