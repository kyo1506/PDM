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
                    <li class="nav-item">
                        <a href="<%= url %>/jsp/livro/livros.jsp" class="nav-link">Livros</a>
                    </li>
                    <li class="nav-item">
                        <a href="<%= url %>/jsp/autor/autores.jsp" class="nav-link">Autores</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <a href="<%= url %>/jsp/login/login.jsp" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Admin</a>
                        <div class="dropdown-menu dropdown-menu-end">
                            <a href="<%= url %>/jsp/login/create.jsp" class="dropdown-item">Novo usuário</a>
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