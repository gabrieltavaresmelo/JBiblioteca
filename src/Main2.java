import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("José");
        nomes.add("André");
        nomes.add("Adriano");
        nomes.add("joão");
        nomes.add("Joaquim");

        for(String nome: nomes) {
            if(nome.contains("dr")) {
                String concat = "Meu nome é " + nome;
                System.out.println(concat);
            }
        }

    }

}
