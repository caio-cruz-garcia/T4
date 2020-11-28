package com.company.dao;

import com.company.model.Personagem;

import java.util.List;

public class PersonagemDAO implements DAO<Personagem>,DAOFields{
    @Override
    public List<Personagem> get(String condition) {
        return null;
    }

    @Override
    public List<Personagem> getALL() {
        return null;
    }

    @Override
    public void update(Personagem personagem) {

    }

    @Override
    public void delete(Personagem personagem) {

    }

    @Override
    public void create(Personagem personagem) {

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
