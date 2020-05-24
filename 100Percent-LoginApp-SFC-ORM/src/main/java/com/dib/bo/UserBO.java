package com.dib.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="USERLIST")
public class UserBO {
	@Id
	@Column(name="UNAME")
	private String username;
	@Column(name="PWD")
	private String password;
}