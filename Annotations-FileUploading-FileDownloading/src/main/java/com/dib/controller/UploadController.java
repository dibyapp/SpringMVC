package com.dib.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dib.command.UploadCommand;
import com.dib.service.DownloadService;

@Controller
public class UploadController 
{
	@Autowired
	private DownloadService service;

	@GetMapping("/upload.htm")
	public String showForm(@ModelAttribute("uplCmd") UploadCommand cmd)
	{
		return "file_upload";
	}
	
	@PostMapping("/upload.htm")
	public String uploadForm(Map<String,Object> map, @ModelAttribute("uplCmd") UploadCommand cmd,HttpServletRequest req, BindingResult errors) throws IOException
	{
		ServletContext sc=null;
		String location=null;
		File file=null;
		String uploadFile=null;
		InputStream is=null;
		OutputStream os=null;
		
		sc=req.getServletContext();
		location=sc.getInitParameter("uploadFolder");
		file=new File(location);
		if(!file.exists())
			file.mkdir();
		
		uploadFile=cmd.getFile().getOriginalFilename();
		is=cmd.getFile().getInputStream();
		os=new FileOutputStream(location+"/"+uploadFile);
		IOUtils.copy(is, os);
		
		map.put("filename", uploadFile);
		
		return "success_upload";
	}
	
	@RequestMapping("/list_files.htm")
	public String listUploadedFiles(Map<String,Object> map, HttpServletRequest req) {
		ServletContext sc=null;
		String uploadDir=null;
		List<String> filesList=null;
		sc=req.getServletContext();
		uploadDir=sc.getInitParameter("uploadFolder");
		filesList=service.fetchFiles(uploadDir);
		map.put("filesList", filesList);
		
		return "show_files";
	}
	
	@RequestMapping("/download.htm")
	public String downloadFile(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String fileName=null;
		ServletContext sc=null;
		File file=null;
		InputStream is=null;
		OutputStream os=null;
		
		sc=req.getServletContext();
		fileName=req.getParameter("fileName");
		file=new File(sc.getInitParameter("uploadFolder")+"/"+fileName);
		
		res.setContentLengthLong(file.length());
		res.setContentType(sc.getMimeType(file.getAbsolutePath())!=null ?sc.getMimeType(file.getAbsolutePath()):"application/octet-stream");
		
		is=new FileInputStream(file);
		os=res.getOutputStream();
		res.setHeader("Content-Disposition", "attachment;fileName="+fileName);
		
		IOUtils.copy(is, os);
		
		is.close();
		os.close();
		
		return null;
	}
	
}
