<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.LivroController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.Livro" %>

<%
    Long id = Long.parseLong(request.getParameter("inputId"));
    String nome = request.getParameter("inputNome");

    LivroController livroController = new LivroController();
    Livro livro = livroController.getById(id);
    livro.setNome(nome);

    livroController.updateLivro(livro);
    response.sendRedirect("../../jsp/livro/update.jsp?livroId="+id);
%>