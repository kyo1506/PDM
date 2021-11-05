<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.controller.AutorController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.Autor" %>
<%@ page import="java.util.List" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.controller.LivroController" %>
<%@ page import="pdm.ads.fateczs.interfaceapp.model.bean.Livro" %>
<%@ page import="java.util.Objects" %>

<html>
<%
    AutorController autorController = new AutorController();
    Autor autor = autorController.getById(Long.parseLong(request.getParameter("autorId")));

    LivroController livroController = new LivroController();
    List<Livro> livroList = livroController.listAll();
    if (autor.getLivros() != null){
        for (int i = 0; i < autor.getLivros().size(); i++){
            for (int j = 0; j < livroList.size(); j++){
                if (Objects.equals(autor.getLivros().get(i).getId(), livroList.get(j).getId())){
                    livroList.remove(j);
                }
            }
        }
    }
%>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../../assets/css/dropdown.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<div class="container py-3">
    <jsp:include page="../common/navbar.jsp" />
    <main>
        <form action="../../process/autor/autor-update.jsp" method="post">
            <div class="mb-3">
                <label for="inputId" class="form-label">Id</label>
                <input type="text" readonly="readonly" class="form-control" id="inputId" name="inputId" value="<%= autor.getId() %>">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <button class="btn btn-outline-secondary" type="submit">Atualizar</button>
                </div>
                <input type="text" class="form-control" name="inputNome" id="inputNome" aria-describedby="basic-addon1" value="<%= autor.getNome() %>">
            </div>
            <div class="mb-3">
                <div class="dropdown">
                    <button class="dropbtn">Livros disponíveis</button>
                    <div class="dropdown-content">
                        <% for (Livro livro: livroList) {%>
                            <a href="../../process/autor/autor-adicionar-livro.jsp?autorId=<%= autor.getId() %>&livroId=<%= livro.getId() %>"><%= livro.getNome() %></a>
                        <%}%>
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <ul class="list-group list-group-flush">
                    <%if (autor.getLivros() != null){%>
                        <%for (Livro livro: autor.getLivros()){%>
                        <li class="list-group-item">
                            <%= livro.getNome() %>
                            <a class="btn btn-danger" href="../../process/autor/autor-remover-livro.jsp?autorId=<%= autor.getId() %>&livroId=<%= livro.getId() %>"><i class="far fa-trash-alt"></i></a>
                        </li>
                        <%}%>
                    <%}%>
                </ul>
            </div>
        </form>
    </main>
    <jsp:include page="../common/footer.jsp" />
</div>
</body>
</html>
