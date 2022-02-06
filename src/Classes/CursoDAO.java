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
public class CursoDAO {
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

    public boolean cadastra(Curso novoCurso) {
        if (this.conecta() == true)//se o método conecta retornar true
        {
            String sql = "select * from curso where codigo = " + novoCurso.getCod();
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
            sql = "insert into curso values (?,?,?,?)";
            try {
                //prepara para executar a instrução no banco de dados (bd)
                PreparedStatement bd = conexao.prepareStatement(sql);
                //passa os valores dos campos - o índice começa em 1
                bd.setInt(1, novoCurso.getCod());
                bd.setString(2, novoCurso.getNome());
                bd.setInt(3, novoCurso.getCargaHoraria());
                bd.setString(4, novoCurso.getNomeProf());
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

    public ArrayList<Curso> listarDados() {
        ArrayList<Curso> lista = new ArrayList();
        if (this.conecta()) {
            String sql = "select * from curso";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    Curso curso = new Curso(resultado.getInt("codigo"), resultado.getString("nome"), resultado.getInt("cargaHoraria"), resultado.getString("nomeProf"));
                    lista.add(curso);
                }
                return lista;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return null;
    }
    
    public ArrayList<Curso> pesquisarCurso(int codigo){
        ArrayList<Curso> lista = new ArrayList();
        if (this.conecta()) {
            String sql = "select * from curso where codigo like \""+codigo+"%\"";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                ResultSet resultado = banco.executeQuery(sql);
                while (resultado.next()) {
                    Curso curso = new Curso(resultado.getInt("codigo"), resultado.getString("nome"), resultado.getInt("cargaHoraria"), resultado.getString("nomeProf"));
                    lista.add(curso);
                }
                return lista;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Curso não encontrado!");
        }
        else
            JOptionPane.showMessageDialog(null, "Conexão com o banco falhou!");
        return null;
    }
    
    public boolean AtualizarCurso(int codigo, String nome, int cargaHoraria, String nomeProf){
        if (this.conecta()) {
            String sql = "update curso set nome = '"+nome+"', cargaHoraria = '"+cargaHoraria+"', nomeProf = '"+nomeProf+"' where codigo = "+codigo;
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                int i = banco.executeUpdate(sql);
                if (i>=1){
                    JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Curso não encontrado!");
                }
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Conexão com o banco falhou!");
            return false;
    }
    
    public boolean excluirCurso(int codigo) {
        if (this.conecta()) {
            String sql = "delete from curso where codigo = ?";
            try {
                PreparedStatement banco = conexao.prepareStatement(sql);
                banco.setInt(1, codigo);
                banco.executeUpdate();
                JOptionPane.showMessageDialog(null, "Curso excluido!");
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
