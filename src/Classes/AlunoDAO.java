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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emanoel
 */
public class AlunoDAO {

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
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean cadastra(Aluno novoAluno) {
        if (this.conecta() == true)//se o método conecta retornar true
        {
            //monta o sql para inserção usando isntruções preparadas, onde cada ? significa um campo da tabela
            String sql = "select * from aluno where matricula = " + novoAluno.getNumMatricula();
            PreparedStatement banco;
            try {
                banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    JOptionPane.showMessageDialog(null, "Código já cadastrado!\nInforme um novo Código!");
                    return false;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
            sql = "insert into aluno values (?,?,?,?,?,?,?)";
            try {
                //prepara para executar a instrução no banco de dados (bd)
                PreparedStatement bd = conexao.prepareStatement(sql);
                //passa os valores dos campos - o índice começa em 1
                bd.setInt(1, novoAluno.getNumMatricula());
                bd.setString(2, novoAluno.getNome());
                bd.setString(3, novoAluno.getCpf());
                bd.setString(4, novoAluno.getEmail());
                bd.setString(5, novoAluno.getCep());
                bd.setString(6, novoAluno.getCidade());
                bd.setString(7, novoAluno.getUF());
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

    public ArrayList<Aluno> listarDados() {
        ArrayList<Aluno> lista = new ArrayList();
        if (this.conecta()) {
            String sql = "select * from aluno";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    Aluno aluno = new Aluno(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("email"), resultado.getString("cep"), resultado.getString("cidade"), resultado.getString("uf"));
                    lista.add(aluno);
                }
                return lista;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return null;
    }

    public ArrayList<Aluno> pesquisarAluno(int codigo) {
        ArrayList<Aluno> lista = new ArrayList();
        if (this.conecta()) {
            String sql = "select * from aluno where matricula like \"" + codigo + "%\"";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    Aluno aluno = new Aluno(resultado.getInt("matricula"), resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("email"), resultado.getString("cep"), resultado.getString("cidade"), resultado.getString("uf"));
                    lista.add(aluno);
                }
                return lista;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            System.out.println("Conexão com o banco falhou!");
        }
        return null;
    }

    public boolean atualizarAluno(int codigo, String nome, String cpf, String email, String cep, String cidade, String uf) {
        if (this.conecta()) {
            String sql = "update aluno set nome = '" + nome + "', cpf = '" + cpf + "', email = '" + email + "', cep = '" + cep + "', cidade = '" + cidade + "', uf = '" + uf + "' where matricula = " + codigo;
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                int i = banco.executeUpdate(sql);
                if (i >= 1) {
                    JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
                }
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conexão com o banco falhou!");
            return false;
        }
    }
    
        public boolean excluirAluno(int codigo) {
        int cod = codigo;
        if (this.conecta()) {
            String sql = "delete from aluno where matricula = ?";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                banco.setInt(1, cod);
                banco.executeUpdate();
                JOptionPane.showMessageDialog(null, "Aluno excluido!");
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
