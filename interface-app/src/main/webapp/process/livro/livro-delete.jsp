<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.LivroController" %>

<%
    Long id = Long.parseLong(request.getParameter("livroId"));
    LivroController livroController = new LivroController();
    livroController.deleteById(id);
    response.sendRedirect("../../jsp/livro/livro.jsp");
%>