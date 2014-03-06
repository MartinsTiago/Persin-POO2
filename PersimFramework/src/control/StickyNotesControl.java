package control;

import dao.ConnectionSQLiteDAO;
import dao.StickyNotesDAO;
import model.StickyNote;
import view.StickyNotesIFrame;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StickyNotesControl {
    
    public static void save (StickyNote snotes) throws Exception {
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
            dao.updatePosition(snote, conn);
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
        for (StickyNote snote : snotes) {
            stks.add(new StickyNotesIFrame(snote));
        }
        
        return stks;
    }
}
