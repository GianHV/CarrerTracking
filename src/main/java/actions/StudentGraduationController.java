package actions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.BaseServlet;
import common.Constants;
import common.StringExt;
import dto.SchoolSection;
import logic.StudentGraduationLogic;

/**
 * This class is using for routing action in student and graduation information
 * 
 * @version 1.00
 * @author Huynh Van Giang
 */
public class StudentGraduationController extends BaseServlet {

	// Serial version UID for versioning the class in case of serialization
	private static final long serialVersionUID = 1L;

	// Logic instance for handling business logic related to student graduation
	private StudentGraduationLogic logic = new StudentGraduationLogic();

	/**
	 * Handles the GET request for initializing screen T001, where student
	 * information can be added along with related school section data.
	 * 
	 * @param request  The HttpServletRequest object containing the request made by
	 *                 the client.
	 * @param response The HttpServletResponse object containing the response to
	 *                 send back to the client.
	 * @throws UnsupportedEncodingException If the character encoding is
	 *                                      unsupported.
	 * @since 1.00
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			// Configuring the request and response encoding to UTF-8
			configUTF8(request, response);

			// Fetching school sections
			SchoolSection schoolSection = logic.getSchoolSections();

			// Setting attributes to be used in the JSP page
			request.setAttribute("schools", schoolSection.schools);
			request.setAttribute("sections", schoolSection.sections);
			request.setAttribute("title", "Them thong tin sinh vien");

			// Forwarding the request to the JSP page for rendering
			request.getRequestDispatcher(Constants.T001_FORM).forward(request, response);

		} catch (UnsupportedEncodingException exeption) {
			exeption.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String errorMessage = logic.isValidData(request);
		if (!StringExt.isNullOrEmpty(errorMessage)) {
			request.setAttribute("error-message", errorMessage);
			doGet(request, response);
		} else {

		}
	}
}
