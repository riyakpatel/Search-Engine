package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class frequencypage
 */
@WebServlet("/frequencypage")
public class frequencypage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public frequencypage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap = (Map<String, Integer>) request.getSession().getAttribute("frequency");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			Integer tab = entry.getValue();
			// do something with key and/or tab
			/* System.out.println(entry.getKey()+"*****"+entry.getValue()); */
			out.println(entry.getKey() + "***" + entry.getValue());
			out.print("<br/>");
		}
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
