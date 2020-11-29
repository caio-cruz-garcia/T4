package com.company.dao;

import com.company.model.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class PersonagemDAO. Stores all DAO commands related to Personagem
 */
public class PersonagemDAO implements DAO<Personagem>,DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:dados.db";

    /**
     * Constructor for PersonagemDAO. Connects to SQL
     */
    public PersonagemDAO(){
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
        List<Personagem> personagems = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                Personagem personagem = new Personagem(
                        result.getString("nome"),
                        result.getString("raca"),
                        result.getString("profissao"),
                        result.getInt("mana"),
                        result.getInt("ataque"),
                        result.getInt("ataque_magico"),
                        result.getInt("defesa"),
                        result.getInt("defesa_magica"),
                        result.getInt("velocidade"),
                        result.getInt("destreza"),
                        result.getInt("exp"),
                        result.getInt("nivel")
                );
                personagems.add(personagem);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return personagems;
    }

    /**
     * method getALL
     * @return all items from SQL
     */
    @Override
    public List<Personagem> getALL() {
        List<Personagem> personagems = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Personagem personagem = new Personagem(
                        result.getString("nome"),
                        result.getString("raca"),
                        result.getString("profissao"),
                        result.getInt("mana"),
                        result.getInt("ataque"),
                        result.getInt("ataque_magico"),
                        result.getInt("defesa"),
                        result.getInt("defesa_magica"),
                        result.getInt("velocidade"),
                        result.getInt("destreza"),
                        result.getInt("exp"),
                        result.getInt("nivel")
                );
                personagems.add(personagem);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return personagems;
    }

    /**
     * method update
     * @param personagem Takes a personagem to update in the table
     */
    @Override
    public void update(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, personagem.getRaca());
            preparedStatement.setString(3, personagem.getProfissao());
            preparedStatement.setInt(4, personagem.getMana());
            preparedStatement.setInt(5, personagem.getAtaque());
            preparedStatement.setInt(6, personagem.getAtaque_magico());
            preparedStatement.setInt(7, personagem.getDefesa());
            preparedStatement.setInt(8, personagem.getDefesa_magica());
            preparedStatement.setInt(9, personagem.getVelocidade());
            preparedStatement.setInt(10, personagem.getDestreza());
            preparedStatement.setInt(11, personagem.getExp());
            preparedStatement.setInt(12, personagem.getNivel());
            preparedStatement.setString(13, personagem.getNome());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * method delete
     * @param personagem Deletes a personagem
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
     * @param personagem creates a new personagem entry at the sql database
     */
    @Override
    public void create(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, personagem.getRaca());
            preparedStatement.setString(3, personagem.getProfissao());
            preparedStatement.setInt(4, personagem.getMana());
            preparedStatement.setInt(5, personagem.getAtaque());
            preparedStatement.setInt(6, personagem.getAtaque_magico());
            preparedStatement.setInt(7, personagem.getDefesa());
            preparedStatement.setInt(8, personagem.getDefesa_magica());
            preparedStatement.setInt(9, personagem.getVelocidade());
            preparedStatement.setInt(10, personagem.getDestreza());
            preparedStatement.setInt(11, personagem.getExp());
            preparedStatement.setInt(12, personagem.getNivel());
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
        return "Personagem";
    }

    /**
     * method getDeleteString
     * @param table name of table
     * @return Delete query
     */
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE nome = ?";
    }

    /**
     * method getUpdateString
     * @param table name of table
     * @return Update query
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET nome = ?, raca = ?, profissao = ?, mana = ?, ataque = ?, ataque_magico = ?, defesa = ?, defesa_magica = ?, velocidade = ?, destreza = ?, exp = ?, nivel = ? WHERE nome = ?;";
    }

    /**
     * method getInsertString
     * @param table name of table
     * @return Create query
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (nome, raca, profissao, mana, ataque, ataque_magico, defesa, defesa_magica, velocidade, destreza, exp, nivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
