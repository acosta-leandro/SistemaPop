<%-- 
    Document   : NovoComentario
    Created on : 24/10/2016, 13:41:39
    Author     : Cláudia
--%>

<%@page import="Classes.Melhoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Menu.jsp"%>

        <%            request.setAttribute("idPop", request.getAttribute("idPop"));
            Melhoria melhoria = (Melhoria) request.getAttribute("melhoria");
            Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
            String erro = (String) request.getAttribute("erro");

            if (melhoria == null) {
                melhoria = new Melhoria(0, "", false, false, 0, 0);
            }
        %>
        <div class="container">     
            <h2>Melhoria</h2>
            <br>

            <form action="/SistemaPop/Acao?tipo=melhoria&operacao=cadastrarMelhoria" method="post" class="form-horizontal">            
                <div class="form-group">               
                    <%
                        if (erro != null) {
                    %>
                    <div class="alert alert-danger" role="alert"><a><%=erro%></a></div>
                            <%
                                }
                            %>
                    <label class="col-sm-2 control-label">Usuário:</label>
                    <div class="col-md-8">                   
                        <label name="usuario"><%=usuario.getNome()%></label>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">Comentário:</label>
                    <div class="col-md-8">
                        <textarea class="form-control" rows="3" name ="texto" placeholder="Insira o texto*"><%= melhoria.getMelhoria()%></textarea>
                        <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario()%>">
                        <input type="hidden" name="idMelhoria" value="<%= melhoria.getIdMelhoria()%>">
                        <input type="hidden" name="idPop" value="<%= request.getAttribute("idPop")%>">
                        <input type="hidden" name="util" value="<%= melhoria.isUtil()%>">
                        <input type="hidden" name="feita" value="<%= melhoria.isFeita()%>">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">   
                        <input class="btn btn-default" name="" type="submit" value="Salvar Melhoria">
                        <h5>* = Campos obrigatórios</h5>   
                    </div>                
                </div>


            </form>  
        </div>
    </body>
</html>
