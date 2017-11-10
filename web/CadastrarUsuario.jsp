<%@page import="java.util.ArrayList"%>
<%@page import="Classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tela de Cadastro</title>
        <link href="/SistemaPop/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="/SistemaPop/bootstrap/css/signin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>         

        <%
            Usuario usuario = (Usuario) request.getAttribute("usuario");
            ArrayList<String> erros = (ArrayList<String>) request.getAttribute("erro");

            if (usuario == null) {
                usuario = new Usuario(0, "", "", "", "", false, 1, "U");
            }

        %>

        <form action="/SistemaPop/Acao?tipo=usuario&operacao=cadastrarLogin" method="post" class="form-signin">
            <h2 class="form-signin-heading">Cadastro de Usuario</h2>

            <%                String s = "";
                if (erros != null) {
                    for (int i = 0; i < erros.size(); i++) {

            %>
            <div class="alert alert-danger" role="alert"><a><%=erros.get(i)%></a></div>
                    <% }
                        }
                    %>
            <label></label>
            <input type="text" name="nome" class="form-control" placeholder="Nome*" value="<%=usuario.getNome()%>">

            <label></label>
            <input type="text" name="login" class="form-control" placeholder="Login*" value="<%=usuario.getLogin()%>">

            <label></label>
            <input type="password" name="senha" class="form-control" placeholder="Senha*" value="">

            <label></label>
            <input type="password" name="senhacheck" class="form-control" placeholder="Repita a senha*" value="">

            <label></label>
            <input type="email" name="email" class="form-control" placeholder="E-mail*" value="<%=usuario.getEmail()%>">


            <br>
            <input class="btn btn-lg btn-primary btn-block" name="" type="submit" value="Salvar Cadastro">

            <br>
            <a class="btn btn-lg btn-primary btn-block" href="index.jsp">Voltar</a>
            <h5>* = Campos obrigatórios</h5>
        </form>


    </body>
</html>
