<%@page import="DAOs.DAOArea"%>
<%@page import="java.util.List"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Classes.Area"%>
<%@page import="DAOs.DAOUsuario"%>
<%@page import="DAOs.DAOPop"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Classes.Pop"%>
<%@page import="Classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Pop</title>
        <link href="/SistemaPop/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="/SistemaPop/bootstrap/css/signin.css" rel="stylesheet" type="text/css"/>
        <script language="JavaScript">
            function retornar() {
                history.go(-1);
            }
        </script>
    </head>
    <body>
        <%@include file="Menu.jsp"%>
        <%            DAOPop daoPop = new DAOPop();
            DAOArea daoArea = new DAOArea();
            Pop pop = (Pop) request.getAttribute("pop");
            Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
            // ArrayList<Pop> pops = (ArrayList<Pop>) request.getAttribute("consulta");
            ArrayList<Pop> pops = new ArrayList<Pop>();
            String erro = (String) request.getAttribute("erro");
            ArrayList<Integer> checados = new ArrayList<Integer>();
            List areas = daoArea.consultarTodos();
            List usuarios = new DAOUsuario().consultarTodosAtivos();
            List revisores = new DAOUsuario().consultarTodosRevisoresAtivos();

            if (pop == null) {
                pop = new Pop(0, "", "", "", "", "", null, null, 0, "", 0, "", 0, "", 0, 0, true, false);
            } else {
            }


        %>
        <div class="container">     
            <h2>POP</h2>
            <br>

            <form action="/SistemaPop/Acao?tipo=pop&operacao=cadastrarPop" method="post" class="form-horizontal">            
                <div class="form-group">               
                    <input type="hidden" name="idCriador" value="<%= userLogado.getIdUsuario()%>">
                    <input type="hidden" name="idUpdate" value="<%= pop.getIdPop()%>">
                    <input type="hidden" name="versao" value="<%= pop.getVersao() + 1%>">
                    <input type="hidden" name="ultimaVersao" value="<%= pop.isUltimaVersao()%>">
                    <input type="hidden" name="excluido" value="<%= pop.isExcluido()%>">
                </div>

                <div class="form-group">
                    <label  class="col-sm-2 control-label">Título</label>
                    <div class="col-md-8">
                        <textarea class="form-control" rows="1" name ="titulo" placeholder="Insira o título*"><%= pop.getTitulo()%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">Objetivo:</label>
                    <div class="col-md-8">
                        <textarea class="form-control" rows="4" name ="objetivo" placeholder="Insira o objetivo*"><%= pop.getObjetivo()%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">Aplicação:</label>
                    <div class="col-md-8">
                        <textarea class="form-control" rows="4" name ="aplicacao" placeholder="Insira a aplicação*"><%= pop.getAplicacao()%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">Conteúdo:</label>
                    <div class="col-md-8">
                        <textarea class="form-control" rows="4" name ="conteudo" placeholder="Insira o conteúdo*"><%= pop.getConteudo()%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">Divulgação:</label>
                    <div class="col-md-8">
                        <textarea class="form-control" rows="4" name ="divulgacao" placeholder="Insira a divulgação*"><%= pop.getDivulgacao()%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">Area:</label>
                    <div class="col-md-8">
                        <select name="idArea">
                            <%
                                for (int i = 0; i < areas.size(); i++) {
                                    Area area = (Area) areas.get(i);
                            %>
                            <option value=<%=area.getIdArea()%>> <%=area.getDescricao()%> </option>																
                            <% }%>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">Revisor:</label>
                    <div class="col-md-8">
                        <select name="idRevisor">
                            <%
                                for (int i = 0; i < revisores.size(); i++) {
                                    Usuario revisor = (Usuario) revisores.get(i);
                            %>
                            <option value=<%=revisor.getIdUsuario()%>> <%=revisor.getNome()%> </option>																
                            <% }%>
                        </select>
                    </div>
                </div>
                <br>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">                           
                        <button type="submit" class="btn btn-default">Salvar</button>  
                        <a class ="btn btn-default" href="javascript:retornar();">Voltar</a>   
                        <h5>* = Campos obrigatórios</h5>   
                    </div>                
                </div>
        </div>
    </body>
</html>
