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
public class MatriculaCursoDAO {

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

    public boolean cadastra(MatriculaCurso novoMatricula) {
        if (this.conecta() == true)//se o método conecta retornar true
        {
            String sql = "select * from matriculacurso where codigo = " + novoMatricula.getCod();
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
            //monta o sql para inserção usando isntruções preparadas, onde cada ? significa um campo da tabela
            sql = "insert into matriculacurso values (?,?,?,?)";
            try {
                //prepara para executar a instrução no banco de dados (bd)
                PreparedStatement bd = conexao.prepareStatement(sql);
                //passa os valores dos campos - o índice começa em 1
                bd.setInt(1, novoMatricula.getCod());
                bd.setInt(2, novoMatricula.getNumMatriculaAluno());
                bd.setInt(3, novoMatricula.getCodigoCurso());
                bd.setString(4, novoMatricula.getDataMatricula());
                //executa a inserção
                bd.execute();
                //fechar a conexao
                bd.close();
                JOptionPane.showMessageDialog(null, "Matricula realizada com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
            return true;
        }
        return false;
    }

    public ArrayList<MatriculaCurso> listarDados() {
        ArrayList<MatriculaCurso> lista = new ArrayList();
        if (this.conecta()) {
            String sql = "select * from matriculacurso";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    MatriculaCurso matriculaCurso = new MatriculaCurso(resultado.getInt("codigo"), resultado.getInt("matriculaAluno"), resultado.getInt("codigoCurso"), resultado.getString("dataMatricula"));
                    lista.add(matriculaCurso);
                }
                return lista;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return null;
    }

    public ArrayList<MatriculaCurso> pesquisarMatriculaCurso(int codigo) {
        ArrayList<MatriculaCurso> lista = new ArrayList();
        if (this.conecta()) {
            String sql = "select * from matriculacurso where codigo like \"" + codigo + "%\"";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    MatriculaCurso matriculaCurso = new MatriculaCurso(resultado.getInt("codigo"), resultado.getInt("matriculaAluno"), resultado.getInt("codigoCurso"), resultado.getString("dataMatricula"));
                    lista.add(matriculaCurso);
                }
                return lista;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Curso não encontrado!");
        } else {
            JOptionPane.showMessageDialog(null, "Conexão com o banco falhou!");
        }
        return null;
    }

    public String AtualizarMatriculaCurso(int codigo, int matriculaAluno, int codCurso, String dataMatricula) {
        if (this.conecta()) {
            String sql = "update matriculacurso set matriculaAluno = '" + matriculaAluno + "', codigoCurso = '" + codCurso + "', dataMatricula = '" + dataMatricula + "' where codigo = " + codigo;
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                int i = banco.executeUpdate(sql);
                if (i >= 1) {
                    return ("Matricula atualizada com sucesso!");
                } else {
                    return ("Matricula não encontrada!");
                }
            } catch (SQLException ex) {
                return (ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conexão com o banco falhou!");
        }
        return "Conexão com o banco falhou!";
    }

    public boolean excluirMatriculaCurso(int codigo) {
        if (this.conecta()) {
            String sql = "delete from matriculacurso where codigo = ?";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                banco.setInt(1, codigo);
                banco.executeUpdate();
                JOptionPane.showMessageDialog(null, "Matricula excluida!");
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
