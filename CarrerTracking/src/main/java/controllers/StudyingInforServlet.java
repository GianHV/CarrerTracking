package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.ApiResponse;
import models.StudyInfor;
import services.IStudyingService;
import services.StudyingService;

/**
 * Servlet implementation class StudyingInforServlet
 */
@WebServlet("/StudyingInfor")
public class StudyingInforServlet extends HttpServlet {
    private IStudyingService service = new StudyingService();
    private Gson gson = new Gson();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	StudyInfor data = service.GetInfors();
    	
    	ApiResponse response = new ApiResponse();
    	response.data = data;
    	String json = gson.toJson(response);
    	
    	resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter print = resp.getWriter();
		print.print(json);
		print.flush();
    }

}
