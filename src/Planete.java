import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Planete {
    private String nom;
    private double x, y;
    private double vitesseX, vitesseY;
    private double masse;
    private double distanceAuSoleil; // Utilisé pour dessiner l'orbite
    private Color couleur;
    private Soleil soleil;
    private List<Lune> lunes;

    public Planete(String nom, double distanceAuSoleil, Color couleur, Soleil soleil, double masse, double vitesseInitiale) {
        this.nom = nom;
        this.soleil = soleil;
        this.masse = masse;
        this.distanceAuSoleil = distanceAuSoleil;
        this.couleur = couleur;
        this.lunes = new ArrayList<>();

        // Initial position
        this.x = soleil.getX() + distanceAuSoleil;
        this.y = soleil.getY();

        // Initial velocity for circular orbit
        this.vitesseX = 0;
        this.vitesseY = vitesseInitiale;
    }

    public double getMasse() {
        return masse;
    }

    public void ajouterLune(Lune lune) {
        this.lunes.add(lune);
    }

    public List<Lune> getLunes() {
        return lunes;
    }

    public Color getCouleur() {
        return couleur;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistanceAuSoleil() {
        return distanceAuSoleil;
    }

    public void updatePosition() {
        double distanceX = soleil.getX() - x;
        double distanceY = soleil.getY() - y;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        // Force of gravity
        double force = (6.67430e-11 * masse * soleil.getMasse()) / (distance * distance);

        // Acceleration
        double accelerationX = (force / masse) * (distanceX / distance);
        double accelerationY = (force / masse) * (distanceY / distance);

        // Update velocities
        vitesseX += accelerationX;
        vitesseY += accelerationY;

        // Update positions
        x += vitesseX;
        y += vitesseY;
    }
}
