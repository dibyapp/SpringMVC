package com.dib.service;

import com.dib.dto.UserDTO;

public interface LoginService {
	public  String   authenticate(UserDTO dto);
}
