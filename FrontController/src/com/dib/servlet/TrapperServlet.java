package com.dib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dib.handler.CountriesHandler;
import com.dib.handler.Handler;
import com.dib.handler.LanguagesHandler;

public class TrapperServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=null;
		Handler handler=null;
		String lvn=null;
		String target=null;
		RequestDispatcher rd=null;

		try {
			path=req.getServletPath();
			if(path.equalsIgnoreCase("/lang.do")) {
				handler=new LanguagesHandler();
			}else if(path.equalsIgnoreCase("/countries.do")) {
				handler=new CountriesHandler();
			}else {
				throw new IllegalArgumentException("Invalid Request Url");
			}

			lvn=handler.handle(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(lvn.equalsIgnoreCase("disp_lang"))
				target="show_languages.jsp";
			else if(lvn.equalsIgnoreCase("disp_countries"))
				target="show_countries.jsp";
			else
				throw new IllegalArgumentException("Invalid Lvn");
			
			rd=req.getRequestDispatcher(target);
			rd.forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
