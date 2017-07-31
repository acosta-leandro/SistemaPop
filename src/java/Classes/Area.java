/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class Area {

    private int idArea;
    private String descricao;
    private boolean ativo;
    
    public Area(int idArea, String descricao, boolean ativo){
        this.idArea = idArea;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
}
