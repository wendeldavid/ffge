package ff.grosso.escroto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ff.grosso.escroto.data.Grosseria;
import ff.grosso.escroto.email.EmailNotification;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss");
	private static int count = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File propFile = new File("c:/users/wendel.przygoda", "ffge.properties");
		Properties prop = new Properties();
		prop.load(new FileInputStream(propFile));

		if (count == 0) {
			count = Integer.parseInt(prop.getProperty("acessos", "0"));
		}

		count++;
		prop.put("acessos", String.valueOf(count));
		System.out.println(count + " : " + LocalDateTime.now().format(formatter));

		prop.store(new FileOutputStream(propFile), "");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().append(DataHandler.readData());
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()))) {
			while (reader.ready()) {
				sb.append(reader.readLine());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		Grosseria grosseria = DataHandler.writeData(sb.toString());

		EmailNotification.sendMail(grosseria);
	}

}
