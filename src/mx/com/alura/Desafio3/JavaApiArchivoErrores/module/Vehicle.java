package mx.com.alura.Desafio3.JavaApiArchivoErrores.module;

import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.ApiRequest;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.Tools;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.records.StarshipR;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.records.VehicleR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vehicle extends StarWarsObject{
    protected String model;
    protected String manufacturer;
    protected int cost_in_credits;
    protected double length;
    protected int max_atmosphering_speed;
    protected int crew;
    protected int passangers;
    protected int cargo_capacity;
    protected String consumables;
    private String vehicle_class;
    protected List<String> pilotList;

    public Vehicle(VehicleR vehicleR){
        name = vehicleR.name();
        model = vehicleR.model();
        manufacturer = vehicleR.manufacturer();
        cost_in_credits = Tools.stringToInt(vehicleR.cost_in_credits());
        length = Tools.stringToDouble(vehicleR.length());
        max_atmosphering_speed = Tools.stringToInt(vehicleR.max_atmosphering_speed());
        crew = Tools.stringToInt(vehicleR.crew());
        passangers = Tools.stringToInt(vehicleR.passangers());
        cargo_capacity = Tools.stringToInt(vehicleR.cargo_capacity());
        consumables = vehicleR.consumables();
        vehicle_class = vehicleR.vehicle_class();
        pilotList = People.getPeopleNameList(vehicleR.pilotList());
        setFilmList(vehicleR.filmList());
    }

    public Vehicle(StarshipR starshipR){
        name = starshipR.name();
        model = starshipR.model();
        manufacturer = starshipR.manufacturer();
        cost_in_credits = Tools.stringToInt(starshipR.cost_in_credits());
        length = Tools.stringToDouble(starshipR.length());
        max_atmosphering_speed = Tools.stringToInt(starshipR.max_atmosphering_speed());
        crew = Tools.stringToInt(starshipR.crew());
        passangers = Tools.stringToInt(starshipR.passangers());
        cargo_capacity = Tools.stringToInt(starshipR.cargo_capacity());
        consumables = starshipR.consumables();
        pilotList = People.getPeopleNameList(starshipR.pilotList());
        setFilmList(starshipR.filmList());
    }

    public static List<String> getVehicleNameList(List<String> vehicleUrls){
        ApiRequest apiRequest = new ApiRequest();
        List<String> vehicleList = new ArrayList<>();
        if (vehicleUrls != null){
            for (String urlVehicle : vehicleUrls){
                try {
                    String jsonStr = apiRequest.getStarWarsInfo(urlVehicle);
                    vehicleList.add(apiRequest.getVehicleName(jsonStr));
                } catch (IOException | InterruptedException | NullPointerException e) {
                    System.out.println("Ocurrio un error al generar la información: " + urlVehicle);
                    System.out.println(e.getMessage());
                }
            }
        }
        return vehicleList;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cost_in_credits=" + cost_in_credits +
                ", length=" + length +
                ", max_atmosphering_speed=" + max_atmosphering_speed +
                ", crew=" + crew +
                ", passangers=" + passangers +
                ", cargo_capacity=" + cargo_capacity +
                ", consumables='" + consumables + '\'' +
                ", vehicle_class='" + vehicle_class + '\'' +
                ", pilotList=" + pilotList +
                ", name='" + name + '\'' +
                ", filmList=" + filmList +
                '}';
    }
}
