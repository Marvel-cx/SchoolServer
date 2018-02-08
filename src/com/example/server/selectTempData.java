package com.example.server;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.handleDao;
import com.example.daoImpl.handleDaoImpl;
import com.example.vo.AlarmInfo;
import com.example.vo.TempData;

/**
 * Servlet implementation class selectTempData
 */
public class selectTempData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectTempData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        String jsonp=request.getParameter("callback");
        handleDao dao=new handleDaoImpl();
        List<TempData> list;
        StringBuffer json=new StringBuffer();
        json.append("[");
        try {
			list = dao.selectData();
			if(list!=null){	
				for(TempData vo:list){
 					json.append("{");
 					json.append("'temp_id':").append("'").append(vo.getTemp_id()).append("'").append(",");
 					json.append("'device_id':").append("'").append(vo.getDevice_id()).append("'").append(",");
 					json.append("'tl':").append("'").append(vo.getTl()).append("'").append(",");
 					json.append("'th1':").append("'").append(vo.getTh1()).append("'").append(",");
 					json.append("'ver':").append("'").append(vo.getVer()).append("'").append(",");
 					json.append("'tvoc':").append("'").append(vo.getTvoc()).append("'").append(",");
 					json.append("'db':").append("'").append(vo.getDb()).append("'").append(",");
 					json.append("'d1_1':").append("'").append(vo.getD1_1()).append("'").append(",");
 					json.append("'d1_2':").append("'").append(vo.getD1_2()).append("'").append(",");
 					json.append("'d1_3':").append("'").append(vo.getD1_3()).append("'").append(",");
 					json.append("'d1_4':").append("'").append(vo.getD1_4()).append("'").append(",");
 					json.append("'d1_5':").append("'").append(vo.getD1_5()).append("'").append(",");
 					json.append("'d1_6':").append("'").append(vo.getD1_6()).append("'").append(",");
 					json.append("'d1_7':").append("'").append(vo.getD1_7()).append("'").append(",");
 					json.append("'d1_8':").append("'").append(vo.getD1_8()).append("'").append(",");
 					
 					json.append("'d2_1':").append("'").append(vo.getD2_1()).append("'").append(",");
 					json.append("'d2_2':").append("'").append(vo.getD2_2()).append("'").append(",");
 					json.append("'d2_3':").append("'").append(vo.getD2_3()).append("'").append(",");
 					json.append("'d2_4':").append("'").append(vo.getD2_4()).append("'").append(",");
 					json.append("'d2_5':").append("'").append(vo.getD2_5()).append("'").append(",");
 					json.append("'d2_6':").append("'").append(vo.getD2_6()).append("'").append(",");
 					json.append("'d2_7':").append("'").append(vo.getD2_7()).append("'").append(",");
 					json.append("'d2_8':").append("'").append(vo.getD2_8()).append("'").append(",");
 					
 					json.append("'d3_1':").append("'").append(vo.getD3_1()).append("'").append(",");
 					json.append("'d3_2':").append("'").append(vo.getD3_2()).append("'").append(",");
 					json.append("'d3_3':").append("'").append(vo.getD3_3()).append("'").append(",");
 					json.append("'d3_4':").append("'").append(vo.getD3_4()).append("'").append(",");
 					json.append("'d3_5':").append("'").append(vo.getD3_5()).append("'").append(",");
 					json.append("'d3_6':").append("'").append(vo.getD3_6()).append("'").append(",");
 					json.append("'d3_7':").append("'").append(vo.getD3_7()).append("'").append(",");
 					json.append("'d3_8':").append("'").append(vo.getD3_8()).append("'").append(",");
 					
 					json.append("'d4_1':").append("'").append(vo.getD4_1()).append("'").append(",");
 					json.append("'d4_2':").append("'").append(vo.getD4_2()).append("'").append(",");
 					json.append("'d4_3':").append("'").append(vo.getD4_3()).append("'").append(",");
 					json.append("'d4_4':").append("'").append(vo.getD4_4()).append("'").append(",");
 					json.append("'d4_5':").append("'").append(vo.getD4_5()).append("'").append(",");
 					json.append("'d4_6':").append("'").append(vo.getD4_6()).append("'").append(",");
 					json.append("'d4_7':").append("'").append(vo.getD4_7()).append("'").append(",");
 					json.append("'d4_8':").append("'").append(vo.getD4_8()).append("'").append(",");
 					
 					json.append("'d5_1':").append("'").append(vo.getD5_1()).append("'").append(",");
 					json.append("'d5_2':").append("'").append(vo.getD5_2()).append("'").append(",");
 					json.append("'d5_3':").append("'").append(vo.getD5_3()).append("'").append(",");
 					json.append("'d5_4':").append("'").append(vo.getD5_4()).append("'").append(",");
 					json.append("'d5_5':").append("'").append(vo.getD5_5()).append("'").append(",");
 					json.append("'d5_6':").append("'").append(vo.getD5_6()).append("'").append(",");
 					json.append("'d5_7':").append("'").append(vo.getD5_7()).append("'").append(",");
 					json.append("'d5_8':").append("'").append(vo.getD5_8()).append("'").append(",");
 					
 					json.append("'d6_1':").append("'").append(vo.getD6_1()).append("'").append(",");
 					json.append("'d6_2':").append("'").append(vo.getD6_2()).append("'").append(",");
 					json.append("'d6_3':").append("'").append(vo.getD6_3()).append("'").append(",");
 					json.append("'d6_4':").append("'").append(vo.getD6_4()).append("'").append(",");
 					json.append("'d6_5':").append("'").append(vo.getD6_5()).append("'").append(",");
 					json.append("'d6_6':").append("'").append(vo.getD6_6()).append("'").append(",");
 					json.append("'d6_7':").append("'").append(vo.getD6_7()).append("'").append(",");
 					json.append("'d6_8':").append("'").append(vo.getD6_8()).append("'").append(",");
 					
 					json.append("'d7_1':").append("'").append(vo.getD7_1()).append("'").append(",");
 					json.append("'d7_2':").append("'").append(vo.getD7_2()).append("'").append(",");
 					json.append("'d7_3':").append("'").append(vo.getD7_3()).append("'").append(",");
 					json.append("'d7_4':").append("'").append(vo.getD7_4()).append("'").append(",");
 					json.append("'d7_5':").append("'").append(vo.getD7_5()).append("'").append(",");
 					json.append("'d7_6':").append("'").append(vo.getD7_6()).append("'").append(",");
 					json.append("'d7_7':").append("'").append(vo.getD7_7()).append("'").append(",");
 					json.append("'d7_8':").append("'").append(vo.getD7_8()).append("'").append(",");
 					
 					json.append("'d8_1':").append("'").append(vo.getD8_1()).append("'").append(",");
 					json.append("'d8_2':").append("'").append(vo.getD8_2()).append("'").append(",");
 					json.append("'d8_3':").append("'").append(vo.getD8_3()).append("'").append(",");
 					json.append("'d8_4':").append("'").append(vo.getD8_4()).append("'").append(",");
 					json.append("'d8_5':").append("'").append(vo.getD8_5()).append("'").append(",");
 					json.append("'d8_6':").append("'").append(vo.getD8_6()).append("'").append(",");
 					json.append("'d8_7':").append("'").append(vo.getD8_7()).append("'").append(",");
 					json.append("'d8_8':").append("'").append(vo.getD8_8()).append("'").append(",");
 					json.append("},"); 					
 				}
					json.deleteCharAt(json.length() - 1);  
	 				json.append("]");
	 				PrintWriter writer=response.getWriter();
	 		        writer.print(jsonp+"("+json+")");
	 		        writer.flush();
	 		        writer.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
