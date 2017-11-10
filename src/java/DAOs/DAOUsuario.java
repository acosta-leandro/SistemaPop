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
 */
public class DAOUsuario {

    public void cadastrar(Usuario login) {
        System.out.println("teste1");
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO usuario VALUES "
                    + "(DEFAULT,"
                    + "'" + login.getLogin() + "',"
                    + "'" + login.getSenha() + "',"
                    + "'" + login.getNome() + "',"
                    + "'" + login.getEmail() + "',"
                    + "'" + false + "',"
                    + " 1,"
                    + "'U')";

            st.execute(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Usuario consultaEmail(String email) {
        ResultSet resultado;
        Usuario usuario = new Usuario(0, "", "", "", "", true, 0, "");
        String sql = "SELECT * FROM usuario WHERE email = '" + email + "'";
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            if (resultado.next()) {
                usuario.setIdUsuario(resultado.getInt("idusuario"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setAtivo(resultado.getBoolean("ativo"));
                usuario.setIdArea(resultado.getInt("idarea"));
                usuario.setPermissao(resultado.getString("permissao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o login email: " + e);
        }
        return usuario;
    }

    public Usuario login(String login, String senha) {
        ResultSet resultado;
        Usuario usuario = new Usuario(0, "", "", "", "", true, 0, "");

        String sql = "SELECT * FROM usuario WHERE login = '" + login
                + "' AND senha = '" + senha + "' "
                + "AND ativo = 'true';";
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            if (resultado.next()) {
                usuario.setIdUsuario(resultado.getInt("idusuario"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setAtivo(resultado.getBoolean("ativo"));
                usuario.setIdArea(resultado.getInt("idarea"));
                usuario.setPermissao(resultado.getString("permissao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar login: " + e);
        }
        new DAOHomeStatus().callStats();
        return usuario;
    }

    public ArrayList<Usuario> consultarTodos() {

        ResultSet resultado;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM usuario "
                    + "ORDER BY idUsuario");

            while (resultado.next()) {
                Usuario usuario = new Usuario(0, "", "", "", "", true, 0, "");
                usuario.setIdUsuario(resultado.getInt("idUsuario"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setAtivo(resultado.getBoolean("ativo"));
                usuario.setIdArea(resultado.getInt("idarea"));
                usuario.setPermissao(resultado.getString("permissao"));
                usuarios.add(usuario);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuários: " + e);
        }

        return usuarios;
    }

    public void ativarDesativar(int idUsuario, boolean ativo) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario SET "
                    + "ativo = '" + ativo + "' "
                    + "WHERE idusuario = " + idUsuario + "";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void permissionar(int idUsuario, String permissao) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario SET "
                    + "permissao = '" + permissao + "' "
                    + "WHERE idusuario = " + idUsuario + "";

            int resultado = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Usuario> consultarTodosAtivos() {

        ResultSet resultado;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM usuario "
                    + "ORDER BY idUsuario");

            while (resultado.next()) {
                if (resultado.getBoolean("ativo") == true) {
                    Usuario usuario = new Usuario(0, "", "", "", "", true, 0, "");
                    usuario.setIdUsuario(resultado.getInt("idUsuario"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenha(resultado.getString("senha"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setEmail(resultado.getString("email"));
                    usuario.setAtivo(resultado.getBoolean("ativo"));
                    usuario.setIdArea(resultado.getInt("idarea"));
                    usuario.setPermissao(resultado.getString("permissao"));
                    usuarios.add(usuario);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuários: " + e);
        }

        return usuarios;
    }

    public ArrayList<Usuario> consultarTodosRevisoresAtivos() {

        ResultSet resultado;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM usuario "
                    + "WHERE permissao  = 'A' OR permissao = 'R' "
                    + "ORDER BY idUsuario");

            while (resultado.next()) {
                if (resultado.getBoolean("ativo") == true) {
                    Usuario usuario = new Usuario(0, "", "", "", "", true, 0, "");
                    usuario.setIdUsuario(resultado.getInt("idUsuario"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenha(resultado.getString("senha"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setEmail(resultado.getString("email"));
                    usuario.setAtivo(resultado.getBoolean("ativo"));
                    usuario.setIdArea(resultado.getInt("idarea"));
                    usuario.setPermissao(resultado.getString("permissao"));
                    usuarios.add(usuario);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuários: " + e);
        }

        return usuarios;
    }

    public Usuario consultar(int id) {
        ResultSet resultado;
        Usuario usuario = new Usuario(0, "", "", "", "", true, 0, "");
        String sql = "SELECT * FROM usuario WHERE idUsuario = '" + id + "'";
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            if (resultado.next()) {
                usuario.setIdUsuario(resultado.getInt("idusuario"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setAtivo(resultado.getBoolean("ativo"));
                usuario.setIdArea(resultado.getInt("idarea"));
                usuario.setPermissao(resultado.getString("permissao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuário: " + e);
        }
        return usuario;
    }

    public String consultarNome(String id) {
        ResultSet resultado;
        Usuario usuario = new Usuario(0, "", "", "", "", true, 0, "");
        String sql = "SELECT * FROM usuario WHERE idUsuario = '" + id + "'";
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            if (resultado.next()) {
                usuario.setIdUsuario(resultado.getInt("idusuario"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setAtivo(resultado.getBoolean("ativo"));
                usuario.setIdArea(resultado.getInt("idarea"));
                usuario.setPermissao(resultado.getString("permissao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuário: " + e);
        }
        return usuario.getNome();
    }

    public void atualizar(Usuario user) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario SET "
                    + "login = '" + user.getLogin() + "', "
                    + "senha = '" + user.getSenha() + "', "
                    + "nome = '" + user.getNome() + "', "
                    + "email = '" + user.getEmail() + "', "
                    + "ativo = " + user.isAtivo() + ", "
                    + "idarea = " + user.getIdArea() + ", "
                    + "permissao = '" + user.getPermissao() + "' "
                    + "WHERE idusuario = " + user.getIdUsuario() + "";

            st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Usuario consultarId(int id) {
        ResultSet resultado;
        Usuario usuario = new Usuario(0, "", "", "", "", true, 0, "");
        String sql = "SELECT * FROM usuario WHERE idUsuario = '" + id + "'";
        try {
            resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
            if (resultado.next()) {
                usuario.setIdUsuario(resultado.getInt("idusuario"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setAtivo(resultado.getBoolean("ativo"));
                usuario.setIdArea(resultado.getInt("idarea"));
                usuario.setPermissao(resultado.getString("permissao"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuário: " + e);
        }
        return usuario;
    }
}
