package br.ufu.facom.persim.dao;
import br.ufu.facom.persim.model.Disciplina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisciplinaDAO {
    
    public void save (Disciplina disc, ConnectionSQLiteDAO conn) throws SQLException{
        String query = "INSERT INTO disciplina VALUES (?, ?, ?, ?);";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, disc.getID());
        ps.setString(2, disc.getNome());
        try{
            ProfessorDAO dao = new ProfessorDAO();
            dao.save(disc.getProfessor(), conn);
            ps.setString(3, disc.getProfessor().getNome());
        } catch (SQLException e) {
            ps.setString(3, disc.getProfessor().getNome());
        } catch (NullPointerException e) {
            ps.setNull(3, java.sql.Types.NULL);
        }
        if (disc.getBibliografia() != null && !disc.getBibliografia().isEmpty()){
            BibliografiaDAO bibdao = new BibliografiaDAO();
            bibdao.save(disc, conn);
        }
        if(disc.getAulas() != null && !disc.getAulas().isEmpty())
        {
            AulaDAO aulaDao = new AulaDAO();
            aulaDao.save(disc,conn);
        }

        ps.setString (4,disc.getSala());
        ps.execute();
    }
    
    public List<Disciplina> load (ConnectionSQLiteDAO conn) throws SQLException{
        String query = "SELECT * FROM disciplina LEFT OUTER JOIN professor "
                            + "ON disciplina.fk_prof_nome LIKE professor.prof_nome;";
        
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        return build(rs, conn);
    }
    
    private List<Disciplina> build (ResultSet rs, ConnectionSQLiteDAO conn) throws SQLException{
        BibliografiaDAO bibdao = new BibliografiaDAO();
        AulaDAO auladao = new AulaDAO();
        EventoAvaliativoDAO evtdao = new EventoAvaliativoDAO();
        List<Disciplina> ds = new ArrayList<>();
        ProfessorDAO profdao = new ProfessorDAO();
        while(rs.next()){
            Disciplina disciplina = new Disciplina();
            disciplina.setID(rs.getString("disc_id"));
            disciplina.setNome(rs.getString("disc_nome"));
            disciplina.setProfessor(profdao.build(rs));
            disciplina.setSala(rs.getString("disc_sala"));            
            disciplina.setBibliografia(bibdao.load(disciplina.getID(), conn));
            disciplina.setAulas(auladao.load(disciplina.getID(), conn));
            disciplina.setEventos(evtdao.load(disciplina, conn));
            ds.add(disciplina);
        }
        
        return ds;
    }
}
