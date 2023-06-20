<%-- 
    Document   : principal
    Created on : 14 de ago. de 2022, 00:12:14
    Author     : lgcp1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="WEB-INF/style.css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="get">
            login:
            <input name="nome" type="text">
            <br><br>
            senha:
            <input name="senha" type="password">
            <br><br>
            <!--
            <a href="cadastro.jsp">
                <input name="cadastrar" type="button" value="Cadastrar" >
            </a> 
            -->
             <input type="submit" value="enviar">
             <div>
             <%
                    String mensagem = (String) request.getAttribute("mensagem");
                    if(mensagem != null){
                        out.print(mensagem);
                    }
                 %>
             </div>    
        </form>
    </body>
</html>
