<%@ page import="java.util.List" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.controller.UserAuthController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.UserAuth" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<%
    UserAuthController userAuthController = new UserAuthController();
    List<UserAuth> userAuthList = userAuthController.listAll();
%>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>.hidetext { -webkit-text-security: disc; }</style>
    <script>
        function validate(){
            search_input = document.getElementById("search-input");

            search_input.addEventListener("keydown", evt =>  {
                if (evt.key === "Enter"){
                    search_item = document.getElementById("search-input").value;
                    td_itens = document.querySelectorAll("table > tbody > tr > td:nth-child(2)");

                    td_itens.forEach(function (item){
                        if (item.textContent.toLowerCase().indexOf(search_item) != -1){
                            item.closest("tr").classList.remove("d-none");
                        }else{
                            item.closest("tr").classList.add("d-none");
                        }
                    })
                }
            })
        }
    </script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body onload="validate()">
<div class="container py-3">
    <jsp:include page="../common/navbar.jsp" />
    <main>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Filtrar por:</label>
            <div class="col-sm-10">
                <input class="form-control" id="search-input" >
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered">
                <caption>List of Users</caption>
                <thead class="table-dark">
                <tr>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>E-mail</th>
                    <th>Ações</th>
                </tr>
                </thead>
                <tbody>
                <% for (UserAuth userAuth : userAuthList){ %>
                    <tr>
                        <td><%= userAuth.getId() %></td>
                        <td><%= userAuth.getUsername() %></td>
                        <td class="hidetext"><%= userAuth.getPassword() %></td>
                        <td><%= userAuth.getEmail() %></td>
                        <td>
                            <a class="btn btn-success" href="../../jsp/login/update.jsp?userId=<%= userAuth.getId() %>"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="../../process/login/login-delete.jsp?userId=<%= userAuth.getId() %>"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                <%  } %>
                </tbody>
            </table>
        </div>
    </main>
    <jsp:include page="../common/footer.jsp" />
</div>
</body>
</html>
