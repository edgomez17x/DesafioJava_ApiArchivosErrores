package mx.com.alura.Desafio3.JavaApiArchivoErrores.module;

import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.ApiRequest;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.Tools;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.records.SpecieR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Specie extends StarWarsObject{
    private String classification;
    private int average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private int average_lifespan;
    private String homeworld;
    private String language;
    private List<String> peopleList;

    public Specie(SpecieR specieR){
        name = specieR.name();
        classification = specieR.classification();
        average_height = Tools.stringToInt(specieR.average_height());
        skin_colors = specieR.skin_colors();
        hair_colors = specieR.hair_colors();
        eye_colors = specieR.eye_colors();
        average_lifespan = Tools.stringToInt(specieR.average_lifespan());
        homeworld = specieR.homeworld();
        language = specieR.language();
        peopleList = People.getPeopleNameList(specieR.people());
        setFilmList(specieR.films());
    }

    public static List<String> getSpecieNameList(List<String> specieUrls){
        ApiRequest apiRequest = new ApiRequest();
        List<String> specieList = new ArrayList<>();
        if(specieUrls != null){
            for (String urlSpecie : specieUrls){
                try {
                    String jsonStr = apiRequest.getStarWarsInfo(urlSpecie);
                    specieList.add(apiRequest.getSpecieName(jsonStr));
                } catch (IOException | InterruptedException | NullPointerException e) {
                    System.out.println("Ocurrio un error al generar la información: " + urlSpecie);
                    System.out.println(e.getMessage());
                }
            }
        }
        return specieList;
    }

    @Override
    public String toString() {
        return "Specie{" +
                "classification='" + classification + '\'' +
                ", average_height=" + average_height +
                ", skin_colors='" + skin_colors + '\'' +
                ", hair_colors='" + hair_colors + '\'' +
                ", eye_colors='" + eye_colors + '\'' +
                ", average_lifespan=" + average_lifespan +
                ", homeworld='" + homeworld + '\'' +
                ", language='" + language + '\'' +
                ", peopleList=" + peopleList +
                ", name='" + name + '\'' +
                ", filmList=" + filmList +
                '}';
    }
}
