package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EfetuarPagamento", urlPatterns = {"/EfetuarPagamento"})
public class EfetuarPagamento extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Recuperar os parâmetros do formulário
        String metodoPagamento = request.getParameter("metodoPagamento");
        String numeroCartao = request.getParameter("numeroCartao");
        String validadeCartao = request.getParameter("validadeCartao");
        String codigoCartao = request.getParameter("codigoCartao");

        // Aqui você pode realizar qualquer processamento necessário com os dados recebidos.
        // Por exemplo, validar os dados do cartão, calcular o valor total da transação, etc.

        // Redirecionar para a página de gerenciarConfirmacao.jsp
        response.sendRedirect("gerenciarConfirmacao.jsp");
    }
}
