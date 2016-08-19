package ff.grosso.escroto.email;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmailManager {

	private static final File file = new File("c:/users/wendel.przygoda", "ffge.mail");

	private static final List<String> getEmailFile() {
		StringBuilder sb = new StringBuilder();
		synchronized (file) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file));) {

				while (reader.ready()) {
					sb.append(reader.readLine());
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<String>(Arrays.asList(sb.toString().split(";")));
	}

	private static final void saveEmails(List<String> emails) {
		String toFile = emails.stream().collect(Collectors.joining(";"));
		synchronized (file) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				writer.write(toFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static final void addEmail(String email) {
		List<String> emails = getEmailFile();
		emails.add(email);
		saveEmails(emails);
	}

	public static final void removeEmail(String email) {
		List<String> emails = getEmailFile();
		emails.remove(email);
		saveEmails(emails);
	}

}
