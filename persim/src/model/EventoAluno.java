package model;

import java.sql.Timestamp;

public class EventoAluno extends Evento {

    public EventoAluno () {}

    public EventoAluno (Timestamp dataHora, Timestamp duracao, String descricao) {
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.descricao = descricao;
    }
}
