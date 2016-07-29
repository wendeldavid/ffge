package ff.grosso.escroto.data;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import ff.grosso.escroto.Servlet;

public class DateDeserializer implements JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonElement dateStr, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		return LocalDateTime.parse(dateStr.getAsString(), Servlet.formatter);
	}

}
