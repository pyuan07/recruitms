package com.recruit.recruitms.service;

import com.recruit.recruitms.entity.Tag;
import com.recruit.recruitms.enumeration.Enum;

import java.util.List;

//CRUD
public interface ICrudService<T,K> {
    T create(T t);
    List<T> createInBulk(List<T> ts);
    List<T> getAll();
    List<T> getByObjectState(Enum.ObjectState objectState);
    T getById(K key);
    T update(T t);
    boolean delete(K key);
    boolean terminate(K Key);
    boolean activate(K Key);
}
