package model;

import java.sql.Timestamp;

public class EventoAluno extends Evento {

    public EventoAluno () {
        super();
    }

    public EventoAluno (Timestamp dataHora, Timestamp duracao, String descricao) {
        super(dataHora, duracao, descricao);
    }

}
