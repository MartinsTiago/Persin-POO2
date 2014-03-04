package model;

import java.sql.Timestamp;

public abstract class Evento {

    public Timestamp dataHora;
    public Timestamp duracao;
    public String descricao;

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public Timestamp getDuracao() {
        return duracao;
    }

    public void setDuracao(Timestamp duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        String str = "";

        if (this.getDataHora() != null){
            String[] d = this.getDataHora().toString().split("[^0-9]");
            str = "Marcado para as: "+d[3]+" horas e "+d[4]+" minutos.\n";
        }
        if (this.getDuracao() != null){
            String[] e = this.getDuracao().toString().split("[^0-9]");
            str += "Duração: "+e[3]+" horas e "+e[4]+" minutos.\n";
        }
        if (this.getDescricao() != null){
            str += "Sobre: "+this.getDescricao();
        }

        return str;
    }
}
