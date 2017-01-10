package ff.grosso.escroto;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import ff.grosso.escroto.email.EmailManager;

/**
 * Servlet implementation class Subscribe
 */
@WebServlet("/Subscribe")
public class Subscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final GsonBuilder builder = new GsonBuilder();

	static {
		builder.setPrettyPrinting();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Subscribe() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!Servlet.doFilter(request, response)) {
			return;
		}

		String email = null;
		String acao = null;

		try (JsonReader reader = new JsonReader(new InputStreamReader(request.getInputStream()));) {
			reader.beginObject();
			while (reader.hasNext()) {
				String att = reader.nextName();
				if (att.equals("email")) {
					email = reader.nextString();
				} else if (att.equals("acao")) {
					acao = reader.nextString();
				}
			}
			reader.endObject();
		}

		if ("subscribe".equals(acao)) {
			EmailManager.addEmail(email);
			Servlet.log("inscreve email: " + email, request);
		} else if ("unsubscribe".equals(acao)) {
			EmailManager.removeEmail(email);
			Servlet.log("remove email: " + email, request);
		}

	}

}
