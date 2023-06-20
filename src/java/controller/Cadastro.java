/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.lang.*;
import com.sun.security.ntlm.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author lgcp1
 */
@WebServlet(name = "Cadastro", urlPatterns = {"/Cadastro"})
public class Cadastro extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String nome = request.getParameter("nome");
        String login;
        String profissao;
        double cpf;
        double telefone;
        String senha;
        String cSenha;
        String endereco;
        String mensagem;
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
        if(nome!=null && !nome.isEmpty()
                && request.getParameter("login") != null && !request.getParameter("login").isEmpty()
                && request.getParameter("profissao") != null && !request.getParameter("profissao").isEmpty()
                && request.getParameter("cpf") != null && !request.getParameter("cpf").isEmpty()
                && request.getParameter("telefone") != null && !request.getParameter("telefone").isEmpty()
                && request.getParameter("senha") != null && !request.getParameter("senha").isEmpty()
                && request.getParameter("csenha") != null && !request.getParameter("csenha").isEmpty()
                && request.getParameter("endereco") != null && !request.getParameter("endereco").isEmpty()
                ){
            if(request.getParameter("senha").equals(request.getParameter("csenha"))){
                profissao = request.getParameter("profissao");
                cpf = Double.parseDouble(request.getParameter("cpf"));
                telefone = Double.parseDouble((request.getParameter("telefone")));
                login = request.getParameter("login");
                senha = request.getParameter("senha");
                endereco = request.getParameter("endereco");
                
                Cliente cliente = new Cliente(nome, login, senha, profissao, cpf, telefone, endereco);
                if(cliente.auth() == false){
                    cliente.salvar();
                
                    mensagem = "Cliente cadastrado com Suceso!";
                    request.setAttribute("mensagem", mensagem);
                    dispatcher.forward(request, response);
                }else{
                    mensagem = "Cliente já cadastrado.";
                    request.setAttribute("mensagem", mensagem);
                    dispatcher.forward(request, response);
                }    
            }else{
                mensagem = "Senhas não correspondem.";
                request.setAttribute("mensagem", mensagem);
                dispatcher.forward(request, response);
            }
        }else{
            mensagem = "Campos obrigatório precisam ser preenchidos.";
            request.setAttribute("mensagem", mensagem);
            dispatcher.forward(request, response);
        }
    }

}
