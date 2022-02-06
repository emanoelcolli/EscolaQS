/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Emanoel
 */
public class Aluno {
    protected int numMatricula;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String cep;
    protected String cidade;
    protected String uf;
    
        public Aluno(int numMatricula, String nome, String cpf, String email, String cep, String cidade, String uf) 
    {
             if(nome.equals("")) {
             throw new IllegalArgumentException("Nome não pode ser vazio.");
             }   
                else if (cpf.equals("")){
                throw new IllegalArgumentException("CPF não pode ser vazio.");
                }
                    else if (email.equals("")){
                    throw new IllegalArgumentException("E-mail não pode ser vazio.");
                    }
                        else if (cep.equals("")){
                        throw new IllegalArgumentException("CEP não pode ser vazio.");
                        }
                            else if (cidade.equals("")){
                            throw new IllegalArgumentException("Cidade não pode ser vazio.");
                            }
                                else if (uf.equals("")){
                                throw new IllegalArgumentException("UF não pode ser vazio.");
                                }   
        else {                           
        this.numMatricula = numMatricula;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }
    
    }
    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }    
    
    public String getUF() {
        return uf;
    }

    public void setUF(String uf) {
        this.uf = uf;
    }
    
    
}
