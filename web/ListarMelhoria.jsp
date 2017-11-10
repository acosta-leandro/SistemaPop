<%@page import="Classes.Melhoria"%>
<%@page import="DAOs.DAOMelhoria"%>
<%@page import="Apoio.Formatacao"%>
<%@page import="DAOs.DAOUsuario"%>
<%@page import="Classes.Pop"%>
<%@page import="DAOs.DAOPop"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Melhorias</title>

    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <div class="container">           
            <h1>Melhorias</h1>

            <%                String notificacao = (String) request.getAttribute("notificacao");
                ArrayList<Melhoria> melhorias = (ArrayList<Melhoria>) request.getAttribute("melhorias");
                ArrayList<Pop> pops = new DAOPop().consultarTodos();
                Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
                Pop pop;

                if (melhorias == null) {
                    melhorias = new DAOMelhoria().consultarTodos();
                }

            %>  

            <%                if (notificacao != null) {
            %>
            <div class="alert alert-success" role="alert"><a><%=notificacao%></a></div>
                    <%
                        }
                    %>

            <div class="container"> 
                <form action="/SistemaPop/Acao?tipo=melhoria&operacao=pesquisarMelhoria" method="post" class="form-inline">
                   
                    <div class="form-group">
                        <label  class="form-control">Pop:</label>
                        <div class="col-md-8">
                            <select name="popSelecionado">
                                <option>Todos</option>
                                <%
                                    for (int i = 0; i < pops.size(); i++) {
                                        Pop tmpPop = (Pop) pops.get(i);
                                %>
                                <option value=<%=tmpPop.getIdPop()%>> <%=tmpPop.getTitulo()%> </option>	                                
                                <% }%>
                            </select>      
                        </div>
                    </div> 
                            
                    <div class="form-group">
                        <input type="text" class="form-control" name="consulta">
                    </div> 
                            
                    <div class="form-group">
                         <button type="submit" class="btn btn-default">Pesquisar</button>  
                    </div> 
                    <br>
                    </div>
                    <%
                        for (int i = 0; i < melhorias.size(); i++) {
                            Melhoria melhoria = (Melhoria) melhorias.get(i);
                            pop = new DAOPop().consultarId(melhoria.getIdPop());
                            //    ArrayList<Integer> pais = new DAORelPop().getPopsPai(t.getIdpop());

                    %>        

                    <input type="hidden" name="idPop" value="<%= melhoria.getIdPop()%>">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><%= "ID " + melhoria.getIdMelhoria() + " | V" + pop.getVersao() + " | POP " + pop.getTitulo()%>  
                                <a class="btn btn-default" href="/SistemaPop/Acao?tipo=pop&operacao=visualizarPop&idPop=<%= pop.getIdPop()%>">Visualizar Pop</a>    
                                <a class="btn btn-default" OnClick="return confirm('Confirma Exclusão?')" href="/SistemaPop/Acao?tipo=melhoria&operacao=excluirMelhoria&idMelhoria=<%= melhoria.getIdMelhoria()%>">Excluir Melhoria</a>     
                            </h3>
                        </div>

                        <div class="panel-body t">
                            <%= melhoria.getMelhoria()%>
                        </div>
                        <% if (usuario.getPermissao().equals("A")) {%>
                        <div class="panel-footer">    
                            <div class="row">
                                <div class="col-md-4">Será Feito?</div>
                                <% if (melhoria.isUtil()) {%>
                                <div class="col-md-4">Sim</div>
                                <div class="col-md-4"><a class="btn btn-default" href="/SistemaPop/Acao?tipo=melhoria&operacao=seraFeitoNao&idMelhoria=<%= melhoria.getIdMelhoria()%>">Não</a></div>
                                <%} else {%>
                                <div class="col-md-4">Não</div>
                                <div class="col-md-4"><a class="btn btn-default" href="/SistemaPop/Acao?tipo=melhoria&operacao=seraFeitoSim&idMelhoria=<%= melhoria.getIdMelhoria()%>">Sim</a></div>
                                <%}%>
                            </div> 
                            <br>
                            <div class="row">
                                <div class="col-md-4">Foi Feito?</div>
                                <% if (melhoria.isFeita()) {%>
                                <div class="col-md-4">Sim</div>
                                <div class="col-md-4"><a class="btn btn-default" href="/SistemaPop/Acao?tipo=melhoria&operacao=foiFeitoNao&idMelhoria=<%= melhoria.getIdMelhoria()%>">Não</a></div>
                                <%} else {%>
                                <div class="col-md-4">Não</div>
                                <div class="col-md-4"><a class="btn btn-default" href="/SistemaPop/Acao?tipo=melhoria&operacao=foiFeitoSim&idMelhoria=<%= melhoria.getIdMelhoria()%>">Sim</a></div>
                                <%}%></div> 
                        </div>
                        <%}%>
                    </div> 
                    <%
                        }
                    %>
            </div>
    </body>
</html>
