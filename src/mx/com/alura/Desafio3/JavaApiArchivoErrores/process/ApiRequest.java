package mx.com.alura.Desafio3.JavaApiArchivoErrores.process;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.module.*;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.records.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    private static String URLBASE = "https://swapi.py4e.com/api/films/";

    public String getStarWarsMovie(int idMovie) throws IOException, InterruptedException {
        String url = URLBASE + idMovie + "/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getStarWarsInfo(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public Movie getMovie(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        MovieR movieR = gson.fromJson(jsonStr, MovieR.class);
        return new Movie(movieR);
    }

    public People getPeople(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PeopleR peopleR = gson.fromJson(jsonStr, PeopleR.class);
        return new People(peopleR);
    }

    public Planet getPlanet(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PlanetR planetR = gson.fromJson(jsonStr, PlanetR.class);
        return new Planet(planetR);
    }

    public Starship getStarship(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StarshipR starshipR = gson.fromJson(jsonStr, StarshipR.class);
        return new Starship(starshipR);
    }

    public Vehicle getVehicle(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        VehicleR vehicleR = gson.fromJson(jsonStr, VehicleR.class);
        return new Vehicle(vehicleR);
    }

    public Specie getSpecie(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        SpecieR specieR = gson.fromJson(jsonStr, SpecieR.class);
        return new Specie(specieR);
    }

    public String getFilmName(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        MovieR movieR = gson.fromJson(jsonStr, MovieR.class);
        return movieR.title();
    }



    public String getPeopleName(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PeopleR peopleR = gson.fromJson(jsonStr, PeopleR.class);
        return peopleR.name();
    }

    public String getPlanetName(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PlanetR planetR = gson.fromJson(jsonStr, PlanetR.class);
        return planetR.name();
    }

    public String getStarshipName(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StarshipR starshipR = gson.fromJson(jsonStr, StarshipR.class);
        return starshipR.name();
    }

    public String getVehicleName(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        VehicleR vehicleR = gson.fromJson(jsonStr, VehicleR.class);
        return vehicleR.name();
    }

    public String getSpecieName(String jsonStr){
        System.out.println("JSON a procesar: " + jsonStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        SpecieR specieR = gson.fromJson(jsonStr, SpecieR.class);
        return specieR.name();
    }

}
