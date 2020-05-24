package com.dib.dao;

import com.dib.bo.UserBO;

public interface LoginDAO {
    public  long  validate(UserBO bo);
}