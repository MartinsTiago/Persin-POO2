/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;

/**
 *
 * @author araujot
 */
public abstract class Disciplina {
    public String ID;
    public String nome;
    public Professor professor;
    public List<String> bibliografia;
    public List<EventoAvaliativoAluno> eventos;
    public List<Aula> aulas;
    public String sala;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(List<String> bibliografias) {
        this.bibliografia = bibliografias;
    }

    public List<Aula> getAulas()
    {
        return aulas;
    }

    public void setAulas(List<Aula> aulas)
    {
        this.aulas = aulas;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setEventos(List<EventoAvaliativoAluno> eventos) {
        this.eventos = eventos;
    }

    public List<EventoAvaliativoAluno> getEventos() {
        return eventos;
    }

     public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString(){
        return this.getNome();
    }


}
