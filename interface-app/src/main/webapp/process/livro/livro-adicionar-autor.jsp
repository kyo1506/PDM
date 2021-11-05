<%@page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.LivroController" %>

<%
    Long livroId = Long.parseLong(request.getParameter("livroId"));
    Long autorId = Long.parseLong(request.getParameter("autorId"));

    LivroController livroController = new LivroController();

    livroController.adicionarAutor(livroId, autorId);
    response.sendRedirect("../../jsp/livro/update.jsp?livroId="+livroId);
%>