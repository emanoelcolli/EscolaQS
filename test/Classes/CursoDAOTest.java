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
public class CursoDAOTest {
    
    public CursoDAOTest() {
    } 

    @Test
    public void testCadastra() {
        Curso curso = new Curso(1, "Qualidade de Software", 100, "Joel da Silva");
        CursoDAO cursoDao = new CursoDAO();
        
        if (cursoDao.cadastra(curso)){
             System.out.println("Cadastrado com sucesso.");
        } else{
            fail("Erro ao cadastrar.");
        }
    }

    @Test
    public void testListarDados() {
        CursoDAO cursoDao = new CursoDAO();
        
        for (Curso c: cursoDao.listarDados()){
            System.out.println("Código: "+c.getCod()+ "  Nome: "+c.getNome());
        }
    }

    @Test
    public void testPesquisarCurso() {
        CursoDAO cursoDao = new CursoDAO();
        int cod = 1;
        
        for (Curso c: cursoDao.pesquisarCurso(cod)){
            System.out.println("Matricula: "+c.getCod()+ "  Nome: "+c.getNome());
        }
    }

    @Test
    public void testAtualizarCurso() {
        CursoDAO cursoDao = new CursoDAO();
        
        if (cursoDao.AtualizarCurso(1, "QS", 100, "Carlos Da Silva")){
             System.out.println("Atualizado com sucesso.");
        } else{
            fail("Erro ao atualizar.");
        }
    }

    @Test
    public void testExcluirCurso() {
        CursoDAO cursoDao = new CursoDAO();
        int cod = 1;
        
        if (cursoDao.excluirCurso(cod)){
            System.out.println("Excluido com sucesso.");
        } else {
            fail("Erro ao excluir.");
        }
    }
    
}
