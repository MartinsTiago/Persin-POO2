/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Nielsen
 */
public final class ExemploObject {
    
    private String columnName;
    private String operator;
    private String columnValue;
    
    public ExemploObject(String columnName, String operator, String columnValue) {
        this.setColumnName(columnName);
        this.setOperator(operator);
        this.setColumnValue(columnValue);        
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }
    
}
