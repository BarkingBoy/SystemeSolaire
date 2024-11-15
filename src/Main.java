import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Système Solaire 2D");

        // Assure-toi que le panneau de contenu de la JFrame est un conteneur de type JPanel
        SolarSystemPanel solarSystemPanel = new SolarSystemPanel();

        // Ajout du SolarSystemPanel dans le contenu de la JFrame
        frame.getContentPane().add(solarSystemPanel); // Utilisation de getContentPane().add(...)

        // Configuration de la fenêtre
        frame.setSize(1200, 800); // Augmentation de la taille de la fenêtre pour plus de visibilité
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
