import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        editora1.nome = "Companhia das Letras";
        editora1.telefone = "(11) 555-5555";
        editora1.cidade = "SP";
        editora1.estado = "SP";

        Editora editora2 = new Editora();
        editora2.nome = "FTD";
        editora2.telefone = "(11) 444-4444";
        editora2.cidade = "Boa Viagem";
        editora2.estado = "CE";

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
            String[] row = {editora.nome, editora.telefone, editora.cidade, editora.estado};
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
                        String[] row = {editora.nome, editora.telefone, editora.cidade, editora.estado};
                        modelo.addRow(row);
                    }
                } else {
                    for (Editora editora: lista) {
                        if(editora.nome.toLowerCase().contains(texto.toLowerCase())) {
                            String[] row = {editora.nome, editora.telefone, editora.cidade, editora.estado};
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
                editora.nome = nomeInput;

                lista.add(editora);

                String[] row = {editora.nome, editora.telefone, editora.cidade, editora.estado};
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
    }
}
