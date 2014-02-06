package br.ufu.facom.persim.control;

import br.ufu.facom.persim.dao.ConnectionSQLiteDAO;
import br.ufu.facom.persim.dao.DisciplinaDAO;
import br.ufu.facom.persim.model.Disciplina;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Singleton
public class DisciplinaControl {
    
    public static DisciplinaControl instance;
    private List<Disciplina> disciplinas;
    
    private DisciplinaControl (List<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }
    
    public static DisciplinaControl getInstance() {
        if (instance == null){
            instance = new DisciplinaControl(load());
        }
        return instance;
    }
    
    public static List<Disciplina> getDisciplinas() {
        return getInstance().disciplinas;
    }
    
    public static void save (Disciplina disc){
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
    
    public static List<Disciplina> load (){
        try {
            DisciplinaDAO dao = new DisciplinaDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            List<Disciplina> disciplina = dao.load(conn);
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
