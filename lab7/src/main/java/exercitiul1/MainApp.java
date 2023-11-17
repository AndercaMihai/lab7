package exercitiul1;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Collection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainApp {
    public static void main(String[] args) {
        Map carti=citire();
        carti.forEach((id,carte) -> {
            System.out.println("ID: " +id);
            System.out.println(carte.toString());
            System.out.println();
        });

        Scanner scanner = new Scanner(System.in);
        int nr;
        System.out.println("Ce carte doriti sa stergeti ? Introduceti id-ul: ");
        nr = scanner.nextInt();
        int idCarteDeSters = nr;
        carti.remove(idCarteDeSters);
        carti.forEach((id, carte) -> System.out.println("ID: " + id + " " + carte));

        carti.putIfAbsent(7, new Carte(7,"Abc","Abc",1930));
        carti.forEach((id, carte) -> System.out.println("ID: " + id + " " + carte));

        scriere(carti);

        Colection<Integer>Colectie=new LinkedHashSet<Integer>(carti);






    }
    public static void scriere(Map<Integer,Carte> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<Integer,Carte> citire() {
        try {
            File file=new File("src/main/resources/carti.json");
            ObjectMapper mapper=new ObjectMapper();
            Map<Integer,Carte> carti = mapper.readValue(file, new TypeReference<Map<Integer,Carte>>(){});
            return carti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;



    }


}