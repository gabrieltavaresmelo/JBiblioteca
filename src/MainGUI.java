import dao.AlunoDao;
import models.Aluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI {

    private JFrame novaJanela(String titulo, JPanel panel) {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(panel);
        jFrame.setTitle(titulo);
        jFrame.setSize(600, 400);
        jFrame.setVisible(true);

        return jFrame;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuArquivo = new JMenu("Arquivo");

        JMenuItem menuItemAutor = new JMenuItem("Autores");
        menuItemAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AutorGUI3 autorGUI = new AutorGUI3();
                JFrame jFrame = novaJanela("Autores", autorGUI.getPanelMain());
            }
        });

        JMenuItem menuItemEditora = new JMenuItem("Editora");
        menuItemEditora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditoraGUI editoraGUI = new EditoraGUI();
                JFrame jFrame = novaJanela("Editora", editoraGUI.getPanelMain());
            }
        });

        JMenuItem menuItemSair = new JMenuItem("Sair");
        menuItemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuArquivo.add(menuItemAutor);
        menuArquivo.add(menuItemEditora);
        menuArquivo.add(menuItemSair);

        menuBar.add(menuArquivo);

        return menuBar;
    }

    public MainGUI() {
        LivroGUI livroGUI = new LivroGUI();

        JFrame jFrame = novaJanela("Biblioteca", livroGUI.getPanelMain());
        jFrame.setJMenuBar(createMenuBar());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

//        AlunoDao alunoDAO = new AlunoDao();
//        ArrayList<Aluno> alunos = alunoDAO.listar();
//
//        for (Aluno aluno : alunos) {
//            System.out.println(aluno.getId() + " - " + aluno.getNome());
//        }
//
//        ArrayList<Aluno> alunosJose = alunoDAO.buscarPorNome("josé");
//
//        for (Aluno aluno : alunosJose) {
//            System.out.println(aluno.getId() + " - " + aluno.getNome());
//        }
//
//        Aluno aluno1 = alunoDAO.buscar(1);
//        System.out.println(aluno1.getId() + " - " + aluno1.getNome());

        SwingUtilities.invokeLater(() -> new MainGUI());
    }

}
