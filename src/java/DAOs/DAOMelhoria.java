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
                    + "" + melhoria.getIdUsuario() + ");";

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
                    + "ORDER BY 1");

            while (resultado.next()) {
                Melhoria melhoria = new Melhoria(0, "", false, false, 0, 0);
                melhoria.setIdMelhoria(resultado.getInt("idMelhoria"));
                melhoria.setMelhoria(resultado.getString("melhoria"));
                melhoria.setUtil(resultado.getBoolean("util"));
                melhoria.setUtil(resultado.getBoolean("feita"));
                melhoria.setIdPop(resultado.getInt("idPop"));
                melhoria.setIdUsuario(resultado.getInt("idUsuario"));
                melhorias.add(melhoria);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar areas: " + e);
        }
        return melhorias;
    }
}
