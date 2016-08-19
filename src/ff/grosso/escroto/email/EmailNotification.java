package ff.grosso.escroto.email;

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

	public static void sendMail(Grosseria grosseria) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.senior.com.br");

		Session session = Session.getInstance(props, null);

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom("monitor@ffge.com");
			Address[] addresses = InternetAddress.parse(EmailManager.getEmails());
			msg.addRecipients(Message.RecipientType.BCC, addresses);
			msg.setSubject("Nova ofensa contra " + grosseria.getVitima());
			msg.setSentDate(new Date());
			msg.setText("Foi " + grosseria.getAcao() + '\n' + grosseria.getDescricao());

			Transport.send(msg);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
