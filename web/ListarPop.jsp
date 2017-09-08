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
                ArrayList<Pop> pops = new DAOPop().consultarTodos();
                Usuario l = (Usuario) session.getAttribute("usuarioLogado");
                DAOPop daofbpop = new DAOPop();

                if (pops == null) {
                    pops = new DAOPop().consultarTodos();
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
                for (int i = 0; i < pops.size(); i++) {
                    Pop pop = (Pop) pops.get(i);

                    //    ArrayList<Integer> pais = new DAORelPop().getPopsPai(t.getIdpop());

            %>        

            <input type="hidden" name="idpoppai" value="<%= pop.getIdPop()%>">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><%= "V" + pop.getVersao() + " - " + pop.getTitulo()%>  
                        <a class="btn btn-default" href="/SistemaPop/Acao?tipo=pop&operacao=visualizarPop&idPop=<%= pop.getIdPop()%>">Visualizar</a>    
                    </h3>
                </div>

                <div class="panel-body t">
                    <%= pop.getConteudo()%>
                </div>
                <div class="panel-footer">    
                    <%
                        if (pop.getVersao() != 1 && pop.isUltimaVersao()) {
                    %>
                    <a class ="btn btn-default" href="/SistemaPop/Acao?tipo=filhos&id=<%=pop.getIdPop()%>&toriginal=<%=pop.getIdPop()%>">Anteriores</a>     
                    <%
                        }
                        if (pop.getIdCriador() == l.getIdUsuario() && pop.isUltimaVersao()) {
                    %>  
                    <a class ="btn btn-default" href="/SistemaPop/Acao?tipo=melhoria&operacao=proporMelhoria&idPop=<%=pop.getIdPop()%>">Propor Melhorias</a>                   

                    <a class ="btn btn-default" href="/SistemaPop/Acao?tipo=pop&operacao=editarPop&idPop=<%=pop.getIdPop()%>">Atualizar</a>                   
                    <%
                        }
                    %>

                    <%
                        if (pop.getIdCriador() == l.getIdUsuario() || l.getPermissao().equalsIgnoreCase("A")) {
                    %>
                    <a class ="btn btn-default" OnClick="return confirm('Deseja excluir?')" href="/SistemaPop/Acao?tipo=pop&operacao=excluirPop&idPop=<%=pop.getIdPop()%>" >Excluir</a>         
                    <%
                        if (pop.isUltimaVersao()) {
                    %>

                    <a class ="btn btn-default" OnClick="return confirm('Deseja excluir TODAS as versões?')" href="/SistemaPop/Acao?tipo=pop&operacao=excluirTodosPopsAnteriores&idPop=<%=pop.getIdPop()%>">Excluir Todas Versões</a>         

                    <%
                            }
                        }
                    %>
                </div>

            </div> 
            <%
                }
            %>
        </div>
    </body>
</html>
