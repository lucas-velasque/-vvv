package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciarConfirmacao", urlPatterns = {"/GerenciarConfirmacao"})
public class GerenciarConfirmacao extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Processar a solicitação de confirmação
        // Aqui você pode inserir a lógica necessária para processar a solicitação de confirmação
        // por exemplo, acessar o banco de dados ou realizar outras operações relevantes
        
        // Exibir a mensagem de confirmação
        request.getRequestDispatcher("confirmacao.jsp").forward(request, response);
    }
}
