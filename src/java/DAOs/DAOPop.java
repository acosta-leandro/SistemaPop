/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Apoio.ConexaoBD;
import Classes.Area;
import Classes.Pop;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class DAOPop {

    public void cadastrar(Pop pop) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO pop VALUES "
                    + "(DEFAULT,"
                    + "'" + pop.getTitulo() + "',"
                    + "'" + pop.getObjetivo() + "',"
                    + "'" + pop.getAplicacao() + "',"
                    + "'" + pop.getConteudo() + "',"
                    + "'" + pop.getDivulgacao() + "',"
                    + "'" + pop.getDtCriacao() + "',"
                    + "'" + pop.getDtUpdate() + "',"
                    + "" + pop.getIdCriador() + ","
                    + "" + pop.getIdArea() + ","
                    + "" + pop.getIdRevisor() + ","
                    + "" + pop.getIdUpdate() + ","
                    + "" + pop.getVersao() + ");";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Pop> consultarTodos() {

        ResultSet resultado;
        ArrayList<Pop> pops = new ArrayList<>();
        String sql = "SELECT * FROM pop ORDER BY 1";

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Pop pop = new Pop(0, "", "", "", "", "", null, null, 0, "", 0, "", 0, "", 0, 0);
                pop.setIdPop(resultado.getInt("idpop"));
                pop.setTitulo(resultado.getString("titulo"));
                pop.setObjetivo(resultado.getString("objetivo"));
                pop.setAplicacao(resultado.getString("aplicacao"));
                pop.setConteudo(resultado.getString("conteudo"));
                pop.setDivulgacao(resultado.getString("divulgacao"));
                pop.setDtCriacao(resultado.getDate("dtCriacao"));
                pop.setDtUpdate(resultado.getDate("dtUpdate"));
                pop.setIdCriador(resultado.getInt("idCriador"));
                pop.setNomeCriador(new DAOUsuario().consultarNome(resultado.getString("idCriador")));
                pop.setIdArea(resultado.getInt("idArea"));
                pop.setNomeArea(new DAOArea().consultarNome(resultado.getString("idArea")));
                pop.setIdRevisor(resultado.getInt("idRevisor"));
                pop.setNomeRevisor(new DAOUsuario().consultarNome(resultado.getString("idRevisor")));
                pop.setIdUpdate(resultado.getInt("idUpdate"));
                pop.setVersao(resultado.getInt("versao"));

                pops.add(pop);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar pops: " + e);
        }
        return pops;
    }

    public Pop consultarId(int id) {

        ResultSet resultado;
        Pop pop = new Pop(0, "", "", "", "", "", null, null, 0, "", 0, "", 0, "", 0, 0);
        String sql = "SELECT * FROM pop WHERE idPop = " + id;

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

             if (resultado.next()) {
                pop.setIdPop(resultado.getInt("idpop"));
                pop.setTitulo(resultado.getString("titulo"));
                pop.setObjetivo(resultado.getString("objetivo"));
                pop.setAplicacao(resultado.getString("aplicacao"));
                pop.setConteudo(resultado.getString("conteudo"));
                pop.setDivulgacao(resultado.getString("divulgacao"));
                pop.setDtCriacao(resultado.getDate("dtCriacao"));
                pop.setDtUpdate(resultado.getDate("dtUpdate"));
                pop.setIdCriador(resultado.getInt("idCriador"));
                pop.setNomeCriador(new DAOUsuario().consultarNome(resultado.getString("idCriador")));
                pop.setIdArea(resultado.getInt("idArea"));
                pop.setNomeArea(new DAOArea().consultarNome(resultado.getString("idArea")));
                pop.setIdRevisor(resultado.getInt("idRevisor"));
                pop.setNomeRevisor(new DAOUsuario().consultarNome(resultado.getString("idRevisor")));
                pop.setIdUpdate(resultado.getInt("idUpdate"));
                pop.setVersao(resultado.getInt("versao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar pop: " + e);
        }
        return pop;
    }
}
