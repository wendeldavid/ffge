package ff.grosso.escroto.data;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ff.grosso.escroto.Servlet;

public class DateSerializer implements JsonSerializer<LocalDateTime> {

	@Override
	public JsonElement serialize(LocalDateTime date, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(date.format(Servlet.formatter));
	}

}
