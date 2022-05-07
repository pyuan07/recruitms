package com.recruit.recruitms.service;

import java.util.List;
import java.util.UUID;

public interface IService<T,K> {
    T create(T t);
    List<T> getAll();
    List<T> getActive();
    T getById(K key);
    T update(T t);
    boolean delete(K key);
}
