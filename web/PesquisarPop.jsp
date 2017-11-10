<%-- 
    Document   : Home
    Created on : 11/08/2017, 19:41:11
    Author     : Leandro Acosta <leandro.acosta292@hotmail.com>
--%>

<%@page import="Classes.EstatisticaPesquisa"%>
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
            ArrayList<Pop> pops = (ArrayList<Pop>) request.getAttribute("pops");
            EstatisticaPesquisa estPesq = (EstatisticaPesquisa) request.getAttribute("estPesq");
        %>
        <div class="container">
            <div class="row">
                <div role="main" class="col-md-9 col-md-push-3">    
                    <h2>Resultados</h2>
                    <dl>
                        <%
                            for (int i = 0; i < pops.size(); i++) {
                                Pop tmpPop = pops.get(i);

                        %>
                        <dt><%= tmpPop.getTitulo() %> </dt>
                        <%  }%>
                    </dl>
                </div>
                <nav class="col-md-3 col-md-pull-9">
                    <h2>Estatísticas</h2>
                    <dl>
                        <dt>Termos Encontrados</dt>
                        <dd><%= estPesq.getNosTitulos()%></dd>
                        <dt>Nos Títulos</dt>
                        <dd><%= estPesq.getNosTitulos()%></dd>
                        <dt>Nos Objetivos</dt>
                        <dd><%= estPesq.getNosObjetivos()%></dd>
                        <dt>Nas Aplicações</dt>
                        <dd><%= estPesq.getNasAplicacoes()%></dd>                       
                        <dt>Nos Conteúdos</dt>
                        <dd><%= estPesq.getNosConteudos()%></dd>
                        <dt>Na Divulgação</dt>
                        <dd><%= estPesq.getNaDivulgacao()%></dd>
                        <dt>Pops Diferentes</dt>
                        <dd><%= estPesq.getPopsDiferentes()%></dd>
                    </dl>
                </nav>
            </div>
        </div>
    </body>
</html>
