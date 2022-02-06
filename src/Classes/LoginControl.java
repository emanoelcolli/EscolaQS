/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Interfaces.Login;
import Interfaces.InterfacePrincipal;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanoel
 */
public class LoginControl {    
    protected String login;
    protected String senha;
    
    Connection conexao;
    
    
    public boolean conecta(){
        
        String url = "jdbc:mysql://localhost/escolaqs?useTimezone=true&serverTimezone=UTC";
        try {
            conexao = DriverManager.getConnection(url, "root", "");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        return false;
    }
    }

    public LoginControl(String login, String senha) {
        this.login = login;
        this.senha = senha;
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
    
    private Login view;

    public LoginControl(Login view) {
        this.view = view;
    }

    public void autenticar() throws SQLException, Exception {
      String login = view.getjTFLogin().getText(); 
      String senha = view.getjPSenha().getText();
      
      LoginControl autenticar = new LoginControl (login, senha);
      
      if(this.conecta()==true){
      
          boolean existe = existe (autenticar);
      
      if (existe){
        InterfacePrincipal interfacePrincipal = new InterfacePrincipal();
        interfacePrincipal.setVisible(true); 
        
      } else {
          JOptionPane.showMessageDialog(view, "Login ou senha invalidos.");
          Login interfaceP = new Login();
          interfaceP.setVisible(true);
      }
      
    }
    }
    
    public boolean existe (LoginControl autenticar) throws SQLException {
            String sql = "select * from usuario where login = '"+autenticar.getLogin()+"' and senha = '"+autenticar.getSenha()+"'";
            PreparedStatement bd = conexao.prepareStatement(sql);
            bd.execute();
            ResultSet resultSet = bd.getResultSet();
            return resultSet.next();         
        }
    }
