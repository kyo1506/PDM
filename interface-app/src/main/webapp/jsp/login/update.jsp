<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.controller.UserAuthController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.UserAuth" %>

<html>
<%
    UserAuthController userAuthController = new UserAuthController();
    UserAuth userAuth = userAuthController.getById(Long.parseLong(request.getParameter("userId")));
%>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<div class="container py-3">
    <jsp:include page="../common/navbar.jsp" />
    <main>
        <form action="../../process/login/login-update.jsp" method="post">

            <div class="mb-3">
                <label for="inputId" class="form-label">Id</label>
                <input type="text" readonly="readonly" class="form-control" id="inputId" name="inputId" value="<%= userAuth.getId() %>">
            </div>
            <div class="mb-3">
                <label for="inputEmail" class="form-label">Email address</label>
                <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp" name="inputEmail" value="<%= userAuth.getEmail() %>">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            </div>
            <div class="mb-3">
                <label for="inputUsername" class="form-label">Username</label>
                <input type="text" class="form-control" id="inputUsername" name="inputUsername" value="<%= userAuth.getUsername() %>">
            </div>
            <div class="mb-3">
                <label for="inputPassword" class="form-label">Password</label>
                <input type="password" class="form-control" id="inputPassword" name="inputPassword" value="<%= userAuth.getPassword() %>">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </main>
    <jsp:include page="../common/footer.jsp" />
</div>
</body>
</html>
