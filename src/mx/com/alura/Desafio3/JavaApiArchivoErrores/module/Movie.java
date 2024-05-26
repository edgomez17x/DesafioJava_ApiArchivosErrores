package mx.com.alura.Desafio3.JavaApiArchivoErrores.module;

import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.ApiRequest;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.Tools;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.records.MovieR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {

    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private Date release_date;
    private List<People> peopleList;
    private List<Planet> planetList;
    private List<Starship> starshipList;
    private List<Vehicle> vehicleList;
    private List<Specie> specieList;

    public Movie(MovieR movieR) {
        title = movieR.title();
        episode_id = movieR.episode_id();
        opening_crawl = movieR.opening_crawl();
        director = movieR.director();
        producer = movieR.producer();
        release_date = Tools.stringToDate(movieR.release_date(), "YYYY-MM-DD");
        ApiRequest apiRequest = new ApiRequest();
        peopleList = new ArrayList<>();
        for (String urlPeople : movieR.characters()){
            try {
                String jsonStr = apiRequest.getStarWarsInfo(urlPeople);
                People people = apiRequest.getPeople(jsonStr);
                peopleList.add(people);
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrio un error al generar la información: " + urlPeople);
                System.out.println(e.getMessage());
            }
        }
        planetList = new ArrayList<>();
        for (String urlPlanet : movieR.planets()){
            try {
                String jsonStr = apiRequest.getStarWarsInfo(urlPlanet);
                Planet planet = apiRequest.getPlanet(jsonStr);
                planetList.add(planet);
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrio un error al generar la información: " + urlPlanet);
                System.out.println(e.getMessage());
            }
        }
        starshipList = new ArrayList<>();
        for (String urlStarship : movieR.starships()){
            try {
                String jsonStr = apiRequest.getStarWarsInfo(urlStarship);
                Starship starship = apiRequest.getStarship(jsonStr);
                starshipList.add(starship);
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrio un error al generar la información: " + urlStarship);
                System.out.println(e.getMessage());
            }
        }
        vehicleList = new ArrayList<>();
        for (String urlVehicle : movieR.vehicles()){
            try {
                String jsonStr = apiRequest.getStarWarsInfo(urlVehicle);
                Vehicle vehicle = apiRequest.getVehicle(jsonStr);
                vehicleList.add(vehicle);
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrio un error al generar la información: " + urlVehicle);
                System.out.println(e.getMessage());
            }
        }
        specieList = new ArrayList<>();
        for (String urlSpecie : movieR.species()){
            try {
                String jsonStr = apiRequest.getStarWarsInfo(urlSpecie);
                Specie specie = apiRequest.getSpecie(jsonStr);
                specieList.add(specie);
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrio un error al generar la información: " + urlSpecie);
                System.out.println(e.getMessage());
            }
        }
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", episode_id=" + episode_id +
                ", opening_crawl='" + opening_crawl + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", release_date=" + release_date +
                ", peopleList=" + peopleList +
                ", planetList=" + planetList +
                ", starshipList=" + starshipList +
                ", vehicleList=" + vehicleList +
                ", specieList=" + specieList +
                '}';
    }
}
