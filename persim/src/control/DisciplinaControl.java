package control;

import dao.ConnectionSQLiteDAO;
import dao.DisciplinaDAO;
import model.DisciplinaAluno;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Singleton
public class DisciplinaControl {
    
    public static DisciplinaControl instance;
    private List<DisciplinaAluno> disciplinas;
    
    private DisciplinaControl (List<DisciplinaAluno> disciplinas){
        this.disciplinas = disciplinas;
    }
    
    public static DisciplinaControl getInstance() {
        if (instance == null){
            instance = new DisciplinaControl(load());
        }
        return instance;
    }
    
    public static List<DisciplinaAluno> getDisciplinas() {
        return getInstance().disciplinas;
    }
    
    public static void save (DisciplinaAluno disc){
        try {
            DisciplinaDAO dao = new DisciplinaDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.save(disc, conn);
            conn.closeDB();
        } catch (SQLException e) {
            System.err.println("Problema ao salvar disciplina: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
    
    public static List<DisciplinaAluno> load (){
        try {
            DisciplinaDAO dao = new DisciplinaDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            List<DisciplinaAluno> disciplina = dao.load(conn);
            conn.closeDB();
            return disciplina;
        } catch (SQLException e) {
            System.err.println("Problema ao recuperar info. de disciplina: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        return new ArrayList<>();
    }
    
   
}
