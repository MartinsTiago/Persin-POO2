package br.ufu.facom.persim.control;

import br.ufu.facom.persim.dao.ConnectionSQLiteDAO;
import br.ufu.facom.persim.dao.StickyNotesDAO;
import br.ufu.facom.persim.model.StickyNote;
import br.ufu.facom.persim.view.StickyNotesIFrame;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StickyNotesControl {
    
    public static void save (StickyNote snotes) {
        try {
            StickyNotesDAO dao = new StickyNotesDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.save(snotes, conn);
            conn.closeDB();
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao salvar o sticky: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
    
    public static List<StickyNote> load () {
        try {
            StickyNotesDAO dao = new StickyNotesDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            List<StickyNote> ls = dao.load(conn);
            conn.closeDB();
            return ls;
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao carregar os sticky: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        return null;
    }
    
    public static void delete (StickyNote snote) {
        try {
            StickyNotesDAO dao = new StickyNotesDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.delete(snote, conn);
            conn.closeDB();
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao deletar os sticky: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
    
    public static void updateStickyNotePositionInfo(StickyNote snote){
        try {
            StickyNotesDAO dao = new StickyNotesDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.updatePostion(snote, conn);
            conn.closeDB();
        } catch (ClassNotFoundException ex) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Problema ao atualizar os stickys: " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("Problema ao configurar banco de dados: "+ex.getMessage());
        }
    }
    
    public static List<StickyNotesIFrame> buildStickyNotesIFrames(){
        List<StickyNote> snotes = load();
        List<StickyNotesIFrame> stks = new ArrayList<>();
        
        for (Iterator<StickyNote> it = snotes.iterator(); it.hasNext();) {
            StickyNote snote = it.next();
            stks.add(new StickyNotesIFrame(snote));
        }
        
        return stks;
    }
}
