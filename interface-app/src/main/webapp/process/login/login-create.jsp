<%@page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.UserAuthController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.UserAuth" %>

<%
    String email = request.getParameter("inputEmail");
    String username = request.getParameter("inputUsername");
    String password = request.getParameter("inputPassword");

    UserAuthController userAuthController = new UserAuthController();

    userAuthController.insertUser(new UserAuth(email, username, password));
    response.sendRedirect("../../jsp/login/login.jsp");
%>