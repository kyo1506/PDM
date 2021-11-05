<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.AutorController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.Autor" %>

<%
    Long id = Long.parseLong(request.getParameter("inputId"));
    String nome = request.getParameter("inputNome");

    AutorController autorController = new AutorController();
    Autor autor = autorController.getById(id);
    autor.setNome(nome);

    autorController.updateAutor(autor);
    response.sendRedirect("../../jsp/autor/update.jsp?autorId="+id);
%>