package ff.grosso.escroto;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ff.grosso.escroto.data.Grosseria;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String USER_PATH = "c:/users/wendel.przygoda";
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss");
	private static int count = 0;

	private static final List<String> filterAddress = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
	}

	static {
		loadFilter();
	}

	private static void loadFilter() {
		File propFile = new File(Servlet.USER_PATH, "ffge.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(propFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		filterAddress.clear();
		filterAddress.addAll(Arrays.asList(prop.getProperty("ignore").split(",")));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			// acessos
			File propFile = new File(USER_PATH, "ffge.properties");
			Properties prop = new Properties();
			prop.load(new FileInputStream(propFile));

			if (count == 0) {
				count = Integer.parseInt(prop.getProperty("acessos", "0"));
			}

			count++;
			prop.put("acessos", String.valueOf(count));

			prop.store(new FileOutputStream(propFile), "");

			log("Acesso", request);

			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().append(DataHandler.readData());

		} catch (Exception e) {
			logError(e, request);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!doFilter(req, resp, "Cadastro NEGADO")) {
			return;
		}

		log("Cadastro", req);

		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()))) {
			while (reader.ready()) {
				sb.append(reader.readLine());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		Grosseria grosseria = DataHandler.writeData(sb.toString());

		// EmailNotification.sendMail(grosseria);
	}

	public static boolean doFilter(HttpServletRequest request, HttpServletResponse response, String messageLog) throws IOException, ServletException {
		String ipAddress = request.getRemoteAddr();
		InetAddress host = InetAddress.getByName(ipAddress);

		for (String filter : filterAddress) {
			if (ipAddress.toUpperCase().contains(filter.toUpperCase()) || //
					host.getHostAddress().toUpperCase().contains(filter.toUpperCase()) || //
					host.getHostName().toUpperCase().contains(filter.toUpperCase())) {

				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "ffdenied");

				log(messageLog, request);

				return false;
			}
		}
		return true;
	}

	public static final void log(String action, HttpServletRequest request) {
		try {
			// log
			String ipAddress = request.getRemoteAddr();
			InetAddress host = InetAddress.getByName(ipAddress);

			String log = action + ": " + LocalDateTime.now().format(formatter) + " : " + host.getHostName() + '[' + host.getHostAddress() + ']';

			System.out.println(log);

			File logFile = new File(USER_PATH, "ffge.log");

			BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write(log);
			writer.newLine();
			writer.flush();
			writer.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final void logError(Exception exception, HttpServletRequest request) {
		try {
			// log
			String ipAddress = request.getRemoteAddr();
			InetAddress host = InetAddress.getByName(ipAddress);

			String log = "[ERRO] : " + LocalDateTime.now().format(formatter) + " : " + host.getHostName() + '[' + host.getHostAddress() + "]\n";

			System.out.println(log);

			File logFile = new File(USER_PATH, "ffge.log");

			BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write(log);
			writer.newLine();
			writer.flush();
			writer.close();

			exception.printStackTrace(new PrintStream(new BufferedOutputStream(new FileOutputStream(logFile))));

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
