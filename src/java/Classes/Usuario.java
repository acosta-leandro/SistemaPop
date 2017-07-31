/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Leandro Acosta
 */
public class Usuario {

    private int idUsuario;
    private String login;
    private String senha;
    private String nome;
    private String email;
    private boolean ativo;
    private int idArea;
    private String permissao; //U - User | R - Revisor | A - Adm


    public Usuario(int idUsuario, String login, String senha, String nome, String email, boolean ativo, int idArea, String permissao) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
        this.permissao = permissao;
        this.idArea = idArea;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

}
