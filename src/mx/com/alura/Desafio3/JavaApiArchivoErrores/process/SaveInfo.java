package mx.com.alura.Desafio3.JavaApiArchivoErrores.process;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.module.Movie;

import java.io.FileWriter;
import java.io.IOException;

public class SaveInfo {

    public void saveMovie(Movie movie) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter(movie.getTitle() + ".json");
        fw.write(gson.toJson(movie));
        fw.close();
    }
}
