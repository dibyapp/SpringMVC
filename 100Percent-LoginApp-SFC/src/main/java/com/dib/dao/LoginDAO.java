package com.dib.dao;

import com.dib.bo.UserBO;

public interface LoginDAO {
    public  int  validate(UserBO bo);
}