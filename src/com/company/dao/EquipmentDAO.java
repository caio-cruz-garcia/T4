package com.company.dao;

import com.company.model.Equipment;
import com.company.model.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * class EquipmentDAO. Stores all DAO commands related to Equipment
 *
 * @version 0.11
 * @since 2020-11-30
 */

/*
Update 0.:
- Class created
- Javadoc comment added
- Log created

Update 0.1.:
- Added vars
- Added constructor
- Implemented methods

Update 0.11.:
- Added javadoc comments
- Updated methods getTableName
- Updated methods getDeleteString
- Updated methods getUpdateString
- Updated methods getInsertString
- Updated methods getSelectAllString
- Updated methods getSelectConditionalString
 */
public class EquipmentDAO implements DAO<Equipment>,DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:dados-Items-Test.db";

    /**
     * Constructor for ItemsDAO. Connects to SQL
     */
    public EquipmentDAO(){
        try{
            connection = DriverManager.getConnection(myDBConnectionString);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    /**
     * method get
     * @param condition Special condition for specific queries
     * @return result
     */
    @Override
    public List<Equipment> get(String condition) {
        return null;
    }

    /**
     * method getALL
     * @return all items from SQL
     */
    @Override
    public List<Equipment> getALL() {
        return null;
    }

    /**
     * method update
     * @param equipment Takes a equipment to update in the table
     */
    @Override
    public void update(Equipment equipment) {

    }

    /**
     * method delete
     * @param equipment Deletes an equipment
     */
    @Override
    public void delete(Equipment equipment) {

    }

    /**
     * method create
     * @param equipment creates a new equipment entry at the sql database
     */
    @Override
    public void create(Equipment equipment) {

    }

    /**
     * method getTableName
     * @return The name of the table
     */
    @Override
    public String getTableName() {
        return "equipment";
    }

    /**
     * method getDeleteString
     * @param table name of table
     * @return Delete query
     */
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE id = ?";
    }

    /**
     * method getUpdateString
     * @param table name of table
     * @return Update query
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE " + table + " SET id = ?, array = ? WHERE id = ?;";
    }

    /**
     * method getInsertString
     * @param table name of table
     * @return Create query
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (id, array) VALUES (?, ?);";
    }

    /**
     * method getSelectAllString
     * @param table name of table
     * @return Return all data query
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    /**
     * method getSelectedConditionalString
     * @param table name of table
     * @return return specific search query
     */
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
