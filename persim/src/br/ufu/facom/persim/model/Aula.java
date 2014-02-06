/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufu.facom.persim.model;

import java.util.List;


public class Aula {
    private String horario;
    private String diaSemana;
   
    public Aula(){}
    
    public Aula(String horario, String diaSemana)
    {
        this.horario = horario;
        this.diaSemana = diaSemana;
    }
    
    public String getHorario() {
        return horario;
    }
    
     public void setHorario(String horario) {
        this.horario = horario;
    }
    
      public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
}