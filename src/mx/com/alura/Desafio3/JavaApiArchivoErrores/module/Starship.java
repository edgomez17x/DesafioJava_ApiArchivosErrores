package mx.com.alura.Desafio3.JavaApiArchivoErrores.module;

import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.ApiRequest;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.Tools;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.records.StarshipR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Starship extends Vehicle{
    private double hyperdrive_rating;
    private int MGLT;
    private String starship_class;

    public Starship(StarshipR starshipR){
        super(starshipR);
        hyperdrive_rating = Tools.stringToDouble(starshipR.hyperdrive_rating());
        MGLT = Tools.stringToInt(starshipR.MGLT());
        starship_class = starshipR.starship_class();
    }

    public static List<String> getStarshipNameList(List<String> starshipUrls){
        ApiRequest apiRequest = new ApiRequest();
        List<String> starshipList = new ArrayList<>();
        if (starshipUrls != null){
            for (String urlStarship : starshipUrls){
                try {
                    String jsonStr = apiRequest.getStarWarsInfo(urlStarship);
                    starshipList.add(apiRequest.getStarshipName(jsonStr));
                } catch (IOException | InterruptedException | NullPointerException e) {
                    System.out.println("Ocurrio un error al generar la información: " + urlStarship);
                    System.out.println(e.getMessage());
                }
            }
        }
        return starshipList;
    }

    @Override
    public String toString() {
        return "Starship{" +
                "hyperdrive_rating=" + hyperdrive_rating +
                ", MGLT=" + MGLT +
                ", starship_class='" + starship_class + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cost_in_credits=" + cost_in_credits +
                ", length=" + length +
                ", max_atmosphering_speed=" + max_atmosphering_speed +
                ", crew=" + crew +
                ", passangers=" + passangers +
                ", cargo_capacity=" + cargo_capacity +
                ", consumables='" + consumables + '\'' +
                ", pilotList=" + pilotList +
                ", name='" + name + '\'' +
                ", filmList=" + filmList +
                '}';
    }
}
