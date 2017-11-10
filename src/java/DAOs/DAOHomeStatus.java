/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Apoio.ConexaoBD;
import Classes.Area;
import Classes.HomeStatus;
import Classes.Pop;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class DAOHomeStatus {
    
    public void callStats() {
        countTotalPops();
        countTotalVersoes();
        countTotalMelhorias();
        countTotalUsuarios();
        countTotalPesquisas();
        countTotalVisualizacoes();
        mountMaisAcessados();
    }
    
    public void countTotalPops() {
        
        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM pop WHERE idupdate = 0;";
        
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            
            while (resultado.next()) {
                HomeStatus.setTotalPops(resultado.getInt(1));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de pops: " + e);
        }
        
    }
    
    public void countTotalVersoes() {
        
        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM pop;";
        
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            
            while (resultado.next()) {
                HomeStatus.setTotalVersoes(resultado.getInt(1));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de pops: " + e);
        }
        
    }
    
    public void countTotalMelhorias() {
        
        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM melhoria;";
        
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            
            while (resultado.next()) {
                HomeStatus.setTotalMelhorias(resultado.getInt(1));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de pops: " + e);
        }
        
    }
    
    public void countTotalUsuarios() {
        
        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM usuario;";
        
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            
            while (resultado.next()) {
                HomeStatus.setTotalUsuarios(resultado.getInt(1));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de pops: " + e);
        }
        
    }
    
    public void countTotalPesquisas() {
        
        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM estatistica WHERE tipo = 'p';";
        
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            
            while (resultado.next()) {
                HomeStatus.setTotalPesquisas(resultado.getInt(1));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de pops: " + e);
        }
        
    }
    
    public void countTotalVisualizacoes() {
        
        ResultSet resultado;
        String sql = "SELECT COUNT(*) FROM estatistica WHERE tipo = 'v';";
        
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            
            while (resultado.next()) {
                HomeStatus.setTotalVisualizacoes(resultado.getInt(1));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de pops: " + e);
        }
        
    }
    
    public void mountMaisAcessados() {
        ArrayList<String> popString = new ArrayList<>();
        ResultSet resultado;
        
        String sql = "SELECT pop, COUNT(pop) FROM estatistica GROUP BY pop ORDER BY 2 DESC";
        
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            
            while (resultado.next()) {
                Pop pop = new DAOPop().consultarId(resultado.getInt(1));
                String tmpPopString = "V" + pop.getVersao() + " - " + pop.getTitulo();
                popString.add(tmpPopString);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar quantidade de pops: " + e);
        }
        HomeStatus.setPopString(popString);
    }
    
}
