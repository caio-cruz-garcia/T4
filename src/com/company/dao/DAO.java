package com.company.dao;

import java.util.List;

public interface DAO <T>{
    List<T> get(String condition);
    List<T> getALL();
    void update(T t);
    void delete(T t);
    void create(T t);
}
