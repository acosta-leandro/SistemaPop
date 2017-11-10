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
public class EstatisticaPesquisa {

    private int termosEncontrados;
    private int nosTitulos;
    private int nosObjetivos;
    private int nasAplicacoes;
    private int nosConteudos;
    private int naDivulgacao;
    private int popsDiferentes;

    public EstatisticaPesquisa(int termosEncontrados, int nosTitulos, int nosObjetivos, int nasAplicacoes, int nosConteudos, int naDivulgacao, int popsDiferentes) {
        this.termosEncontrados = termosEncontrados;
        this.nosTitulos = nosTitulos;
        this.nosObjetivos = nosObjetivos;
        this.nasAplicacoes = nasAplicacoes;
        this.nosConteudos = nosConteudos;
        this.naDivulgacao = naDivulgacao;
        this.popsDiferentes = popsDiferentes;
    }
    
    

    public int getTermosEncontrados() {
        return termosEncontrados;
    }

    public void setTermosEncontrados(int termosEncontrados) {
        this.termosEncontrados = termosEncontrados;
    }

    public int getNosTitulos() {
        return nosTitulos;
    }

    public void setNosTitulos(int nosTitulos) {
        this.nosTitulos = nosTitulos;
    }

    public int getNosObjetivos() {
        return nosObjetivos;
    }

    public void setNosObjetivos(int nosObjetivos) {
        this.nosObjetivos = nosObjetivos;
    }

    public int getNasAplicacoes() {
        return nasAplicacoes;
    }

    public void setNasAplicacoes(int nasAplicacoes) {
        this.nasAplicacoes = nasAplicacoes;
    }

    public int getNosConteudos() {
        return nosConteudos;
    }

    public void setNosConteudos(int nosConteudos) {
        this.nosConteudos = nosConteudos;
    }

    public int getNaDivulgacao() {
        return naDivulgacao;
    }

    public void setNaDivulgacao(int naDivulgacao) {
        this.naDivulgacao = naDivulgacao;
    }

    public int getPopsDiferentes() {
        return popsDiferentes;
    }

    public void setPopsDiferentes(int popsDiferentes) {
        this.popsDiferentes = popsDiferentes;
    }

}
