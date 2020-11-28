package com.company.dao;

import com.company.model.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO implements DAO<Personagem>,DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:dados_tuned.db";

    public PersonagemDAO(){
        try{
            connection = DriverManager.getConnection(myDBConnectionString);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }


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
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

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

    @Override
    public String getTableName() {
        return "Personagem";
    }

    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE name = ?";
    }

    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET nome = ?, raca = ?, profissao = ?, mana = ?, ataque = ?, ataque_magico = ?, defesa = ?, defesa_magica = ?, velocidade = ?, destreza = ?, exp = ?, nivel = ? WHERE nome = ?;";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (nome, raca, profissao, mana, ataque, ataque_magico, defesa, defesa_magica, velocidade, destreza, exp, nivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
