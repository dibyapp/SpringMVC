package com.dib.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadCommand 
{
	private String ename;
	private MultipartFile file;
}
