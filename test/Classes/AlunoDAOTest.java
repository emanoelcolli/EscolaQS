/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Classes;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emanoel
 */
public class AlunoDAOTest {
    
    public AlunoDAOTest() {
    }

    @Test
    public void testCadastra() {
        Aluno aluno = new Aluno(3, "Nome", "12345678911", "emanuelcolli9@gmail.com", "98400000", "Frederico Westphalen", "RS");
        AlunoDAO alunoDao = new AlunoDAO();
        
        if (alunoDao.cadastra(aluno)){
             System.out.println("Cadastrado com sucesso.");
        } else{
            fail("Erro ao cadastrar.");
        }
    }

    @Test
    public void testListarDados() {
        AlunoDAO alunoDao = new AlunoDAO();
        
        for (Aluno a: alunoDao.listarDados()){
            System.out.println("Matricula: "+a.getNumMatricula()+ "  Nome: "+a.getNome());
        }
        
    }

    @Test
    public void testPesquisarAluno() {
        AlunoDAO alunoDao = new AlunoDAO();
        int cod = 2;
        
        for (Aluno a: alunoDao.pesquisarAluno(cod)){
            System.out.println("Matricula: "+a.getNumMatricula()+ "  Nome: "+a.getNome());
        }
    }

    @Test
    public void testAtualizarAluno() {
        AlunoDAO alunoDao = new AlunoDAO();
        
        if (alunoDao.atualizarAluno(1, "NomeAtualiza", "12345678911", "emanuelcolli9@gmail.com", "98400000", "Frederico Westphalen", "RS")){
             System.out.println("Atualizado com sucesso.");
        } else{
            fail("Erro ao atualizar.");
        }
    }

    @Test
    public void testExcluirAluno() {
        AlunoDAO alunoDao = new AlunoDAO();
        int cod = 2;
        
        if (alunoDao.excluirAluno(cod)){
            System.out.println("Excluido com sucesso.");
        } else {
            fail("Erro ao excluir.");
        }
    }
    
}
