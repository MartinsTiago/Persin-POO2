package model;

import java.sql.Timestamp;

public class Evento {
    
    private int eventoID;
    private Timestamp data;
    private String descricao;
        
    public Evento () {}
    
    public Evento (Timestamp data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }
    
    
    public int getEventoID() {
        return eventoID;
    }

    public void setEventoID(int eventoID) {
        this.eventoID = eventoID;
    }
    
    
    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
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
        
        if (this.getData() != null){
            String[] d = this.getData().toString().split("[^0-9]");        
        }
        if (this.getDescricao() != null){
            str += "Sobre: "+this.getDescricao();
        }
        
        return str;
    }
}