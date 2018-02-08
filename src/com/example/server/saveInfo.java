package com.example.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.handleDao;
import com.example.daoImpl.handleDaoImpl;

/**
 * Servlet implementation class saveInfo
 */
public class saveInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("textml;charset=utf-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("textml;charset=utf-8");
        String jsonp=request.getParameter("callback");       
        String recordNo=request.getParameter("recordNo");      
        String alrmInfo=request.getParameter("result");
        //alrmInfo=new String(alrmInfo.getBytes("iso-8859-1"),"UTF-8");        
        handleDao dao=new handleDaoImpl();
        try {        	
			dao.saveAlrmInfo(recordNo, alrmInfo);
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        PrintWriter writer=response.getWriter();
        writer.print(jsonp+"ok");
        writer.flush();
        writer.close();
	}

}
