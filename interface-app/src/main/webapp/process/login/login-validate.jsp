<%@page contentType="text/html;charset=UTF-8" %>

<%@ page import="pdm.ads.fateczs.interfaceapp.controller.UserAuthController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.UserAuth" %>

<%
    String username = request.getParameter("floatingInput");
    String password = request.getParameter("floatingPassword");

    UserAuthController userAuthController = new UserAuthController();

    UserAuth userAuth = userAuthController.getByName(username);

    if (userAuth == null){
        request.getSession().setAttribute("login_error_message", "Usuário não encontrado!");
        response.sendRedirect("../../login.jsp");
    } else {
        if (userAuth.getPassword().equalsIgnoreCase(password)){
            response.sendRedirect("../../homepage.jsp");
        } else {
            request.getSession().setAttribute("login_error_message", "Usuário e/ou senha incorretos!");
            response.sendRedirect("../../login.jsp");
        }
    }
%>
