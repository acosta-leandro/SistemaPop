<%-- 
    Document   : ListaUsuarios
    Created on : 13/10/2016, 19:22:53
    Author     : Cláudia
--%>

<%@page import="Classes.Area"%>
<%@page import="DAOs.DAOArea"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <div class="container">
            <h1>Lista de Usuários</h1>

            <%                String notificacao = (String) request.getAttribute("notificacao");
                ArrayList<Area> logins = (ArrayList<Area>) request.getAttribute("consulta");

                if (logins == null) {
                    logins = new DAOArea().consultarTodos();
                }
                if (notificacao != null) {
            %>
            <div class="alert alert-success" role="alert"><a><%=notificacao%></a></div>
                    <%
                        }
                    %>

            <form action="/SistemaTopicos/Acao?tipo=area&operacao=listarArea" method="post" class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control input-lg" name="consulta" placeholder="Insira um termo presente no nome de usuário">
                    <button type="submit" class="btn btn-lg">Pesquisar</button>
                </div>
            </form>
            <br>


            <div class="table-responsive">
                <table class="table table-bordered table-condensed">
                    <tr>
                        <td>ID</td>
                        <td><a class="btn btn-default" href="CadastrarArea.jsp">Novo</a></td>
                    </tr>
                    <%
                        for (int i = 0; i < logins.size(); i++) {
                            Area area = (Area) logins.get(i);


                    %>

                    <tr>
                        <td><%= area.getIdArea()%> </td>
                        <td><%= area.getDescricao()%> </td>
                        <td><a OnClick="return confirm('Confirma Operação?')" href="/SistemaPop/Acao?tipo=area&operacao=editar&idarea=<%= area.getIdArea()%>">Editar</a> </td>
                        <td><a OnClick="return confirm('Confirma Exclusão?')" href="/SistemaPop/Acao?tipo=area&operacao=excluir&idarea=<%= area.getIdArea()%>">Excluir</a> </td>
                    </tr>
                    <%
                        }
                    %>

                </table>
                <a class="btn btn-default" href="Home.jsp">Voltar</a>
            </div>
        </div>
    </body>
</html>