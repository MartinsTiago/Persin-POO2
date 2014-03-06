package dao;

import model.StickyNote;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ExemploObject;

public class StickyNotesDAO {
    private final GenericDAO dao;
    
    public StickyNotesDAO(){
        dao = new GenericDAO();
    }
    public void save (StickyNote snote, ConnectionSQLiteDAO conn) throws SQLException, Exception{
        
        ArrayList<String> cols = new ArrayList<>();
        cols.add("stk_text");
        cols.add("stk_xpos");
        cols.add("stk_ypos");
        ArrayList<String> values = new ArrayList<>();
        values.add(snote.getText());
        values.add(String.valueOf(snote.getXpos()));
        values.add(String.valueOf(snote.getYpos()));
        
        dao.insert("sticky_notes", cols, values, conn);
    }
    
    public List<StickyNote> load (ConnectionSQLiteDAO conn) throws SQLException {
        
        ResultSet rs = dao.selectAll("sticky_notes", conn);
        return build(rs); 
    }
    
    public void delete (StickyNote snote, ConnectionSQLiteDAO conn) throws SQLException{
        ExemploObject exemplo = new ExemploObject("stk_text", "=", snote.getText());
        ArrayList<ExemploObject> exemplos = new ArrayList<>();
        exemplos.add(exemplo);
        
        dao.deleteByExample("sticky_notes", exemplos, conn);
    }
    
    public void updatePosition (StickyNote snote, ConnectionSQLiteDAO conn) throws SQLException{
        ArrayList<ExemploObject> valores = new ArrayList<>();
        ExemploObject vlr1 = new ExemploObject("stk_xpos", "=", String.valueOf(snote.getXpos()));
        ExemploObject vlr2 = new ExemploObject("stk_ypos", "=", String.valueOf(snote.getYpos()));
        valores.add(vlr1);
        valores.add(vlr2);
        
        ArrayList<ExemploObject> exemplos = new ArrayList<>();
        ExemploObject exemplo = new ExemploObject("stk_text", "=", snote.getText());
        exemplos.add(exemplo);       
        
        dao.updateByExample("sticky_notes", valores, exemplos, conn);
        
    }
    
    private List<StickyNote> build (ResultSet rs) throws SQLException {
        
        List<StickyNote> snotes = new ArrayList<>();
        
        while(rs.next()){
            snotes.add(new StickyNote(rs.getString("stk_text"), 
                    rs.getInt("stk_xpos"), rs.getInt("stk_ypos")));
        }
        
        return snotes;
    }
}
