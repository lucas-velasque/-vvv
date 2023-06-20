<%-- 
    Document   : cadastro
    Created on : 14 de ago. de 2022, 12:32:33
    Author     : lgcp1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="WEB-INF/style.css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <body>
        <%
            String usuario =(String) session.getAttribute("usuario");
            if(usuario == null){
                response.sendRedirect("principal.jsp");
            }
        %>
        <h1>Cadastro</h1>
        <form action="Cadastro" method="post">
            nome:
            <input name="nome" type="text">
            <br><br>
            login:
            <input name="login" type="text">
            <br><br>
            senha:
            <input name="senha" type="password">
            <br><br>
            Confirmação de senha:
            <input name="csenha" type="password">
            <br><br>
            profissão:
            <input name="profissao" type="text">
            <br><br>
            CPF:
            <input name="cpf" type="number">
            <br><br>
            telefone:
            <input name="telefone" type="tel">
            <br><br>
            Endereço:
            <input name="endereco" type="text">
            <br><br>
            <input type="reset" value="Cancelar">
            <input type="submit" value="enviar">
            <a href="sessao.jsp">
                <input type="button" value="Home">
            </a>
            <br><br>
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