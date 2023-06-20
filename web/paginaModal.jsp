<%@page import="java.util.ArrayList"%>
<%@page import="dao.ModalDao"%>
<%@page import="model.Modal"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="WEB-INF/style.css" media="screen" />
    <title>Visualizar Modal</title>
</head>
<body>
    <h1>Visualizar Modal</h1>
    
    <table>
        <tr>
            <th>Capacidade</th>
            <th>Ano de Fabricação</th>
            <th>Tipo</th>
            <th>Modelo</th>
            <th>Situação</th>
        </tr>
        <tr>
        
            <%
                ArrayList<Modal> lista = new ArrayList<Modal>();
                try {
                        ModalDao mDao = new ModalDao();
                        lista = mDao.getLista();
                    } catch (Exception e) {
                        out.print(e);
                    }
                    for(Modal m:lista){
            %>
        <tr>
            <td><%=m.getCapacidade()%></td>
            <td><%=m.getAnoFabricacao()%></td>
            <td><%=m.getTipo()%></td>
            <td><%=m.getModelo()%></td>
            <td><%=m.getSituacao()%></td>
        </tr>
        <%}%>
    </table>
    
    <form action="gerenciarConfirmacao.jsp" method="post">
        <input type="hidden" name="reservaConfirmada" value="true">
        <input type="submit" value="Confirmar Reserva">
    </form>
    
    <form action="gerenciarConfirmacao.jsp" method="post">
        <input type="hidden" name="reservaConfirmada" value="false">
        <input type="submit" value="Cancelar Reserva">
    </form>
</body>
</html>
