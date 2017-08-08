<%-- 
    Document   : index
    Created on : 16/08/2016, 20:41:14
    Author     : Cláudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Sistema Pop</title>
        <link href="/SistemaPop/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="/SistemaPop/bootstrap/css/signin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            String erro = (String) request.getAttribute("erro");
            String notificacao = (String) request.getAttribute("notificacao");
        %>
        <div class="container">

            <form action="/SistemaPop/Acao?tipo=usuario&operacao=login" method="post" class="form-signin">
                <h2 class="form-signin-heading">POP - Login</h2>
                <br>
                
                <%
                    if (notificacao != null) {
                %>
                    <div class="alert alert-success" role="alert"><a><%=notificacao%></a></div>
                <% 
                    }
                %>
                
                <%
                    if (erro != null) {
                %>
                <div class="alert alert-danger" role="alert"><a><%=erro%></a></div>
                <%
                    }
                %>
                <input type="text" name="login" class="form-control" placeholder="Email ou Usuário">
                <br>

                <input type="password" name="senha" class="form-control" placeholder="Senha">
                <br>

                <input class="btn btn-lg btn-primary btn-block" name="" type="submit" value="Efetuar Login">
                <br>

                <a class="btn btn-lg btn-primary btn-block" href="CadastrarUsuario.jsp">Efetuar cadastro</a>            
            </form>
        </div>

    </body>
</html>
