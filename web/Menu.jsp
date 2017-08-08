<%-- 
    Document   : Menu
    Created on : 23/08/2016, 20:44:25
    Author     : Cláudia
--%>

<%@page import="Classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/navbar.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <% // verificando se tem um atributo login na sessao
// se houver vai continuar e mostrar a pagina
            if (session.getAttribute("usuarioLogado") != null) {
                Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");

        %>
        <div class="container">

            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="Home.jsp">Sistema POP</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Área<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="CadastrarArea.jsp">Nova Área</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Listar</li>
                                    <li><a href="listarArea.jsp">Todos</a></li>
                                </ul>
                            </li>

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">POP <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="CadastrarPop.jsp">Novo Pop</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Listar</li>
                                    <li><a href="ListarPop.jsp">Todos</a></li>
                                    <li><a href="#">10 Últimos</a></li>
                                    <li><a href="#">Por Área</a></li>
                                </ul>
                            </li>

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Melhoria <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                          <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Listar</li>
                                    <li><a href="ListarMelhoria.jsp">Todas</a></li>
                                </ul>
                            </li>
                            <%                                    //    if (l.getPermissao().equalsIgnoreCase("A")) {
                            %>
                            <li><a href="ListarUsuario.jsp">Usuários</a></li>         
                                <%              //                  }
                                %>


                        </ul>
                        <ul class="nav navbar-nav navbar-right">

                            <li class="active"><a>  Olá <%=userLogado.getNome()%>  </a></li> 
                            <li><a OnClick="return confirm('Confirma Logout?')" href="/SistemaPop/Acao?tipo=login&operacao=logout">  Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

        </div> <!-- /container -->        

        <script src="bootstrap/js/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <%
        } else {
        %>
        <jsp:forward page="index.jsp"></jsp:forward>
        <%
            }
        %>    
    </body>
</html>
