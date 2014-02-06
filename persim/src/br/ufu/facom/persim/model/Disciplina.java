package br.ufu.facom.persim.model;
import java.util.ArrayList;
import java.util.List;

public class Disciplina {
        
    private String ID;
    private String nome;
    private Professor professor;
    private List<String> bibliografia;
    private List<EventoAvaliativo> eventos;
    private List<Aula> aulas;
    private String sala; 
    
    public Disciplina () {
        this.aulas = new ArrayList<>();
        this.bibliografia = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }
    
    public Disciplina (String ID, String nome, Professor professor, String sala) {
        this.ID = ID;
        this.nome = nome;
        this.professor = professor;
        this.sala = sala; 
        this.aulas = new ArrayList<>();
        this.bibliografia = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }
    
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
    
    public void setEventos(List<EventoAvaliativo> eventos) {
        this.eventos = eventos;
    }
    
    public List<EventoAvaliativo> getEventos() {
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
