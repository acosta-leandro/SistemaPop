/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Apoio.ConexaoBD;
import Classes.Area;
import Classes.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class DAOArea {

    public void salvar(Area area) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO area VALUES "
                    + "(DEFAULT,"
                    + "'" + area.getDescricao() + "',"
                    + "' TRUE ')";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Area> consultarTodos() {

        ResultSet resultado;
        ArrayList<Area> areas = new ArrayList<>();

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM area "
                    + "ORDER BY idarea");

            while (resultado.next()) {
                if (resultado.getBoolean("ativo")) {
                    Area area = new Area(0, "", true);
                    area.setIdArea(resultado.getInt("idarea"));
                    area.setDescricao(resultado.getString("area"));
                    area.setAtivo(resultado.getBoolean("ativo"));
                    areas.add(area);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar areas: " + e);
        }

        return areas;
    }

    public void atualizar(Area area) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE area SET "
                    + "area = '" + area.getDescricao() + "',"
                    + "WHERE idarea = '" + area.getIdArea() + "'";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE area SET "
                    + "ativo = 'false' "
                    + "WHERE idarea = " + id + "";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Area consultarId(int id) {

        ResultSet resultado;
        String sql = "SELECT * FROM area WHERE idarea = " + id;
        Area area = new Area(0, "", true);

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                area.setIdArea(resultado.getInt("idarea"));
                area.setDescricao(resultado.getString("area"));
                area.setAtivo(resultado.getBoolean("ativo"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar areas: " + e);
        }

        return area;
    }

    public String consultarNome(String id) {
        ResultSet resultado;
        Area area = new Area(0, "", true);
        String sql = "SELECT * FROM area WHERE idArea = '" + id + "'";
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            if (resultado.next()) {
                area.setIdArea(resultado.getInt("idarea"));
                area.setDescricao(resultado.getString("area"));
                area.setAtivo(resultado.getBoolean("ativo"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuário: " + e);
        }
        return area.getDescricao();
    }

}
