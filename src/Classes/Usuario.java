/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Emanoel
 */
public class Usuario {
    protected String login;
    protected String nome;
    protected String email;
    protected String senha;
    
        public Usuario(String login, String nome, String email, String senha) 
    {
        if(login.equals("")) {
             throw new IllegalArgumentException("Login não pode ser vazio.");
             }
                else if (nome.equals("")){
                throw new IllegalArgumentException("Nome não pode ser vazio.");
                }
                    else if (email.equals("")){
                    throw new IllegalArgumentException("E-mail não pode ser vazio.");
                    }
                       else if (senha.equals("")){
                       throw new IllegalArgumentException("Senha não pode ser vazio.");
                       }
        else {        
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        }
    }
            
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
