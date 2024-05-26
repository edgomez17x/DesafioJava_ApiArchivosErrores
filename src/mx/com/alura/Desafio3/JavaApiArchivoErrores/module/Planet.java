package mx.com.alura.Desafio3.JavaApiArchivoErrores.module;

import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.ApiRequest;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.Tools;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.records.PeopleR;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.records.PlanetR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Planet extends StarWarsObject{
    private int rotation_period;
    private int orbital_period;
    private int diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private int surface_water;
    private int population;
    private List<String> residentList;

    public Planet(PlanetR planetR){
        name = planetR.name();
        rotation_period = Tools.stringToInt(planetR.rotation_period());
        orbital_period = Tools.stringToInt(planetR.orbital_period());
        diameter = Tools.stringToInt(planetR.diameter());
        climate = planetR.climate();
        gravity = planetR.gravity();
        terrain = planetR.terrain();
        surface_water = Tools.stringToInt(planetR.surface_water());
        population = Tools.stringToInt(planetR.population());
        residentList = People.getPeopleNameList(planetR.residents());
        setFilmList(planetR.films());
    }

    public static List<String> getPlanetNameList(List<String> planetUrls){
        ApiRequest apiRequest = new ApiRequest();
        List<String> planetList = new ArrayList<>();
        if (planetUrls != null){
            for (String urlPlanet : planetUrls){
                try {
                    String jsonStr = apiRequest.getStarWarsInfo(urlPlanet);
                    planetList.add(apiRequest.getPlanetName(jsonStr));
                } catch (IOException | InterruptedException | NullPointerException e) {
                    System.out.println("Ocurrio un error al generar la información: " + urlPlanet);
                    System.out.println(e.getMessage());
                }
            }
        }
        return planetList;
    }

    public static String getPlanetName(String homeworld) {
        ApiRequest apiRequest = new ApiRequest();
        String planetName = "";
        if (homeworld != null){
            try {
                String jsonStr = apiRequest.getStarWarsInfo(homeworld);
                planetName = apiRequest.getPlanetName(jsonStr);
            } catch (IOException | InterruptedException | NullPointerException e) {
                System.out.println("Ocurrio un error al generar la información: " + homeworld);
                System.out.println(e.getMessage());
            }
        }
        return planetName;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "rotation_period=" + rotation_period +
                ", orbital_period=" + orbital_period +
                ", diameter=" + diameter +
                ", climate='" + climate + '\'' +
                ", gravity='" + gravity + '\'' +
                ", terrain='" + terrain + '\'' +
                ", surface_water=" + surface_water +
                ", population=" + population +
                ", residentList=" + residentList +
                ", name='" + name + '\'' +
                ", filmList=" + filmList +
                '}';
    }
}
