import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AutorGUI3 extends javax.swing.JFrame {

    private JPanel mainPanel;
    private JButton adicionarButton;
    private JButton removerButton;
    private JTextField textField1;
    private JButton buscarButton;
    private JList<String> list1;

    public ArrayList<Autor> lista;
    public DefaultListModel modelo;

    public JPanel getPanelMain() {
        return mainPanel;
    }

    public void carregaDados() {
        Autor autor1 = new Autor();
        autor1.nome = "Gabriel";
        autor1.email = "gabriel@gmail.com";
        autor1.telefone = "(85) 8899-7788";

        Autor autor2 = new Autor();
        autor2.nome = "Maria";
        autor2.email = "maria@gmail.com";
        autor2.telefone = "(85) 5599-7788";

        lista = new ArrayList<>();
        lista.add(autor1);
        lista.add(autor2);
    }

    public void carregaGUI() {
        modelo = new DefaultListModel();

        for (Autor autor : lista) {
            modelo.addElement(autor.nome);
        }

        list1.setModel(modelo);
    }

    public AutorGUI3() {
        carregaDados();
        carregaGUI();

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeInput = JOptionPane.showInputDialog("Digite o nome do autor:");

                Autor a = new Autor();
                a.nome = nomeInput;

                lista.add(a);
                modelo.addElement(a.nome);
            }
        });
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este autor?");

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
                String texto = textField1.getText();

                modelo.clear();

                if(texto.equals("")) {
                    for (Autor autor: lista) {
                        modelo.addElement(autor.nome);
                    }
                } else {
                    for (Autor autor: lista) {
                        if(autor.nome.toLowerCase().contains(texto.toLowerCase())) {
                            modelo.addElement(autor.nome);
                        }
                    }
                }

            }
        });
    }

}
