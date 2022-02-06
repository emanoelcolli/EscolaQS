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
public class Curso {
    protected int cod;
    protected String nome;
    protected int cargaHoraria;
    protected String nomeProf;
    
        public Curso(int codigo, String nome, int cargaHoraria, String nomeProf) 
    {
        this.cod = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.nomeProf = nomeProf;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int codigo) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }
    
    
}
