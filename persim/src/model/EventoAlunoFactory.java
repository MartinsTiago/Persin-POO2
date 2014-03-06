/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author araujot
 */
public class EventoAlunoFactory implements EventoFactory{
    
    @Override
    public Evento getEvento() {
        return new EventoAluno();
    }
    
}
