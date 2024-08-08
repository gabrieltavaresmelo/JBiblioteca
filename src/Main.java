import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        Autor autor1 = new Autor();
        autor1.nome = "Machado de Assis";
        autor1.email = "machado@gmail.com";

        Autor autor2 = new Autor();
        autor2.nome = "Natercia Campos";
        autor2.email = "natercia@gmail.com";

        Livro livro1 = new Livro("Dom Casmurro", "Livro do autor Machado de Assis", 49.9, "123456");
        livro1.autor = autor1;

        Livro livro2 = new Livro();
        livro2.nome = "A Casa";
        livro2.valor = 29.5;
        livro2.descricao = "Livro de Natércia Campos";
        livro2.isbn = "321654";
        livro2.autor = autor2;

        ArrayList<Livro> vetor = new ArrayList();
        vetor.add(livro1);
        vetor.add(livro2);

        for (int i = 0; i < vetor.size(); i++) {
            Livro livro = vetor.get(i);

            System.out.println("**** Livro: " + (i+1));
            livro.mostraDetalhes();
        }
    }
}