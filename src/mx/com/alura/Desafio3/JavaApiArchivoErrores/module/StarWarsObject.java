package mx.com.alura.Desafio3.JavaApiArchivoErrores.module;

import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.ApiRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StarWarsObject {
    protected String name;
    protected List<String> filmList;

    public String getName() {
        return name;
    }

    protected void setName(){

    }

    protected  void setFilmList(List<String> films){
        ApiRequest apiRequest = new ApiRequest();
        filmList = new ArrayList<>();
        if (films != null){
            for (String urlFilm : films){
                try {
                    String jsonStr = apiRequest.getStarWarsInfo(urlFilm);
                    String title = apiRequest.getFilmName(jsonStr);
                    filmList.add(title);
                } catch (IOException | InterruptedException | NullPointerException e) {
                    System.out.println("Ocurrio un error al generar la información: " + urlFilm);
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
