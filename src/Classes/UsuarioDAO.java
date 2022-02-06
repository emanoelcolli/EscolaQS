/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanoel
 */
public class UsuarioDAO {
        Connection conexao;

    public boolean conecta() {
        //define a string de conexão de acordo com o SGBD escolhido
        //nesse caso o mysql e define o endereço do host (localhost - servidor local)
        // e o nome da base de dados (baseaula13)
        String url = "jdbc:mysql://localhost/escolaqs?useTimezone=true&serverTimezone=UTC";
        //define o usuário de acesso a base
        String usuario = "root";
        //define a senha desse usuario, no caso a senha padrão do root é vazia
        String senha = "";
        try {
            //realiza a conexão, se der certo retorna true
            conexao = DriverManager.getConnection(url, usuario, senha);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public boolean cadastra(Usuario novoUsuario) {
        if (this.conecta() == true)//se o método conecta retornar true
        {
            String sql = "select * from usuario where login like \""+novoUsuario.getLogin()+"%\"";
            PreparedStatement banco;
            try {
                banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    JOptionPane.showMessageDialog(null, "Login já cadastrado!\nInforme um novo Login!");
                    return false;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
            sql = "insert into usuario values (?,?,?,?)";
            try {
                //prepara para executar a instrução no banco de dados (bd)
                PreparedStatement bd = conexao.prepareStatement(sql);
                //passa os valores dos campos - o índice começa em 1
                bd.setString(1, novoUsuario.getLogin());
                bd.setString(2, novoUsuario.getNome());
                bd.setString(3, novoUsuario.getEmail());
                bd.setString(4, novoUsuario.getSenha());
                //executa a inserção
                bd.execute();
                //fechar a conexao
                bd.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
            return true;
        }
        return false;
    }

    public ArrayList<Usuario> listarDados() {
        ArrayList<Usuario> lista = new ArrayList();
        if (this.conecta()) {
            String sql = "select * from usuario";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    Usuario usuario = new Usuario(resultado.getString("login"), resultado.getString("nome"), resultado.getString("email"), resultado.getString("senha"));
                    lista.add(usuario);
                }
                return lista;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return null;
    }
    
    public ArrayList<Usuario> pesquisarUsuario(String login){
        ArrayList<Usuario> lista = new ArrayList();
        if (this.conecta()) {
            String sql = "select * from usuario where login like \""+login+"%\"";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    Usuario usuario = new Usuario(resultado.getString("login"), resultado.getString("nome"), resultado.getString("email"), resultado.getString("senha"));
                    lista.add(usuario);
                }
                return lista;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Usuario não encontrado!");
        }
        else
            JOptionPane.showMessageDialog(null, "Conexão com o banco falhou!");
        return null;
    }
    
     
    public boolean excluirUsuario(String login) {
        if (this.conecta()) {
            String sql = "delete from usuario where login = ?";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                banco.setString(1, login);
                banco.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario excluido!");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
        } else {
            System.out.println("Conexão com o banco falhou!");
            return false;
        }
    }
      
}
