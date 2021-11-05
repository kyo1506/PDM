<%@page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.UserAuthController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.UserAuth" %>

<%
    String email = request.getParameter("inputEmail");
    String username = request.getParameter("inputUsername");
    String password = request.getParameter("inputPassword");
    Long id = Long.parseLong(request.getParameter("inputId"));

    UserAuthController userAuthController = new UserAuthController();

    UserAuth userAuth = userAuthController.getById(id);

    userAuth.setEmail(email);
    userAuth.setUsername(username);
    userAuth.setPassword(password);

    userAuthController.updateUser(userAuth);
    response.sendRedirect("../../jsp/login/login.jsp");
%>