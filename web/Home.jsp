<%-- 
    Document   : Home
    Created on : 11/08/2017, 19:41:11
    Author     : Leandro Acosta <leandro.acosta292@hotmail.com>
--%>

<%@page import="Classes.HomeStatus"%>
<%@page import="DAOs.DAOUsuario"%>
<%@page import="DAOs.DAOPop"%>
<%@page import="Classes.Pop"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/home.css" rel="stylesheet">
        <title>JSP Page</title>
        <%@include file="Menu.jsp" %>
    </head>
    <body>
        <%            ArrayList<Usuario> logins = new DAOUsuario().consultarTodos();
            ArrayList<String> popMaisAcessados = HomeStatus.getPopString();
        %>
        <div class="container">
            <div class="row">
                <div role="main" class="col-md-6 col-md-push-3">    
                    <h2>Mais Acessados</h2>
                    <dl>
                        <%
                            for (int i = 0; i < popMaisAcessados.size(); i++) {
                               
                        %>
                        <dt><%= popMaisAcessados.get(i)%> </dt>
                        <%  }%>
                    </dl>
                </div>
                <aside role="complementary" class="col-md-3 col-md-push-3">
                    <h2>Palavras Chaves</h2>
                    <dl>
                        <%                        for (int i = 0; i < logins.size(); i++) {
                                Usuario usuario = (Usuario) logins.get(i);
                        %>
                        <dt><%= usuario.getIdUsuario()%> </dt>
                        <%  }%>
                    </dl>
                </aside>
                <nav class="col-md-3 col-md-pull-9">
                    <h2>Totalizadores</h2>
                    <dl>
                        <dt>Total de Pops</dt>
                        <dd><%= HomeStatus.getTotalPops()%></dd>
                        <dt>Total de Versões</dt>
                        <dd><%= HomeStatus.getTotalVersoes()%></dd>
                        <dt>Total de Melhorias</dt>
                        <dd><%= HomeStatus.getTotalMelhorias()%></dd>
                        <dt>Total de Usuários</dt>
                        <dd><%= HomeStatus.getTotalUsuarios()%></dd>                       
                        <dt>Total de Pesquisas</dt>
                        <dd><%= HomeStatus.getTotalPesquisas()%></dd>
                        <dt>Total de Visualizações</dt>
                        <dd><%= HomeStatus.getTotalVisualizacoes()%></dd>
                    </dl>
                </nav>
            </div>
        </div>
    </body>
</html>
