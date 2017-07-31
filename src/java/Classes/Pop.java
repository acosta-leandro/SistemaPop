/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class Pop {
    
    private int idPop;
    private String titulo;
    private String objetivo;
    private String aplicacao;
    private String conteudo;
    private String divulgacao;
    private Date dtCriacao;
    private Date dtUpdate;
    private int idCriador;
    private String nomeCriador;
    private int idArea;
    private String nomeArea;
    private int idRevisor;
    private String nomeRevisor;
    private int idUpdate;
    private int versao;

    public Pop(int idPop, String titulo, String objetivo, String aplicacao, String conteudo, String divulgacao, Date dtCriacao, Date dtUpdate, int idCriador, String nomeCriador, int idArea, String nomeArea, int idRevisor, String nomeRevisor, int idUpdate, int versao) {
        this.idPop = idPop;
        this.titulo = titulo;
        this.objetivo = objetivo;
        this.aplicacao = aplicacao;
        this.conteudo = conteudo;
        this.divulgacao = divulgacao;
        this.dtCriacao = dtCriacao;
        this.dtUpdate = dtUpdate;
        this.idCriador = idCriador;
        this.nomeCriador = nomeCriador;
        this.idArea = idArea;
        this.nomeArea = nomeArea;
        this.idRevisor = idRevisor;
        this.nomeRevisor = nomeRevisor;
        this.idUpdate = idUpdate;
        this.versao = versao;
    }
    

    public int getIdPop() {
        return idPop;
    }

    public void setIdPop(int idPop) {
        this.idPop = idPop;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getDivulgacao() {
        return divulgacao;
    }

    public void setDivulgacao(String divulgacao) {
        this.divulgacao = divulgacao;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Date getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Date dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public int getIdCriador() {
        return idCriador;
    }

    public void setIdCriador(int idCriador) {
        this.idCriador = idCriador;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
        this.nomeCriador = nomeCriador;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public int getIdRevisor() {
        return idRevisor;
    }

    public void setIdRevisor(int idRevisor) {
        this.idRevisor = idRevisor;
    }

    public String getNomeRevisor() {
        return nomeRevisor;
    }

    public void setNomeRevisor(String nomeRevisor) {
        this.nomeRevisor = nomeRevisor;
    }

    public int getIdUpdate() {
        return idUpdate;
    }

    public void setIdUpdate(int idUpdate) {
        this.idUpdate = idUpdate;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }
    
    
    }
