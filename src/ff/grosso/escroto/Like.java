package ff.grosso.escroto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Like
 */
@WebServlet("/Like")
public class Like extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Like() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!Servlet.doFilter(request, response, "Like NEGADO")) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
			while (reader.ready()) {
				sb.append(reader.readLine());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		long id = Long.parseLong(sb.toString());
		String ipAddress = request.getRemoteAddr();

		Servlet.log("Like", request);

		DataHandler.grosseriaLiked(id, ipAddress);

	}

}
