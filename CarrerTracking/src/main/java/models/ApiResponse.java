package models;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class ApiResponse {
	public boolean isSuccess = true;
	public List<String> errorMessages = new ArrayList<String>();
	public int status = HttpServletResponse.SC_OK;
	public Object data;
}
