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

/**
 * Servlet implementation class easyInfo
 */
public class easyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public easyInfo() {
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
        List<AlarmInfo> list;
        //把从数据库查询的结果构造成一个JSON字符串推向前台
        StringBuffer json=new StringBuffer();
        json.append("[");
        try {
 			list = dao.selectAll();
 			
 			if(list!=null){				
 				for(AlarmInfo vo:list){
 					json.append("{");
 					json.append("'recordNo':").append("'").append(vo.getRecordNo()).append("'").append(",");
 					json.append("'alarmTime':").append("'").append(vo.getAlarmTime()).append("'").append(",");
 					json.append("'infraredSta':").append("'").append(vo.getInfraredSta()).append("'").append(",");
 					json.append("'smokeSta':").append("'").append(vo.getSmokeSta()).append("'").append(",");
 					json.append("'occupySta':").append("'").append(vo.getOccupySta()).append("'").append(",");
 					json.append("'tempSta':").append("'").append(vo.getTempSta()).append("'").append(",");
 					json.append("'handleSta':").append("'").append(vo.getHandleSta()).append("'").append(",");
 					json.append("'result':").append("'").append(vo.getResult()).append("'").append(",");
 					json.append("'school':").append("'").append(vo.getSchool()).append("'").append(",");
 					json.append("'detailBuilding':").append("'").append(vo.getDetailBuilding()).append("'").append(",");
 					json.append("'detailFloor':").append("'").append(vo.getDetailFloor()).append("'").append(",");
 					json.append("'gender':").append("'").append(vo.getGender()).append("'").append(",");
 					json.append("'siteNum':").append("'").append(vo.getSiteNum()).append("'").append(",");
 					json.append("'security':").append("'").append(vo.getSecurityNo()).append("'");
 					json.append("},"); 					
 				}			             	   
 				json.deleteCharAt(json.length() - 1);  
 				json.append("]");
		        //System.out.println(json);
		        //System.out.println(result);
		        PrintWriter writer=response.getWriter();
		        writer.print(jsonp+"("+json+")");
		        writer.flush();
		        writer.close();
 			}
 		}catch (Exception e){
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
