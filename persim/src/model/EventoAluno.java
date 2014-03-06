package model;

import java.sql.Timestamp;

public class EventoAluno extends Evento {

    private Timestamp dataHora;
    private Timestamp duracao;
    private String descricao;

    public EventoAluno () {}

    public EventoAluno (Timestamp dataHora, Timestamp duracao, String descricao) {
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.descricao = descricao;
    }
}
