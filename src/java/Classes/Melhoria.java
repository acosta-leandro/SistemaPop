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
public class Melhoria {
    
    private int idMelhoria;
    private String melhoria;
    private boolean util;
    private boolean feita;
    private int idPop;
    private int idUsuario;

    public Melhoria(int idMelhoria, String melhoria, boolean util, boolean feita, int idPop, int idUsuario) {
        this.idMelhoria = idMelhoria;
        this.melhoria = melhoria;
        this.util = util;
        this.feita = feita;
        this.idPop = idPop;
        this.idUsuario = idUsuario;
    }
   
    public int getIdMelhoria() {
        return idMelhoria;
    }

    public void setIdMelhoria(int idMelhoria) {
        this.idMelhoria = idMelhoria;
    }

    public String getMelhoria() {
        return melhoria;
    }

    public void setMelhoria(String melhoria) {
        this.melhoria = melhoria;
    }

    public boolean isUtil() {
        return util;
    }

    public void setUtil(boolean util) {
        this.util = util;
    }

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }

    public int getIdPop() {
        return idPop;
    }

    public void setIdPop(int idPop) {
        this.idPop = idPop;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
        
}
