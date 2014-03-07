/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import view.CadastroEventoIFrameFactory;

/**
 *
 * @author araujot
 */
public class ConcreteCadastroEventoIFrame {
    public static CadastroEventoIFrameFactory factory;
    
    public ConcreteCadastroEventoIFrame(CadastroEventoIFrameFactory factory){
        ConcreteCadastroEventoIFrame.factory = factory;
    }
}
