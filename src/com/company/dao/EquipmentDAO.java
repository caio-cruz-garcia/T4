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
 * @version 0.1
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

    @Override
    public List<Equipment> get(String condition) {
        return null;
    }

    @Override
    public List<Equipment> getALL() {
        return null;
    }

    @Override
    public void update(Equipment equipment) {

    }

    @Override
    public void delete(Equipment equipment) {

    }

    @Override
    public void create(Equipment equipment) {

    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getDeleteString(String table) {
        return null;
    }

    @Override
    public String getUpdateString(String table) {
        return null;
    }

    @Override
    public String getInsertString(String table) {
        return null;
    }

    @Override
    public String getSelectAllString(String table) {
        return null;
    }

    @Override
    public String getSelectConditionalString(String table) {
        return null;
    }
}
