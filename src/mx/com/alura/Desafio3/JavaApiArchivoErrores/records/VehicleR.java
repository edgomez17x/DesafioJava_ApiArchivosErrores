package mx.com.alura.Desafio3.JavaApiArchivoErrores.records;

import java.util.List;

public record VehicleR(String name, List<String>filmList, String model, String manufacturer, String cost_in_credits,
    String length, String max_atmosphering_speed, String crew, String passangers, String cargo_capacity,
    String consumables, String vehicle_class, List<String> pilotList) {
}
