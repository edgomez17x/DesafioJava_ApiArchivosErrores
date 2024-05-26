package mx.com.alura.Desafio3.JavaApiArchivoErrores.records;

import java.util.List;

public record PeopleR(String name, String height, String mass, String hair_color, String skin_color,
                      String eye_color, String birth_year, String gender, String homeworld, List<String> species,
                      List<String> vehicles, List<String> starships, List<String> films) {
}
