package com.recruit.recruitms.service;

import com.recruit.recruitms.enumeration.Enum;

import java.util.List;
import java.util.UUID;

//CRUD
public interface IService<T,K> {
    T create(T t);
    List<T> getAll();
    List<T> getByObjectState(Enum.ObjectState objectState);
    T getById(K key);
    T update(T t);
    boolean delete(K key);
    boolean terminate(K Key);
    boolean activate(K Key);
}
