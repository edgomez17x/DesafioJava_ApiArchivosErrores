package mx.com.alura.Desafio3.JavaApiArchivoErrores.module;

import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.ApiRequest;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.Tools;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.records.PeopleR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class People extends StarWarsObject{
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private List<String> specieList;
    private List<String> vehicleList;
    private List<String> starshipList;

    public People(PeopleR peopleR){
        name = peopleR.name();
        height = Tools.stringToInt(peopleR.height());
        mass = Tools.stringToInt(peopleR.mass());
        hair_color = peopleR.hair_color();
        skin_color = peopleR.skin_color();
        eye_color = peopleR.eye_color();
        birth_year = peopleR.birth_year();
        gender = peopleR.gender();
        homeworld = Planet.getPlanetName(peopleR.homeworld());
        specieList = Specie.getSpecieNameList(peopleR.species());
        vehicleList = Vehicle.getVehicleNameList(peopleR.vehicles());
        starshipList = Starship.getStarshipNameList(peopleR.starships());
        setFilmList(peopleR.films());
    }

    public static List<String> getPeopleNameList(List<String> peopleUrls){
        ApiRequest apiRequest = new ApiRequest();
        List<String> peopleList = new ArrayList<>();
        if (peopleUrls != null){
            for (String urlPeople : peopleUrls){
                try {
                    String jsonStr = apiRequest.getStarWarsInfo(urlPeople);
                    peopleList.add(apiRequest.getPeopleName(jsonStr));
                } catch (IOException | InterruptedException | NullPointerException e) {
                    System.out.println("Ocurrio un error al generar la información: " + urlPeople);
                    System.out.println(e.getMessage());
                }
            }
        }
        return peopleList;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", hair_color='" + hair_color + '\'' +
                ", skin_color='" + skin_color + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", birth_year=" + birth_year +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", specieList=" + specieList +
                ", vehicleList=" + vehicleList +
                ", starshipList=" + starshipList +
                ", filmList=" + filmList +
                '}';
    }
}
