package com.recruit.recruitms.service;

import com.recruit.recruitms.entity.User;

public interface IUserService{
    User getByUsername(String username);
}
