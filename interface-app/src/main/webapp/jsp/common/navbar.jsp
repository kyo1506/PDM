<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String url = request.getRequestURI();
    url = url.substring(0, 58);
%>

<header>
    <nav class="navbar navbar-expand-sm navbar-light bg-light">
        <div class="container-fluid">
            <a href="<%= url %>/homepage.jsp" class="navbar-brand">Sistema</a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Livros</a>
                        <div class="dropdown-menu">
                            <a href="<%= url %>/jsp/livro/create.jsp" class="dropdown-item">Novo Livro</a>
                            <div class="dropdown-divider"></div>
                            <a href="<%= url %>/jsp/livro/livro.jsp" class="dropdown-item">Detalhes</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Autores</a>
                        <div class="dropdown-menu">
                            <a href="<%= url %>/jsp/autor/create.jsp" class="dropdown-item">Novo Autor</a>
                            <div class="dropdown-divider"></div>
                            <a href="<%= url %>/jsp/autor/autor.jsp" class="dropdown-item">Detalhes</a>
                        </div>
                    </li>
                </ul>
                <ul class="nav navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <a href="<%= url %>/jsp/login/login.jsp" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Admin</a>
                        <div class="dropdown-menu dropdown-menu-end">
                            <a href="<%= url %>/jsp/login/create.jsp" class="dropdown-item">Novo usuário</a>
                            <div class="dropdown-divider"></div>
                            <a href="<%= url %>/jsp/login/login.jsp" class="dropdown-item">Detalhes</a>
                            <div class="dropdown-divider"></div>
                            <a href="<%= url %>/login.jsp" class="dropdown-item">Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>