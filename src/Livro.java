public class Livro {

    String nome;
    String descricao;
    double valor;
    String isbn;
    Autor autor;

    public Livro() {

    }

    public Livro(String nome, String descricao, double valor, String isbn) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.isbn = isbn;
    }

    void aplicaDesconto(double valor) {
        this.valor = this.valor - (this.valor * valor);
    }

    void mostraDetalhes() {
        System.out.println(nome);
        System.out.println(descricao);
        System.out.println(valor);
        System.out.println(isbn);
        System.out.println(autor.nome);
    }
}
