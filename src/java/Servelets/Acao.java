/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Apoio.Formatacao;
import Classes.Area;
import Classes.Melhoria;
import Classes.Pop;
import Classes.Usuario;
import DAOs.DAOArea;
import DAOs.DAOMelhoria;
import DAOs.DAOPop;
import DAOs.DAOUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Cláudia
 */
public class Acao extends HttpServlet {

    HttpServletRequest requisicao;
    HttpServletResponse resposta;

    DAOUsuario daoUsuario = new DAOUsuario();
    DAOArea daoArea = new DAOArea();
    DAOPop daoPop = new DAOPop();
    DAOMelhoria daoMelhoria = new DAOMelhoria();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Acao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Acao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //   processRequest(request, response);

        requisicao = request;
        resposta = response;

        System.out.println(requisicao.getParameter("tipo"));
        System.out.println(requisicao.getParameter("operacao"));

        if (requisicao.getParameter("tipo").equalsIgnoreCase("usuario")) {
            if (requisicao.getParameter("operacao").equalsIgnoreCase("cadastrarLogin")) {
                cadastrarLogin();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("login")) {
                login();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("logout")) {
                logout();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("ativar")) {
                ativar();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("desativar")) {
                desativar();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("tAdm")) {
                tAdm();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("tUser")) {
                tUser();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("tRevisor")) {
                tRevisor();
            }

        }
        if (requisicao.getParameter("tipo").equalsIgnoreCase("area")) {
            if (requisicao.getParameter("operacao").equalsIgnoreCase("cadastrarArea")) {
                area();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("listarArea")) {
                listarArea();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("excluir")) {
                excluirArea();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("editar")) {
                editarArea();
            }
        }
        if (requisicao.getParameter("tipo").equalsIgnoreCase("pop")) {
            if (requisicao.getParameter("operacao").equalsIgnoreCase("cadastrarPop")) {
                pop();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("excluirPop")) {
                excluirPop();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("excluirTodosPopsAnteriores")) {
                excluirTodosPopsAnteriores();
            }
        }
        if (requisicao.getParameter("tipo").equalsIgnoreCase("melhoria")) {
            if (requisicao.getParameter("operacao").equalsIgnoreCase("cadastrarMelhoria")) {
                cadastrarMelhoria();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("proporMelhoria")) {
                proporMelhoria();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("excluirMelhoria")) {
                excluirMelhoria();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("seraFeitoSim")) {
                melhoriaSeraFeitaSim();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("seraFeitoNao")) {
                melhoriaSeraFeitaNao();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("foiFeitoSim")) {
                melhoriaFoiFeitaSim();
            }
            if (requisicao.getParameter("operacao").equalsIgnoreCase("foiFeitoNao")) {
                melhoriaSeraFeitaNao();
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    //-> LOGIN

    private void cadastrarLogin() {
        int idArea;
        if (requisicao.getParameter("idArea") == null) {
            idArea = 1;
        } else {
            idArea = Integer.valueOf(requisicao.getParameter("idArea"));
        }

        Usuario user = new Usuario(0,
                requisicao.getParameter("login"),
                requisicao.getParameter("senha"),
                requisicao.getParameter("nome"),
                requisicao.getParameter("email"),
                Boolean.valueOf(requisicao.getParameter("ativo")),
                idArea,
                requisicao.getParameter("permissao"));

        //Checa o se há erro
        if (daoUsuario.consultaEmail(requisicao.getParameter("usuario")).getIdUsuario() != 0
                || requisicao.getParameter("login").isEmpty() == true
                || (requisicao.getParameter("senha").equals(requisicao.getParameter("senhacheck"))) == false
                || requisicao.getParameter("senha").isEmpty() == true || requisicao.getParameter("senhacheck").isEmpty() == true
                || daoUsuario.consultaEmail(requisicao.getParameter("email")).getIdUsuario() != 0
                || requisicao.getParameter("email").isEmpty() == true) {

            ArrayList<String> erros = new ArrayList<>();
            String erro = "";

            if (daoUsuario.consultaEmail(requisicao.getParameter("usuario")).getIdUsuario() != 0) {
                erro = "- Usuário ja cadastrado no sistema";
                erros.add(erro);
            }
            if (requisicao.getParameter("login").isEmpty() == true) {
                erro = "- Campo login não preenchido";
                erros.add(erro);
            }
            if ((requisicao.getParameter("senha").equals(requisicao.getParameter("senhacheck"))) == false) {
                erro = "- Senhas incoerentes";
                erros.add(erro);
            }
            if (requisicao.getParameter("senha").isEmpty() == true || requisicao.getParameter("senhacheck").isEmpty() == true) {
                erro = "- Campo(s) de senha não preenchido(s)";
                erros.add(erro);
            }
            if (daoUsuario.consultaEmail(requisicao.getParameter("email")).getIdUsuario() != 0) {
                erro = "- E-mail já cadastrado no sistema";
                erros.add(erro);
            }
            if (requisicao.getParameter("email").isEmpty() == true) {
                erro = "- Campo e-mail não preenchido";
                erros.add(erro);
            }

            requisicao.setAttribute("erro", erros);
            requisicao.setAttribute("usuario", user);
            encaminharPagina("CadastrarUsuario.jsp");

        } else {
            daoUsuario.cadastrar(user);
            String notificacao = "Cadastro feito com sucesso";
            requisicao.setAttribute("notificacao", notificacao);
            requisicao.setAttribute("paginaRetorno", "cadastrarLogin");
            encaminharPagina("index.jsp");
        }
    }

    //-> AREA
    private void area() {
        Area area = new Area(0,
                requisicao.getParameter("descricao"),
                true);
//        //Checa o se há erro
//        if (requisicao.getParameter("descricao").isEmpty()) {
//            String erro = "Descrição Vazia";
//            System.out.println(erro);
//    //        encaminharPagina("Home.jsp");
//        } else 
        if (area.getIdArea() == 0) {
            daoArea.salvar(area);
            String notificacao = "Area cadastrada com sucesso";
            encaminharPagina("ListarArea.jsp");
        } else {
            daoArea.atualizar(area);
            String notificacao = "Area editada com sucesso";
            encaminharPagina("ListarArea.jsp");
        }
    }

    private void listarArea() {

    }

    private void excluirArea() {
        daoArea.excluir(Integer.parseInt(requisicao.getParameter("idarea")));
        String notificacao = "Area Excluída";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarArea.jsp");
    }

    private void editarArea() {

        Area area = daoArea.consultarId(Integer.parseInt(requisicao.getParameter("idarea")));
        if (area.getIdArea() != 0) {
            requisicao.setAttribute("area", area);
            encaminharPagina("CadastrarArea.jsp");
        } else {
            System.out.println("Erro ao editar topico");
        }
    }

    //-> OUTROS
    private void encaminharPagina(String pagina) {
        try {
            RequestDispatcher rd = requisicao.getRequestDispatcher(pagina);
            rd.forward(requisicao, resposta);
        } catch (Exception e) {
            System.out.println("Erro de encaminhamento :" + e);
        }
    }

    private void login() {
        Usuario usuario = daoUsuario.login(requisicao.getParameter("login"), requisicao.getParameter("senha"));

        if (usuario.getIdUsuario() != 0) {

            HttpSession sessao = requisicao.getSession();
            sessao.setAttribute("usuarioLogado", usuario);
            requisicao.setAttribute("paginaRetorno", "logar");
            encaminharPagina("Home.jsp");
        } else {
            String erro = "Usuário/E-mail ou senha inválidos";
            requisicao.setAttribute("erro", erro);
            encaminharPagina("Home.jsp");
            System.out.println("erro+" + erro);
        }
    }

    private void pop() {
        Date dtCriacao;
        Date dtUpdate;
        if (requisicao.getParameter("dtCriacao") == null) {
            dtCriacao = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        } else {
            dtCriacao = Date.valueOf(requisicao.getParameter("dtCriacao"));
        }

        if (requisicao.getParameter("dtUpdate") == null) {
            dtUpdate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        } else {
            dtUpdate = Date.valueOf(requisicao.getParameter("dtUpdate"));
        }

        if (requisicao.getParameter("dtUpdate") == null) {
            dtUpdate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        } else {
            dtUpdate = Date.valueOf(requisicao.getParameter("dtUpdate"));
        }

        Pop pop = new Pop(0,
                requisicao.getParameter("titulo"),
                requisicao.getParameter("objetivo"),
                requisicao.getParameter("aplicacao"),
                requisicao.getParameter("conteudo"),
                requisicao.getParameter("divulgacao"),
                dtCriacao,
                dtUpdate,
                Integer.valueOf(requisicao.getParameter("idCriador")),
                requisicao.getParameter("nomeCriador"),
                Integer.valueOf(requisicao.getParameter("idArea")),
                daoUsuario.consultarNome(requisicao.getParameter("idArea")),
                Integer.valueOf(requisicao.getParameter("idRevisor")),
                daoUsuario.consultarNome(requisicao.getParameter("idRevisor")),
                Integer.valueOf(requisicao.getParameter("idUpdate")),
                Integer.valueOf(requisicao.getParameter("versao")),
                Boolean.valueOf(requisicao.getParameter("ultimaVersao")),
                Boolean.valueOf(requisicao.getParameter("excluido")));

        daoPop.cadastrar(pop);
        String notificacao = "Cadastro feito com sucesso";
        requisicao.setAttribute("notificacao", notificacao);
        requisicao.setAttribute("paginaRetorno", "cadastrarLogin");
        encaminharPagina("Home.jsp");

    }

    private void logout() {
        HttpSession sessao = requisicao.getSession();
        sessao.invalidate();
        encaminharPagina("index.jsp");
    }

    private void ativar() {
        daoUsuario.ativarDesativar(Integer.parseInt(requisicao.getParameter("idusuario")), true);
        String notificacao = "Usuário Ativado";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarUsuario.jsp");
    }

    private void desativar() {
        daoUsuario.ativarDesativar(Integer.parseInt(requisicao.getParameter("idusuario")), false);
        String notificacao = "Usuário Desativado";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarUsuario.jsp");
    }

    private void tUser() {
        daoUsuario.permissionar(Integer.parseInt(requisicao.getParameter("idusuario")), "U");
        String notificacao = "Promovido para Usuário";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarUsuario.jsp");
    }

    private void tRevisor() {
        daoUsuario.permissionar(Integer.parseInt(requisicao.getParameter("idusuario")), "R");
        String notificacao = "Promovido para Revisor";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarUsuario.jsp");
    }

    private void tAdm() {
        daoUsuario.permissionar(Integer.parseInt(requisicao.getParameter("idusuario")), "A");
        String notificacao = "Promovido para Administrador";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarUsuario.jsp");
    }

    //-> Melhoria
    private void cadastrarMelhoria() {
        Melhoria melhoria = new Melhoria(0,
                requisicao.getParameter("melhoria"),
                Boolean.valueOf(requisicao.getParameter("util")),
                Boolean.valueOf(requisicao.getParameter("feita")),
                Integer.valueOf(requisicao.getParameter("idPop")),
                Integer.valueOf(requisicao.getParameter("idUsuario")),
                Boolean.valueOf(requisicao.getParameter("excluido")));

        if (melhoria.getIdMelhoria() == 0) {
            daoMelhoria.salvar(melhoria);
            String notificacao = "Melhoria cadastrada com sucesso";
            encaminharPagina("ListarMelhoria.jsp");
        } else {
            // daoMelhoria.atualizar(melhoria);
            String notificacao = "Melhoria editada com sucesso";
            encaminharPagina("ListarMelhoria.jsp");
        }
    }

    private void proporMelhoria() {
        requisicao.setAttribute("idPop", requisicao.getParameter("idPop"));
        encaminharPagina("CadastrarMelhoria.jsp");
    }

    private void excluirPop() {
        daoPop.excluir(Integer.parseInt(requisicao.getParameter("idPop")));
        String notificacao = "Pop Excluído";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarPop.jsp");
    }

    private void excluirTodosPopsAnteriores() {
        Pop tmpPop = daoPop.consultarId(Integer.parseInt(requisicao.getParameter("idPop")));
        if (tmpPop.isUltimaVersao()) {
            daoPop.excluirTodasVersões(Integer.parseInt(requisicao.getParameter("idPop")));
            String notificacao = "Todas versões deste POP Excluídos!";
            requisicao.setAttribute("notificacao", notificacao);
            encaminharPagina("ListarPop.jsp");
        } else {
            String notificacao = "Selecione a última versão deste POP para excluir todos!";
            requisicao.setAttribute("notificacao", notificacao);
            encaminharPagina("ListarPop.jsp");
        }
    }

    private void melhoriaSeraFeitaSim() {
        daoMelhoria.seraFeito(Integer.parseInt(requisicao.getParameter("idMelhoria")), "true");
        String notificacao = "Melhoria Será Feita!";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarMelhoria.jsp");
    }

    private void melhoriaSeraFeitaNao() {
        daoMelhoria.seraFeito(Integer.parseInt(requisicao.getParameter("idMelhoria")), "false");
        String notificacao = "Melhoria Não Será Feita!";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarMelhoria.jsp");
    }

    private void melhoriaFoiFeitaSim() {
        daoMelhoria.foiFeito(Integer.parseInt(requisicao.getParameter("idMelhoria")), "true");
        String notificacao = "Melhoria Feita!";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarMelhoria.jsp");
    }

    private void melhoriaFoiFeitaNao() {
        daoMelhoria.foiFeito(Integer.parseInt(requisicao.getParameter("idMelhoria")), "false");
        String notificacao = "Melhoria Não Feita!";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarMelhoria.jsp");
    }

    private void excluirMelhoria() {
        daoMelhoria.excluir(Integer.parseInt(requisicao.getParameter("idMelhoria")));
        String notificacao = "Melhoria Excluída!";
        requisicao.setAttribute("notificacao", notificacao);
        encaminharPagina("ListarMelhoria.jsp");
    }

}
