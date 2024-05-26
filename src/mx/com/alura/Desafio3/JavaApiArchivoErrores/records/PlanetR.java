package mx.com.alura.Desafio3.JavaApiArchivoErrores.records;

import java.util.List;

public record PlanetR(String name, String rotation_period, String orbital_period, String diameter, String climate,
        String gravity, String terrain, String surface_water, String population, List<String>films,
        List<String> residents) {
}
