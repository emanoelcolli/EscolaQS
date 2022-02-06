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
public class MatriculaCursoDAOTest {
    
    public MatriculaCursoDAOTest() {
    }

    @Test
    public void testCadastra() {
        MatriculaCurso matricula = new MatriculaCurso(2, 1, 1, "01/01/2022");
        MatriculaCursoDAO matriculaDao = new MatriculaCursoDAO();
        
        if (matriculaDao.cadastra(matricula)){
             System.out.println("Cadastrado com sucesso.");
        } else{
            fail("Erro ao cadastrar.");
        }
    }

    @Test
    public void testListarDados() {
        MatriculaCursoDAO matriculaDao = new MatriculaCursoDAO();
        
        for (MatriculaCurso m: matriculaDao.listarDados()){
            System.out.println("Matricula: "+m.getCod());
        }
    }

    @Test
    public void testPesquisarMatriculaCurso() {
        MatriculaCursoDAO matriculaDao = new MatriculaCursoDAO();
        int cod = 1;
        
        for (MatriculaCurso m: matriculaDao.pesquisarMatriculaCurso(cod)){
            System.out.println("Matricula: "+m.getCod());
        }
    }

    @Test
    public void testAtualizarMatriculaCurso() {
        MatriculaCursoDAO matriculaDao = new MatriculaCursoDAO();
        
        try{
            matriculaDao.AtualizarMatriculaCurso(6, 1, 1, "04/02/2022");
            System.out.println("Atualizado com sucesso.");
        } catch (Exception e){
            fail("Erro ao atualizar.");
        }
    }

    @Test
    public void testExcluirMatriculaCurso() {
        MatriculaCursoDAO matriculaDao = new MatriculaCursoDAO();
        int cod = 1;
        
        if (matriculaDao.excluirMatriculaCurso(cod)){
            System.out.println("Excluido com sucesso.");
        } else {
            fail("Erro ao excluir.");
        }
    }
    
}
