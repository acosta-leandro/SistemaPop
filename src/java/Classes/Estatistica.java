/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class Estatistica {

    private int idEstatistica;
    private int idPop;
    private String tipo;
    private Date data;
    private int idUsuário;


    public Estatistica(int idEstatistica, int idPop, String tipo, Date data, int idUsuário) {
        this.idEstatistica = idEstatistica;
        this.idPop = idPop;
        this.tipo = tipo;
        this.data = data;
        this.idUsuário = idUsuário;
    }

    public int getIdEstatistica() {
        return idEstatistica;
    }

    public void setIdEstatistica(int idEstatistica) {
        this.idEstatistica = idEstatistica;
    }
    
        public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdPop() {
        return idPop;
    }

    public void setIdPop(int idPop) {
        this.idPop = idPop;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdUsuário() {
        return idUsuário;
    }

    public void setIdUsuário(int idUsuário) {
        this.idUsuário = idUsuário;
    }
    
    
}
