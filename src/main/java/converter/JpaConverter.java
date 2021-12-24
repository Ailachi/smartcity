package converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//@Converter(autoApply = true)
public class JpaConverter implements AttributeConverter<Object, String> {

    static ObjectMapper objectMapper = new ObjectMapper();


    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Object user) {
        String str = objectMapper.writeValueAsString(user);

        return str;
    }

    @SneakyThrows
    @Override
    public Object convertToEntityAttribute(String s) {
        Object user = objectMapper.readValue(s, Object.class);
        return user;
    }
}
