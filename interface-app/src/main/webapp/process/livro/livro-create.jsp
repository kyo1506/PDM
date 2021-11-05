<%@page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.LivroController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.Livro" %>

<%
    String nome = request.getParameter("inputNome");

    LivroController livroController = new LivroController();

    livroController.insertLivro(new Livro(nome));
    response.sendRedirect("../../jsp/livro/livro.jsp");
%>