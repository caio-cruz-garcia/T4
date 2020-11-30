package com.company.dao;

import com.company.model.Items;
import com.company.model.Personagem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * class ItemsDAO. Stores all DAO commands related to items
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
 */
public class ItemsDAO implements DAO<Items>,DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:dados-Items-Test.db";

    /**
     * Constructor for ItemsDAO. Connects to SQL
     */
    public ItemsDAO(){
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
    public List<Items> get(String condition) {
        return null;
    }

    /**
     * method getALL
     * @return all items from SQL
     */
    @Override
    public List<Items> getALL() {
        return null;
    }

    /**
     * method update
     * @param items Takes a items to update in the table
     */
    @Override
    public void update(Items items) {

    }

    /**
     * method delete
     * @param items Deletes an items
     */
    @Override
    public void delete(Items items) {

    }

    /**
     * method create
     * @param items creates a new items entry at the sql database
     */
    @Override
    public void create(Items items) {

    }

    /**
     * method getTableName
     * @return The name of the table
     */
    @Override
    public String getTableName() {
        return null;
    }

    /**
     * method getDeleteString
     * @param table name of table
     * @return Delete query
     */
    @Override
    public String getDeleteString(String table) {
        return null;
    }

    /**
     * method getUpdateString
     * @param table name of table
     * @return Update query
     */
    @Override
    public String getUpdateString(String table) {
        return null;
    }

    /**
     * method getInsertString
     * @param table name of table
     * @return Create query
     */
    @Override
    public String getInsertString(String table) {
        return null;
    }

    /**
     * method getSelectAllString
     * @param table name of table
     * @return Return all data query
     */
    @Override
    public String getSelectAllString(String table) {
        return null;
    }

    /**
     * method getSelectedConditionalString
     * @param table name of table
     * @return return specific search query
     */
    @Override
    public String getSelectConditionalString(String table) {
        return null;
    }
}
