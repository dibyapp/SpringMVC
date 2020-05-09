package com.dib.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("downloadService")
public class DownloadServiceImpl implements DownloadService {

	@Override
	public List<String> fetchFiles(String uploadDir) {
		File upDir=null;
		File files[]=null;
		List<String> listFiles=null;
		
		upDir=new File(uploadDir);
		files=upDir.listFiles();
		listFiles=new ArrayList<String>();
		
		for(File file:files)
		{
			if(!file.isDirectory())
				listFiles.add(file.getName());
		}
		
		return listFiles;
	}

}
