<%-- 
Leandro Acosta
--%>


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
                Usuario l = (Usuario) session.getAttribute("usuarioLogado");
                Pop pop;
                DAOPop daofbtopico = new DAOPop();

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
            <form action="/SistemaPops/Acao?tipo=topico&operacao=constopico&tipoConsulta=2&pagina=PopsRecentes" method="post" class="form-inline">
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
                    //    ArrayList<Integer> pais = new DAORelPop().getPopsPai(t.getIdtopico());

            %>        

            <input type="hidden" name="idPop" value="<%= melhoria.getIdPop()%>">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><%= "Melhoria - " + melhoria.getIdMelhoria() + " | POP - V" + pop.getVersao() + " - " + pop.getTitulo()%>  
                        <a class="btn btn-default" href="/SistemaPop/Acao?tipo=filhos&id=<%=melhoria.getIdPop()%>&toriginal=<%=melhoria.getIdPop()%>" method="post">Visualizar</a>     
                    </h3>
                </div>

                <div class="panel-body t">
                    <%= melhoria.getMelhoria()%>
                </div>
                <div class="panel-footer">    
                    <div class="row">
                        <div class="col-md-4">Será Feito?</div>
                        <div class="col-md-4">Sim</div>
                        <div class="col-md-4"><a class="btn btn-default" href="/SistemaPop/Acao?tipo=filhos&id=<%=melhoria.getIdPop()%>&toriginal=<%=melhoria.getIdPop()%>" method="post">Visualizar</a>   </div>
                    </div> 
                    <br>
                    <div class="row">
                        <div class="col-md-4">Foi Feito?</div>
                        <div class="col-md-4">Sim</div>
                        <div class="col-md-4"><a class="btn btn-default" href="/SistemaPop/Acao?tipo=filhos&id=<%=melhoria.getIdPop()%>&toriginal=<%=melhoria.getIdPop()%>" method="post">Visualizar</a>   </div>
                    </div> 

                </div>

            </div> 
            <%
                }
            %>
        </div>
    </body>
</html>