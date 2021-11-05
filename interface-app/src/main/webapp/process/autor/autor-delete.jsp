<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.AutorController" %>

<%
    Long id = Long.parseLong(request.getParameter("autorId"));
    AutorController autorController = new AutorController();
    autorController.deleteById(id);
    response.sendRedirect("../../jsp/autor/autor.jsp");
%>