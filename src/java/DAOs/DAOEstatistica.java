/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Apoio.ConexaoBD;
import Classes.Estatistica;
import Classes.EstatisticaPesquisa;
import Classes.HomeStatus;
import Classes.Melhoria;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class DAOEstatistica {

    public void salvarVisualizacao(Estatistica estatistica) {
        Timestamp dataAgora = new Timestamp(System.currentTimeMillis());

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO estatistica VALUES "
                    + "(DEFAULT,"
                    + "" + estatistica.getIdPop() + ","
                    + "'v',"
                    + "'" + dataAgora + "',"
                    + "" + estatistica.getIdUsuário() + ");";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public EstatisticaPesquisa returnEstatisticaPesquisa(String termo) {
        EstatisticaPesquisa estPesq = new EstatisticaPesquisa(
                0,
                countTermosTitulo(termo),
                countTermosObjetivo(termo),
                countTermosAplicacao(termo),
                countTermosConteudo(termo),
                countTermosDivulgacao(termo),
                0);
        return estPesq;
    }

    public int countTermosTitulo(String termo) {

        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM pop WHERE "
                + "titulo LIKE '%" + termo + "%' "
                + "AND excluido != 'true' AND ultimaversao = 'true'";

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                return resultado.getInt(1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de pops: " + e);
        }
        return 0;
    }

    public int countTermosObjetivo(String termo) {

        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM pop WHERE "
                + "objetivo LIKE '%" + termo + "%' "
                + "AND excluido != 'true' AND ultimaversao = 'true'";

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                return resultado.getInt(1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de objetivo: " + e);
        }
        return 0;
    }

    public int countTermosAplicacao(String termo) {

        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM pop WHERE "
                + "aplicacao LIKE '%" + termo + "%' "
                + "AND excluido != 'true' AND ultimaversao = 'true'";

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                return resultado.getInt(1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de aplicacao: " + e);
        }
        return 0;
    }

    public int countTermosConteudo(String termo) {

        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM pop WHERE "
                + "conteudo LIKE '%" + termo + "%' "
                + "AND excluido != 'true' AND ultimaversao = 'true'";
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                return resultado.getInt(1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de conteudo: " + e);
        }
        return 0;
    }

    public int countTermosDivulgacao(String termo) {

        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM pop WHERE "
                + "divulgacao LIKE '%" + termo + "%' "
                + "AND excluido != 'true' AND ultimaversao = 'true'";

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                return resultado.getInt(1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de divulgacao: " + e);
        }
        return 0;
    }
}
