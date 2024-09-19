import models.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LivroGUI {
    private JTextField textFieldBuscar;
    private JButton buscarButton;
    private JButton inserirButton;
    private JButton removerButton;
    private JList list1;
    private JPanel mainPane;

    public ArrayList<Livro> lista;
    public DefaultListModel modelo;

    public JPanel getPanelMain() {
        return mainPane;
    }

    public void carregaDados() {
        Livro livro1 = new Livro();
        livro1.setNome("Java Básico");
        livro1.setValor(49.9);

        Livro livro2 = new Livro();
        livro2.setNome("Java Avançado");
        livro2.setValor(70.9);

        lista = new ArrayList<>();
        lista.add(livro1);
        lista.add(livro2);

        double soma = 0.0;

        for (Livro livro : lista) {
            soma += livro.getValor();
        }

        String somaFormatada = String.format("%.2f", soma);

        System.out.println(soma);
        JOptionPane.showMessageDialog(null, "Valor dos livros: R$ "+ somaFormatada);
    }

    public void carregaGUI() {
        modelo = new DefaultListModel();

        for (Livro livro : lista) {
            modelo.addElement(livro.getNome());
        }

        list1.setModel(modelo);
    }

    public LivroGUI() {
        carregaDados();
        carregaGUI();

        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeInput = JOptionPane.showInputDialog("Digite o nome do livro:");

                Livro livro = new Livro();
                livro.setNome(nomeInput);

                lista.add(livro);
                modelo.addElement(livro.getNome());
            }
        });
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este livro?");

                if(opcao == JOptionPane.YES_OPTION) {

                    int idx = list1.getSelectedIndex();
                    System.out.println(idx);

                    if(idx >= 0) {
                        lista.remove(idx);
                        modelo.remove(idx);
                    }
                }

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textFieldBuscar.getText();

                modelo.clear();

                if(texto.equals("")) {
                    for (Livro livro: lista) {
                        modelo.addElement(livro.getNome());
                    }
                } else {
                    for (Livro livro: lista) {
                        if(livro.getNome().toLowerCase().contains(texto.toLowerCase())) {
                            modelo.addElement(livro.getNome());
                        }
                    }
                }

            }
        });
    }
}
