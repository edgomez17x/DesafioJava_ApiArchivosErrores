package mx.com.alura.Desafio3.JavaApiArchivoErrores.records;

import java.util.List;

public record SpecieR(String name, String classification, String average_height, String skin_colors,
         String hair_colors, String eye_colors, String average_lifespan, String homeworld, String language,
         List<String> people, List<String> films) {
}
