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
                        <a class="navbar-brand" href="#">Easy POP</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="Home.jsp">Início</a></li>
                            <li><a href="ListarArea.jsp">Areas</a></li>
                            <li><a href="CadastrarPop.jsp">CadastrarPop</a></li>
                            <li><a href="TopicosRecentes.jsp">Relatórios</a></li>
                                <%                                    //    if (l.getPermissao().equalsIgnoreCase("A")) {
                                %>
                            <li><a href="ListarUsuario.jsp">Usuários</a></li>         
                                <%              //                  }
                                %>

                            <%--
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Listagens <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="listaPais.jsp">País</a></li>
                                    <li><a href="#">Lugar</a></li>
                                    <li><a href="#">Modalidade</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Nav header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                            <li><a href="#">About</a></li>
                            <li><a href="#">Contact</a></li>
                            --%>

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
