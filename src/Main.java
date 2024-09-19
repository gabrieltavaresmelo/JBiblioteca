import models.Autor;
import models.Livro;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        Autor autor1 = new Autor();
        autor1.setNome("Gabriel");
        autor1.setEmail("gabriel@gmail.com");
        autor1.setTelefone("(85) 8899-7788");

        Autor autor2 = new Autor();
        autor2.setNome("Maria");
        autor2.setEmail("maria@gmail.com");
        autor2.setTelefone("(85) 5599-7788");

        Livro livro1 = new Livro("Dom Casmurro", "entidades.Livro do autor Machado de Assis", 49.9, "123456");
        livro1.setAutor(autor1);

        Livro livro2 = new Livro();
        livro2.setNome("A Casa");
        livro2.setValor(29.5);
        livro2.setDescricao("entidades.Livro de Natércia Campos");
        livro2.setIsbn("321654");
        livro2.setAutor(autor2);

        ArrayList<Livro> vetor = new ArrayList();
        vetor.add(livro1);
        vetor.add(livro2);

        for (int i = 0; i < vetor.size(); i++) {
            Livro livro = vetor.get(i);

            System.out.println("**** entidades.Livro: " + (i+1));
            livro.mostraDetalhes();
        }
    }
}