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
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    } 

    @Test
    public void testCadastra() {
        Usuario usuario = new Usuario("2", "Emanoel", "emanuelcolli9@gmail.com ", "123");
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        if (usuarioDao.cadastra(usuario)){
             System.out.println("Cadastrado com sucesso.");
        } else{
            fail("Erro ao cadastrar.");
        }
    }

    @Test
    public void testListarDados() {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        for (Usuario u: usuarioDao.listarDados()){
            System.out.println("Login: "+u.getLogin()+ "  Nome: "+u.getNome());
        }
    }

    @Test
    public void testPesquisarUsuario() {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        String login = "1";
        
        for (Usuario u: usuarioDao.pesquisarUsuario(login)){
            System.out.println("Login: "+u.getLogin()+ "  Nome: "+u.getNome());
        }
    }

    @Test
    public void testExcluirUsuario() {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        String login = "12";
        
        if (usuarioDao.excluirUsuario(login)){
            System.out.println("Excluido com sucesso.");
        } else {
            fail("Erro ao excluir.");
        }
    }
    
}
