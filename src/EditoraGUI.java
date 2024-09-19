import models.Editora;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EditoraGUI {
    private JPanel mainPanel;
    private JTable tbEditora;
    private JButton inserirButton;
    private JButton removerButton;
    private JTextField tfBuscar;
    private JButton buscarButton;

    public ArrayList<Editora> lista;
    private DefaultTableModel modelo;

    public JPanel getPanelMain() {
        return mainPanel;
    }

    public void carregaDados() {
        Editora editora1 = new Editora();
        editora1.setNome("Companhia das Letras");
        editora1.setTelefone("(11) 555-5555");
        editora1.setEndereco("Teste");
        editora1.setCidade("SP");
        editora1.setEstado("SP");
        editora1.setCep("32000-666");

        Editora editora2 = new Editora();
        editora2.setNome("FTD");
        editora2.setTelefone("(11) 444-4444");
        editora2.setEndereco("BR020 KM 100");
        editora2.setCidade("Boa Viagem");
        editora2.setEstado("CE");
        editora2.setCep("60111-555");

        lista = new ArrayList<>();
        lista.add(editora1);
        lista.add(editora2);
    }

    public void carregaGUI() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Telefone");
        modelo.addColumn("Cidade");
        modelo.addColumn("UF");

        for (Editora editora : lista) {
            String[] row = {editora.getNome(), editora.getTelefone(), editora.getCidade(), editora.getEstado()};
            modelo.addRow(row);
        }

        tbEditora.setModel(modelo);
    }

    public EditoraGUI() {
        carregaDados();
        carregaGUI();

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = tfBuscar.getText();

                for (int i = 0; i < modelo.getRowCount(); i++) {
                    modelo.removeRow(i);
                }

//                tbEditora.repaint();
//                tbEditora.revalidate();

                if(texto.equals("")) {
                    for (Editora editora: lista) {
                        String[] row = {editora.getNome(), editora.getTelefone(), editora.getCidade(), editora.getEstado()};
                        modelo.addRow(row);
                    }
                } else {
                    for (Editora editora: lista) {
                        if(editora.getNome().toLowerCase().contains(texto.toLowerCase())) {
                            String[] row = {editora.getNome(), editora.getTelefone(), editora.getCidade(), editora.getEstado()};
                            modelo.addRow(row);
                        }
                    }
                }
            }
        });
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeInput = JOptionPane.showInputDialog("Digite o nome do livro:");

                Editora editora = new Editora();
                editora.setNome(nomeInput);

                lista.add(editora);

                String[] row = {editora.getNome(), editora.getTelefone(), editora.getCidade(), editora.getEstado()};
                modelo.addRow(row);
            }
        });
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta editora?");

                if(opcao == JOptionPane.YES_OPTION) {
                    int idx = tbEditora.getSelectedRow();
                    System.out.println(idx);

                    if(idx >= 0) {
                        lista.remove(idx);
                        modelo.removeRow(idx);
                    }
                }

            }
        });

        tbEditora.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    Editora editoraClicada = lista.get(row);
                    String endCompleto = editoraClicada.getEnderecoCompleto();

                    JOptionPane.showMessageDialog(null, endCompleto);
                }
            }
        });
    }
}
