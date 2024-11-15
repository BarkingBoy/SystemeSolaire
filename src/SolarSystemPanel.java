import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class SolarSystemPanel extends JPanel {
    private Soleil soleil;
    private List<Planete> planetes;
    private List<Asteroids> asteroids;

    public SolarSystemPanel() {
        // Initialisation du Soleil au centre de la fenêtre avec sa masse
        this.soleil = new Soleil("Soleil", 600, 400, 1.989e32); // Masse du Soleil en kg
        this.planetes = new ArrayList<>();
        this.asteroids = new ArrayList<>();

        // Création de quelques planètes avec leurs lunes
        Planete terre = new Planete("Terre", 200, Color.BLUE, soleil, 5.972e24, 29.78); // vitesse initiale en km/s
        terre.ajouterLune(new Lune("Lune", 20, Color.GRAY, terre, 1.022)); // vitesse initiale en km/s
        planetes.add(terre);

        Planete mars = new Planete("Mars", 300, Color.RED, soleil, 6.417e23, 24.07); // vitesse initiale en km/s
        mars.ajouterLune(new Lune("Phobos", 15, Color.LIGHT_GRAY, mars, 2.138)); // vitesse initiale en km/s
        mars.ajouterLune(new Lune("Deimos", 25, Color.DARK_GRAY, mars, 1.351)); // vitesse initiale en km/s
        planetes.add(mars);

        Planete jupiter = new Planete("Jupiter", 400, Color.ORANGE, soleil, 1.898e27, 13.07); // vitesse initiale en km/s
        jupiter.ajouterLune(new Lune("Io", 30, Color.YELLOW, jupiter, 17.334)); // vitesse initiale en km/s
        jupiter.ajouterLune(new Lune("Europa", 40, Color.CYAN, jupiter, 13.74)); // vitesse initiale en km/s
        planetes.add(jupiter);

        // Création des asteroids
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int startX = rand.nextInt(1200);
            int startY = rand.nextInt(800);
            Asteroids ast = new Asteroids("Ast" + i, 5, 5, rand.nextInt(5) + 1, startX, startY, Color.black);
            asteroids.add(ast);
        }

        // Démarrer l'animation des orbites et des astéroïdes
        Timer timer = new Timer(30, e -> {
            for (Planete planete : planetes) {
                planete.updatePosition(); // Mise à jour de la position de la planète
                for (Lune lune : planete.getLunes()) {
                    lune.updatePosition(); // Mise à jour de la position de la lune en fonction de la gravité
                }
            }
            for (Asteroids ast : asteroids) {
                ast.updatePosition(); // Mise à jour de la position des astéroïdes
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner le Soleil
        g.setColor(Color.YELLOW);
        g.fillOval(soleil.getX() - 20, soleil.getY() - 20, 40, 40);

        // Dessiner les planètes et leurs orbites
        for (Planete planete : planetes) {
            // Dessiner l'orbite de la planète
            g.setColor(Color.LIGHT_GRAY);
            g.drawOval((int) (soleil.getX() - planete.getDistanceAuSoleil()),
                    (int) (soleil.getY() - planete.getDistanceAuSoleil()),
                    (int) (planete.getDistanceAuSoleil() * 2),
                    (int) (planete.getDistanceAuSoleil() * 2));

            // Dessiner la planète elle-même
            g.setColor(planete.getCouleur());
            int x = (int) planete.getX();
            int y = (int) planete.getY();
            g.fillOval(x - 10, y - 10, 20, 20);

            // Dessiner les lunes et leurs orbites autour de la planète
            for (Lune lune : planete.getLunes()) {
                // Dessiner l'orbite de la lune
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - (int) lune.getDistanceAPlanete(),
                        y - (int) lune.getDistanceAPlanete(),
                        (int) lune.getDistanceAPlanete() * 2,
                        (int) lune.getDistanceAPlanete() * 2);

                // Dessiner la lune elle-même
                g.setColor(lune.getCouleur());
                int luneX = (int) lune.getX();
                int luneY = (int) lune.getY();
                g.fillOval(luneX - 5, luneY - 5, 10, 10);
            }
        }

        // Dessiner les astéroïdes
        for (Asteroids ast : asteroids) {
            g.setColor(ast.getCouleur());
            int astX = ast.getPositionDepartX();
            int astY = ast.getPositionDepartY();
            g.fillOval(astX - 3, astY - 3, 6, 6);
        }
    }
}
