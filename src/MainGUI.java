import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                JFrame jFrame = novaJanela("Biblioteca", autorGUI.getPanelMain());
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
        SwingUtilities.invokeLater(() -> new MainGUI());
    }

}
