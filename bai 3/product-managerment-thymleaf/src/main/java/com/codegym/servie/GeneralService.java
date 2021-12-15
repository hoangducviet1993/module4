package com.codegym.servie;

import java.util.List;

public interface GeneralService <T>{
    List<T> findAll();
    int findIndexById(int id);
    void save(T t);
    T findById(int id);
    void update(int id, T t);
    void remove(int id);
}
