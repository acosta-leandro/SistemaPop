/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Apoio.ConexaoBD;
import Classes.Area;
import Classes.Melhoria;
import Classes.Pop;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class DAOMelhoria {

    public void salvar(Melhoria melhoria) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO melhoria VALUES "
                    + "(DEFAULT,"
                    + "'" + melhoria.getMelhoria() + "',"
                    + "" + melhoria.isUtil() + ","
                    + "" + melhoria.isFeita() + ","
                    + "" + melhoria.getIdPop() + ","
                    + "" + melhoria.getIdUsuario() + ","
                    + "" + melhoria.isExcluido() + ");";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Melhoria> consultarTodos() {

        ResultSet resultado;
        ArrayList<Melhoria> melhorias = new ArrayList<>();

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM melhoria "
                    + "WHERE excluido != 'true' "
                    + "ORDER BY 1 DESC");

            while (resultado.next()) {
                Melhoria melhoria = new Melhoria(0, "", false, false, 0, 0, false);
                melhoria.setIdMelhoria(resultado.getInt("idMelhoria"));
                melhoria.setMelhoria(resultado.getString("melhoria"));
                melhoria.setUtil(resultado.getBoolean("util"));
                melhoria.setFeita(resultado.getBoolean("feita"));
                melhoria.setIdPop(resultado.getInt("idPop"));
                melhoria.setIdUsuario(resultado.getInt("idUsuario"));
                melhoria.setExcluido(resultado.getBoolean("excluido"));
                melhorias.add(melhoria);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar areas: " + e);
        }
        return melhorias;
    }

    public void seraFeito(int idMelhoria, String permissao) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE melhoria SET "
                    + "util = '" + permissao + "' "
                    + "WHERE idmelhoria = " + idMelhoria + "";

            st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void foiFeito(int idMelhoria, String permissao) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE melhoria SET "
                    + "feita = '" + permissao + "' "
                    + "WHERE idmelhoria = " + idMelhoria + "";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluir(int idMelhoria) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE melhoria SET "
                    + "excluido = true "
                    + "WHERE idmelhoria = " + idMelhoria + "";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void atualizarIdPopMelhoria(int idPopNew, int idPopOld) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE melhoria SET "
                    + "idPop = " + idPopNew
                    + " WHERE idPop = " + idPopOld + "";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Melhoria> pesquisar(String termo) {

        ArrayList<Melhoria> melhorias = new ArrayList<>();
        ResultSet resultado;
        String sql = "SELECT * FROM melhoria WHERE melhoria ILIKE '%" + termo + "%';";

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Melhoria melhoria = new Melhoria(0, "", false, false, 0, 0, false);
                melhoria.setIdMelhoria(resultado.getInt("idMelhoria"));
                melhoria.setMelhoria(resultado.getString("melhoria"));
                melhoria.setUtil(resultado.getBoolean("util"));
                melhoria.setFeita(resultado.getBoolean("feita"));
                melhoria.setIdPop(resultado.getInt("idPop"));
                melhoria.setIdUsuario(resultado.getInt("idUsuario"));
                melhoria.setExcluido(resultado.getBoolean("excluido"));
                melhorias.add(melhoria);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar pop: " + e);
        }
        return melhorias;
    }

    public ArrayList<Melhoria> pesquisarComPopId(String termo, int idPop) {

        ArrayList<Melhoria> melhorias = new ArrayList<>();
        ResultSet resultado;
        String sql = "SELECT * FROM melhoria WHERE melhoria LIKE '%" + termo + "%' AND idPop = " + idPop + ";";

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Melhoria melhoria = new Melhoria(0, "", false, false, 0, 0, false);
                melhoria.setIdMelhoria(resultado.getInt("idMelhoria"));
                melhoria.setMelhoria(resultado.getString("melhoria"));
                melhoria.setUtil(resultado.getBoolean("util"));
                melhoria.setFeita(resultado.getBoolean("feita"));
                melhoria.setIdPop(resultado.getInt("idPop"));
                melhoria.setIdUsuario(resultado.getInt("idUsuario"));
                melhoria.setExcluido(resultado.getBoolean("excluido"));
                melhorias.add(melhoria);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar pop: " + e);
        }
        return melhorias;
    }

    public ArrayList<Melhoria> pesquisarPopId(int idPop) {

        ArrayList<Melhoria> melhorias = new ArrayList<>();
        ResultSet resultado;
        String sql = "SELECT * FROM melhoria WHERE idPop = " + idPop + ";";

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Melhoria melhoria = new Melhoria(0, "", false, false, 0, 0, false);
                melhoria.setIdMelhoria(resultado.getInt("idMelhoria"));
                melhoria.setMelhoria(resultado.getString("melhoria"));
                melhoria.setUtil(resultado.getBoolean("util"));
                melhoria.setFeita(resultado.getBoolean("feita"));
                melhoria.setIdPop(resultado.getInt("idPop"));
                melhoria.setIdUsuario(resultado.getInt("idUsuario"));
                melhoria.setExcluido(resultado.getBoolean("excluido"));
                melhorias.add(melhoria);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar pop: " + e);
        }
        return melhorias;
    }
    
    public int notificarUserMelhoriasPendentes(int idUser) {
        ArrayList<Melhoria> melhorias = new ArrayList<>();
        int contagemMelhoriasPendentes = 0;
        DAOPop daoPop = new DAOPop();
        ResultSet resultado;
        String sql = "SELECT * FROM melhoria WHERE util = false;";
        int idPop = 0;
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                idPop = resultado.getInt("idPop");
                Pop pop = daoPop.consultarId(idPop);
                if (pop.getIdCriador() == idUser) {
                    contagemMelhoriasPendentes++;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar melhoria: " + e);
        }
        return contagemMelhoriasPendentes;
    }
}
