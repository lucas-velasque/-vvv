/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import org.apache.tomcat.jni.SSLContext;

/**
 *
 * @author lgcp1
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8   ");
        
        
        String nome = request.getParameter("nome");
        String senha;
        String mensagem;
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
        if(nome!=null && !nome.isEmpty()
                && request.getParameter("senha") != null && !request.getParameter("senha").isEmpty()
                ){
            senha = request.getParameter("senha");
            
            Cliente cliente =  new Cliente(nome, senha); 
    
            if(cliente.auth() == true){
                request.getSession().setAttribute("usuario", nome);
                response.sendRedirect("sessao.jsp");
                
            }else{
                mensagem = "Usuário não cadastrado.";
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
