/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Apoio.ConexaoBD;
import Classes.Area;
import Classes.Pop;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class DAOPop {

    public ArrayList<Pop> consultarTodos() {
        return null;
    }

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
}
