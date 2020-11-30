package com.company.dao;

import com.company.model.Equipment;
import com.company.model.Items;
import com.company.model.Personagem;
import com.company.parsers.EquipmentParser;
import com.company.parsers.EquipmentParserList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class EquipmentDAO. Stores all DAO commands related to Equipment
 *
 * @version 0.12
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

Update 0.12.:
- Changed how the code is implemented.
    |- Considering that the Equipment is an array located inside the personagem class, we can connect both and use the
    personagem name as primary key.

- Updated method create
- Updated method update
- Updated method delete

Update 0.13.:
- Updated method getALL
- Updated method get
 */
public class EquipmentDAO implements DAO<Personagem>,DAOFields{
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
    public List<Personagem> get(String condition) {
        List<Personagem> entries = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                Personagem personagem = new Personagem(
                        result.getString("id")
                );
                JSONArray jsonArray = new JSONArray((result.getString("array")));
                personagem.setEquipmentList(EquipmentParserList.fromJson(jsonArray));
                entries.add(personagem);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return entries;
    }

    /**
     * method getALL
     * @return all items from SQL
     */
    @Override
    public List<Personagem> getALL() {
        List<Personagem> entries = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Personagem personagem = new Personagem(
                        result.getString("id")
                );
                JSONArray jsonArray = new JSONArray((result.getString("array")));
                personagem.setEquipmentList(EquipmentParserList.fromJson(jsonArray));
                entries.add(personagem);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return entries;
    }

    /**
     * method update
     * @param personagem Takes a equipment to update in the table
     */
    @Override
    public void update(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, String.valueOf(EquipmentParserList.toJson(personagem.getEquipmentList())));
            preparedStatement.setString(3, personagem.getNome());

            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * method delete
     * @param personagem Deletes an equipment list
     */
    @Override
    public void delete(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * method create
     * @param personagem creates a new equipment entry at the sql database
     */
    @Override
    public void create(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, String.valueOf(EquipmentParserList.toJson(personagem.getEquipmentList())));
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

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
