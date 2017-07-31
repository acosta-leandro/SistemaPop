<%-- 
LEANDRO
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Classes.Usuario"%>
<%@page import="Classes.Area"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Area</title>
        <link href="/SistemaPop/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="/SistemaPop/bootstrap/css/signin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>         

        <%
            request.setAttribute("idarea", request.getAttribute("idarea"));
            Area area = (Area) request.getAttribute("area");
            ArrayList<String> erros = (ArrayList<String>) request.getAttribute("erro");
            if (area == null) {
                area = new Area(0, "", true);
            } else {
                area = (Area) request.getAttribute("area");
            }
        %>

        <form action="/SistemaPop/Acao?tipo=area&operacao=cadastrarArea" method="post" class="form-signin">
            <h2 class="form-signin-heading">Cadastro de Areas</h2>

            <%                String s = "";
                if (erros != null) {
                    for (int i = 0; i < erros.size(); i++) {

            %>
            <div class="alert alert-danger" role="alert"><a><%=erros.get(i)%></a></div>
                    <% }
                        }
                    %>
            <label></label>
            <input type="text" name="descricao" class="form-control" placeholder="Area*" value="<%=area.getDescricao()%>">

            <br>
            <input class="btn btn-lg btn-primary btn-block" name="" type="submit" value="Salvar">

            <br>
            <a class="btn btn-lg btn-primary btn-block" href="ListarAreas.jsp">Voltar</a>
            <h5>* = Campos obrigatórios</h5>
        </form>    
    </body>
</html>
