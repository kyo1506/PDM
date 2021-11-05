<%@page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.AutorController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.Autor" %>

<%
    String nome = request.getParameter("inputNome");

    AutorController autorController = new AutorController();

    autorController.insertAutor(new Autor(nome));
    response.sendRedirect("../../jsp/autor/autor.jsp");
%>