package common;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * The BaseServlet class extends HttpServlet and provides common functionality 
 * for handling HTTP requests and responses. 
 * 
 * @version 1.00
 * @author Huynh Van Giang
 */
public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	 /**
     * Configures the character encoding for both the request and response objects 
     * to UTF-8 to support proper handling of non-ASCII characters.
     * 
     * @param request The HttpServletRequest object containing the client's request.
     * @param response The HttpServletResponse object for sending the response to the client.
     * @throws UnsupportedEncodingException If the UTF-8 encoding is not supported.
     */
	protected void configUTF8(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
}
