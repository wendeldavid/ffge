package ff.grosso.escroto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import ff.grosso.escroto.data.FF;
import ff.grosso.escroto.data.Grosseria;

public class DataHandler {

	private static final File FILE = new File("c:/users/wendel.przygoda", "ffge1.json"); // FIXME alterar para produção
	private static final GsonBuilder builder = new GsonBuilder();

	static {
		builder.setPrettyPrinting();
	}

	public static String readData() {
		StringBuilder result = new StringBuilder("{\"ff\":");

		result.append(innerRead());

		return result.append("}").toString();
	}

	public static Grosseria writeData(String json) {
		Gson data = builder.create();

		FF ff = data.fromJson(innerRead(), FF.class);

		Grosseria grosseria = data.fromJson(json, Grosseria.class);
		grosseria.setData(LocalDateTime.now());

		try (FileWriter writer = new FileWriter(FILE)) {
			Collection<Grosseria> grosserias = ff.getGrosserias();
			LocalDateTime ultimaGrosseria = ((Grosseria) grosserias.stream().toArray()[grosserias.size() - 1]).getData();
			long dias = Duration.between(ultimaGrosseria, LocalDateTime.now()).toDays();
			ff.setDias(dias);

			if (dias > ff.getRecorde()) {
				ff.setRecorde(dias);
			}

			ff.getGrosserias().add(grosseria);

			writer.write(data.toJson(ff));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return grosseria;
	}

	private static String innerRead() {
		StringBuilder result = new StringBuilder();

		Gson data = builder.create();
		try (Reader reader = new FileReader(FILE);) {
			FF ff = data.fromJson(reader, FF.class);

			Collection<Grosseria> grosserias = ff.getGrosserias();
			LocalDateTime ultimaGrosseria = ((Grosseria) grosserias.stream().toArray()[grosserias.size() - 1]).getData();
			long dias = Duration.between(ultimaGrosseria, LocalDateTime.now()).toDays();
			ff.setDias(dias);

			if (dias > ff.getRecorde()) {
				ff.setRecorde(dias);
			}

			result.append(data.toJson(ff));

		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return result.toString();
	}

}
