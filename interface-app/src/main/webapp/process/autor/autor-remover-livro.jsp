<%@page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.AutorController" %>

<%
    Long autorId = Long.parseLong(request.getParameter("autorId"));
    Long livroId = Long.parseLong(request.getParameter("livroId"));

    AutorController autorController = new AutorController();

    autorController.removerLivro(autorId, livroId);
    response.sendRedirect("../../jsp/autor/update.jsp?autorId="+autorId);
%>