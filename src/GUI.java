import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Téléchargement d'echocraft");
        JPanel panel = new JPanel();
        JButton button = new JButton("Télécharger et lancer");
        JLabel label = new JLabel("Java 11 est requis pour le lancement de l'application !");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DownloadSoftware.main();
            }
        });


        panel.add(button);
        frame.add(panel);
        panel.add(label);
        frame.setSize(400, 100);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("resources/logo.png");
        frame.setIconImage(icon.getImage());
    }
}
