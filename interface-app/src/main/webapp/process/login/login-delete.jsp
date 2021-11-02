<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.UserAuthController" %>

<%
    Long id = Long.parseLong(request.getParameter("userId"));

    UserAuthController userAuthController = new UserAuthController();

    userAuthController.deleteById(id);

    response.sendRedirect("../../jsp/login/login.jsp");
%>