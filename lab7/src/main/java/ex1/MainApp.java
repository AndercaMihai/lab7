package ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
       Map<Integer, Carte> carti_map=citire();
        carti_map.forEach((id,carte) -> {
            System.out.println("ID: " +id);
            System.out.println(carte.toString());
            System.out.println();
        });
        Scanner scanner=new Scanner(System.in);
        int nr;
        System.out.println("Ce carte doriti sa stergeti ? Introduceti id-ul: ");
        nr=scanner.nextInt();
        int idCarteDeSters=nr ;
        carti_map.remove(idCarteDeSters);
        carti_map.forEach((id, carte) -> System.out.println("ID: " + id +" " + carte));
    }

    public static void scriere(Map<Integer, Carte> carti_map) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/carti.json");
            mapper.writeValue(file, carti_map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Carte> citire() {
        try {
            File file = new File("src/main/resources/carti.json");
            ObjectMapper mapper = new ObjectMapper();
         Map<Integer, Carte> carti_map=mapper.readValue(file, new TypeReference<Map<Integer, Carte>>(){});

            return carti_map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}



