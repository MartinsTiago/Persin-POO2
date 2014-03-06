/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.rmi.server.ObjID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ExemploObject;

/**
 * Classe responsável por controlar as operações básicas na base de dados
 * 
 * @author Nielsen
 */
public class GenericDAO {
    
    ConnectionSQLiteDAO conn;
    
    /**
     * Construtor da classe
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws FileNotFoundException 
     */
    
    
    /**
     * Insere valores na tabela de acordo com os parametros informados
     * 
     * @param tableName nome da tabela a ser inserido
     * @param colNames nome das colunas que serão inseridas
     * @param values valores inseridos nas colunas definidas
     * @param conn conexão
     * @return boolean se a query foi executada com sucesso ou não
     * @throws Exception caso quantidade de colunas informadas foi diferente da quantidade dos valores passados
     */
    public boolean insert(String tableName, ArrayList<String> colNames, ArrayList<String> values, ConnectionSQLiteDAO conn) throws Exception {
        
        if (colNames.size() != values.size()) {
            throw new Exception("Quantidade de valores informados diferentes do número de colunas informados.");
        }
        
        String query = "INSERT INTO " + tableName + " (";
        
        //preenche colunas
        for (int i = 0; i < colNames.size(); i++) {
            if (i == colNames.size() - 1) {
                query += colNames.get(i) + ")";
            } else {
                query += colNames.get(i) + ", ";
            }
        }
        
        query += " VALUES (";
        
        //preenche os valores com ? para ser uma query preparada
        for (int i = 0; i < colNames.size(); i++) {
            if (i == colNames.size() - 1) {
                query += "?" + ")";
            } else {
                query += "?, ";
            }
        }
        
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        for (int i = 1; i <= values.size(); i++) {
            ps.setString(i, values.get(i-1));
        }
        
        System.out.println(query);
        
        return ps.execute();
        
    }
    
    /**
     * Faz uma busca no banco de acordo com o exemplo informado
     * 
     * @param tableName nome da tabela
     * @param cols colunas a serem selecionadas
     * @param example objeto de exemplo
     * @param conn conexão
     * @return resultset com resultado
     * @throws SQLException 
     */
    public ResultSet selectByExample(String tableName, ArrayList<String> cols, ArrayList<ExemploObject> example, ConnectionSQLiteDAO conn) throws SQLException {
    
        String query = "SELECT ";
        
        for (int i = 0; i < cols.size(); i++) {
            if (i == cols.size() - 1) {
                query += cols.get(i);
            } else {
                query += cols.get(i) + ",";
            }
        }
        
        query += " FROM " + tableName + " WHERE 1 = 1";
        
        for (int i = 0; i < example.size(); i++) {
            query += " AND " + example.get(i).getColumnName() + example.get(i).getOperator() + "'" + example.get(i).getColumnValue() + "'";
        }
        
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        System.out.println(query);
        ResultSet rs = ps.executeQuery();
        
        return rs;
    }
    
    /**
     * Faz uma busca no banco de acordo com o exemplo informado
     * 
     * @param tableName nome da tabela
     * @param col coluna selecionada
     * @param example objeto de exemplo
     * @param conn conexão
     * @return resultset com resultado
     * @throws SQLException 
     */
    public ResultSet selectByExample(String tableName, String col, ArrayList<ExemploObject> example, ConnectionSQLiteDAO conn) throws SQLException {
    
        String query = "SELECT " + col;
        
        query += " FROM " + tableName + " WHERE 1 = 1";
        
        for (int i = 0; i < example.size(); i++) {
            query += " AND " + example.get(i).getColumnName() + example.get(i).getOperator() + "'" + example.get(i).getColumnValue() + "'";
        }
        
        
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        System.out.println(query);
        ResultSet rs = ps.executeQuery();
        
        
        return rs;
    }
    
    
    
    
}
