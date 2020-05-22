package com.dib.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dib.command.PagingCommand;
import com.dib.dto.EmployeeDTO;
import com.dib.service.EmployeeService;

@Controller
public class PagintaionController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/page.htm")
	public String showHome(@ModelAttribute("pageCmd")PagingCommand cmd, HttpServletRequest req) {
		HttpSession ses=null;
		cmd.setPagesize(3);
		ses=req.getSession(true);
		ses.removeAttribute("pagesize");
		
		
		return "page_form";
	}

	@RequestMapping("/report.htm")
	public String showReport(Map<String,Object> map , @ModelAttribute("pageCmd ") PagingCommand cmd, HttpServletRequest req)throws Exception{

		int pagesize=0;
		HttpSession ses=null;
		int pageno=0;
		int pagesCount=0;
		List<EmployeeDTO> listDTO=null;

		ses=req.getSession();
		if(ses.getAttribute("pagesize")!=null)
			pagesize=(int) ses.getAttribute("pagesize");
		else {
			pagesize=cmd.getPagesize();
			ses.setAttribute("pagesize", pagesize);
		}
		pageno=Integer.parseInt(req.getParameter("pageno"))-1;
		
		pagesCount=service.getPagesCount(pagesize);
		listDTO=service.getPageData(pageno, pagesize);
		
		map.put("pagesCount", pagesCount);
		map.put("listDTO", listDTO);
		
		return "show_report";
	}
}
