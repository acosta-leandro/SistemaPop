<%@page import="Classes.Melhoria"%>
<%@page import="DAOs.DAOMelhoria"%>
<%@page import="Apoio.Formatacao"%>
<%@page import="DAOs.DAOUsuario"%>
<%@page import="Classes.Pop"%>
<%@page import="DAOs.DAOPop"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópicos Recentes</title>

    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <div class="container">           
            <h1>Tópicos Recentes </h1>

            <%                String notificacao = (String) request.getAttribute("notificacao");
                ArrayList<Melhoria> melhorias = (ArrayList<Melhoria>) request.getAttribute("melhorias");
                Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
                Pop pop;
                DAOPop daofbpop = new DAOPop();

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
            <form action="/SistemaPops/Acao?tipo=pop&operacao=conspop&tipoConsulta=2&pagina=PopsRecentes" method="post" class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control input-lg" name="consulta" placeholder="Insira algum texto presente no tópico">
                </div>
                <button type="submit" class="btn btn-lg">Pesquisar</button>
            </form>
            <h5>DICA: Depois de qualquer consulta feita no site, clique no botão pesquisar, sem preencher o campo de pesquisa, para a tela sair do modo de pesquisa.</h5>
            <br>

            <%
                for (int i = 0; i < melhorias.size(); i++) {
                    Melhoria melhoria = (Melhoria) melhorias.get(i);
                    pop = new DAOPop().consultarId(melhoria.getIdPop());
                    //    ArrayList<Integer> pais = new DAORelPop().getPopsPai(t.getIdpop());

            %>        

            <input type="hidden" name="idPop" value="<%= melhoria.getIdPop()%>">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><%= "ID "+melhoria.getIdMelhoria() + " | V" + pop.getVersao() + " | POP " + pop.getTitulo()%>  
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
