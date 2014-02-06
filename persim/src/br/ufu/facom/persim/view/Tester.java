package br.ufu.facom.persim.view;

import br.ufu.facom.persim.control.DisciplinaControl;
import br.ufu.facom.persim.control.EventoControl;
import br.ufu.facom.persim.dao.ConnectionSQLiteDAO;
import br.ufu.facom.persim.model.Disciplina;
import br.ufu.facom.persim.model.Evento;
import br.ufu.facom.persim.model.Professor;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Classe temporaria para testes e simulacoes
 */
public class Tester {
    
    public static void main (String[] args) throws FileNotFoundException{
        testeGravaEvento();
        //testeBancoFuncionando();
       // testeGravaDisciplina();
       // testeLoadDisciplina();
        //testeControleNotasFaltas();
    }
    
    public static void testeGravaEvento(){
        String data = "19:20:00";
        String data2 = "13:20:00";
        
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
            Date d = sdf.parse(data);
            Date d2 = sdf.parse(data2);
            Evento evt = new Evento(new Timestamp(d.getTime()), new Timestamp(d2.getTime()), "lsls");
            EventoControl.save(evt);
            String[] g = evt.getDataHora().toString().split("[^0-9]");
            System.out.println(g[0]+" "+g[1]+" "+g[2]+" "+g[3]+" "+g[4]+" "+g[5]);
            System.out.println(evt);
        } catch (ParseException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void testeBancoFuncionando(){
        ConnectionSQLiteDAO conn;
        try {
            conn = new ConnectionSQLiteDAO();
            conn.closeDB();
            System.out.println("Funcionando!!");
        } catch (ClassNotFoundException | SQLException | FileNotFoundException ex) {
            System.out.println("Pobrema: "+ex.getMessage());
        }
    }
    public static void testeGravaDisciplina(){
        System.out.println("------------GRAVANDO---------------");
        Professor pf = new Professor("Maia", "lala@lala", "1b90");
        Disciplina ds = new Disciplina("ESOF", "Eng.Soft", pf , "bazingations");
        List<String> ls = new ArrayList<>();
        ls.add("bib1");
        ls.add("bib2");
        ds.setBibliografia(ls);
        
        DisciplinaControl.save(ds);
        
        
        System.out.println("prof: "+ds.getProfessor().getNome()+" <- "+
                ds.getProfessor().getEmail()+" <- "+ds.getProfessor().getSala());
        System.out.println("ds: "+ds.getID()+" <- "+ds.getNome()+" <- "/*+ds.getAdicionais()*/);

        for (Iterator<String> it = ds.getBibliografia().iterator(); it.hasNext();) {
            String string = it.next();
            System.out.println("Bibliografia -> "+string);
        }
    }
    
    /*public static void testeLoadDisciplina() {
        System.out.println("------------RECUPERANDO------------");
        Disciplina ds = DisciplinaControl.load("ESOF");
        
        System.out.println("prof: "+ds.getProfessor().getNome()+" <- "+
                ds.getProfessor().getEmail()+" <- "+ds.getProfessor().getSala());
        System.out.println("ds: "+ds.getID()+" <- "+ds.getNome()+");

        for (Iterator<String> it = ds.getBibliografia().iterator(); it.hasNext();) {
            String string = it.next();
            System.out.println("Bibliografia -> "+string);
        }
    }*/
}
