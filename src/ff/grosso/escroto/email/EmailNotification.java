package ff.grosso.escroto.email;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ff.grosso.escroto.data.Grosseria;

public class EmailNotification {

	private final static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	private final static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void sendMail(Grosseria grosseria) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.senior.com.br");

		Session session = Session.getInstance(props, null);

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("monitor@ffge.com"));
			Address[] addresses = InternetAddress.parse(EmailManager.getEmails());
			msg.addRecipients(Message.RecipientType.BCC, addresses);
			msg.setSubject("Nova ofensa contra " + grosseria.getVitima());
			msg.setSentDate(new Date());
			msg.setText(getContent(grosseria), "utf-8", "html");

			Transport.send(msg);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private static String getContent(Grosseria grosseria) {
		StringBuilder sb = new StringBuilder();

		sb.append("<body>");

		sb.append("<style type=\"text/css\">");
		sb.append(".ffge-font {");
		sb.append("font-family: \"Helvetica Neue, Helvetica, Arial, sans-serif\";");
		sb.append("font-size: 14px;");
		sb.append("}");
		sb.append("</style>");

		sb.append("<div class=\"ffge-font\">Foi ").append(grosseria.getAcao()).append(" com ").append(grosseria.getVitima());
		sb.append(" às ").append(grosseria.getData().format(timeFormatter));
		sb.append(" em ").append(grosseria.getData().format(dateFormatter));
		sb.append("</div>");

		sb.append("<br><br>");

		sb.append("<div class=\"ffge-font\">Descrição: ").append(grosseria.getDescricao()).append("</div>");
		sb.append("<br><br>");

		sb.append("<div class=\"ffge-font\">Para ver lista de ofensas, <a href=\"http://pcbnu007999:8888/ffge/#\">acesse o portal FFGE.</a></div>");

		sb.append("</body>");

		return sb.toString();
	}

}
