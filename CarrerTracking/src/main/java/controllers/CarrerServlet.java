package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "carrerServlets", urlPatterns = {"/carrers/add"})
public class CarrerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
		switch (urlPath) {
		case "/carrers/add":
			ShowCarrerForm(req, resp);
			break;
		default:
			break;
		}
	}

	private void ShowCarrerForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/add-carrer.jsp").forward(req, resp);
	}
}
