package controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

@WebServlet(name = "CompraPassagem", urlPatterns = {"/CompraPassagem"})
public class CompraPassagem extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Recuperar os parâmetros do formulário
        String tipo = request.getParameter("tipo");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String celular = request.getParameter("celular");
        String cidadeDestino = request.getParameter("cidadeDestino");
        String dataPartida = request.getParameter("data");
        String mensagem;

        // Aqui você pode realizar qualquer processamento necessário com os dados recebidos.
        // Por exemplo, salvar os dados em um banco de dados ou realizar algum cálculo.
        RequestDispatcher dispatcher = request.getRequestDispatcher("compraPassagem.jsp");
        if(nome!=null && !nome.isEmpty()
                && request.getParameter("cpf") != null && !request.getParameter("cpf").isEmpty()
                && request.getParameter("celular") != null && !request.getParameter("celular").isEmpty()
                && request.getParameter("cidadeDestino") != null && !request.getParameter("cidadeDestino").isEmpty()
                && request.getParameter("dataPartida") != null && !request.getParameter("dataPartida").isEmpty()
                ){
            // Verificar se o modal está disponível com base na situação bool
            boolean modalDisponivel = verificarModalDisponivel();

            if (modalDisponivel) {
            // Aqui você pode realizar qualquer processamento necessário com os dados recebidos.
            // Por exemplo, salvar os dados em um banco de dados ou realizar algum cálculo.

            // Redirecionar para a página de efetuarPagamento.jsp
                response.sendRedirect("efetuarPagamento.jsp");
            } else {
            // Modal indisponível, exibir mensagem de erro
                response.getWriter().println("O modal selecionado está indisponível. Por favor, selecione outro modal.");
        }
     // Método para verificar se o modal está disponível ou indisponível
        private boolean verificarModalDisponivel() {
        // Lógica para verificar a situação bool e determinar se o modal está disponível ou não
        // Substitua o código abaixo pela sua lógica real

        // Exemplo de lógica:
            boolean situacaoBool = false; // Obtém a situação bool do modal
            return situacaoBool;
    }
            if(cpf.length()!=11) {
                    mensagem = "CPF INVALIDO!";
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                return;
                    }else{
                        mensagem = "Cadastro Validado";
                        request.setAttribute("mensagem", mensagem);
                    dispatcher.forward(request, response);
            }
            
           
            LocalDate dataValidade = LocalDate.parse(dataPartida);
            LocalDate dataAtual = LocalDate.now();
            
            if (dataValidade.isBefore(dataAtual)) {
                 mensagem = "A data é inválida. A data não pode ser menor que a data atual.";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                return; // Encerra a execução do método
            }
        }else{
            mensagem = "Campos obrigatório precisam ser preenchidos.";
            request.setAttribute("mensagem", mensagem);
            dispatcher.forward(request, response);
        }
        
        // Redirecionar para a página de efetuarPagamento.jsp
        response.sendRedirect("efetuarPagamento.jsp");
    }
}
