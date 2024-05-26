package mx.com.alura.Desafio3.JavaApiArchivoErrores;

import mx.com.alura.Desafio3.JavaApiArchivoErrores.module.Movie;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.ApiRequest;
import mx.com.alura.Desafio3.JavaApiArchivoErrores.process.SaveInfo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("""
                *********************************
                *   Información de STAR WARS    *
                *********************************""");
        String menu = """
                Favor de selecciona el número para la pélicula que desea ver la información:
                \t1.- A New Hope.
                \t2.- The Empire Strikes Back.
                \t3.- Return of the Jedi.
                \t4.- The Phantom Menace.
                \t5.- Attack of the Clones.
                \t6.- Revenge of the Sith.
                \t0.- Salir.""";
        System.out.println(menu);
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (option!=0){
            if (option > 0 && option < 8){
                try {
                    ApiRequest apiRequest = new ApiRequest();
                    String jsonStr = apiRequest.getStarWarsMovie(option);
                    Movie movie = apiRequest.getMovie(jsonStr);
                    System.out.println(movie);
                    //Guardado de información en un archivo
                    SaveInfo saveInfo = new SaveInfo();
                    saveInfo.saveMovie(movie);
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(menu);
            scanner = new Scanner(System.in);
            option = scanner.nextInt();
        }
        System.out.println("Gracias por usar el programa de información de Star Wars, que la fuerza te acompañe.");
    }
}
