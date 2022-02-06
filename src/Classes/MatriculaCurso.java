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
public class MatriculaCurso {
    private int cod;
    private int numMatriculaAluno;
    private int codigoCurso;
    private String dataMatricula;

    public MatriculaCurso(int cod, int numMatriculaAluno, int codigoCurso, String dataMatricula) {
        this.cod = cod;
        this.numMatriculaAluno = numMatriculaAluno;
        this.codigoCurso = codigoCurso;
        this.dataMatricula = dataMatricula;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getNumMatriculaAluno() {
        return numMatriculaAluno;
    }

    public void setNumMatriculaAluno(int numMatriculaAluno) {
        this.numMatriculaAluno = numMatriculaAluno;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
     
}
