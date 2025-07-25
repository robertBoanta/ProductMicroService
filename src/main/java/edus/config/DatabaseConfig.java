package edus.config;

import org.postgresql.util.PGobject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.lang.NonNull;

import java.util.Arrays;

@Configuration
public class DatabaseConfig {

    @Bean
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Arrays.asList(
                new PGObjectToStringConverter(),
                new StringToPGObjectConverter()
        ));
    }

    @ReadingConverter
    static class PGObjectToStringConverter implements Converter<PGobject, String> {
        @Override
        public String convert(@NonNull PGobject source) {
            String value = source.getValue();
            // Handle null or empty JSON values
            if (value == null || value.trim().isEmpty()) {
                return "[]"; // Return empty array for null/empty JSON
            }
            return value;
        }
    }

    @WritingConverter
    static class StringToPGObjectConverter implements Converter<String, PGobject> {
        @Override
        public PGobject convert(@NonNull String source) {
            PGobject pGobject = new PGobject();
            pGobject.setType("jsonb"); // Use jsonb instead of json for better performance
            try {
                // Handle null or empty strings
                if (source == null || source.trim().isEmpty()) {
                    pGobject.setValue("[]");
                } else {
                    pGobject.setValue(source);
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to convert String to PGobject", e);
            }
            return pGobject;
        }
    }
}
