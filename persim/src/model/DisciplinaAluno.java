package model;
import java.util.ArrayList;

public class DisciplinaAluno extends Disciplina {

    public DisciplinaAluno () {
        this.aulas = new ArrayList<>();
        this.bibliografia = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public DisciplinaAluno (String ID, String nome, Professor professor, String sala) {
        this.ID = ID;
        this.nome = nome;
        this.professor = professor;
        this.sala = sala;
        this.aulas = new ArrayList<>();
        this.bibliografia = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

}
