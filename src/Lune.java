import java.awt.Color;

public class Lune {
    private String nom;
    private double x, y;
    private double vitesseX, vitesseY;
    private double masse;
    private double distanceAPlanete; // Utilisé pour dessiner l'orbite
    private Color couleur;
    private Planete planete;

    public Lune(String nom, double distanceAPlanete, Color couleur, Planete planete, double vitesseInitiale) {
        this.nom = nom;
        this.planete = planete;
        this.masse = 7.34767309e22; // Masse par défaut pour une lune
        this.distanceAPlanete = distanceAPlanete;
        this.couleur = couleur;

        // Initial position
        this.x = planete.getX() + distanceAPlanete;
        this.y = planete.getY();

        // Initial velocity for circular orbit
        this.vitesseX = 0;
        this.vitesseY = vitesseInitiale;
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

    public double getDistanceAPlanete() {
        return distanceAPlanete;
    }

    public void updatePosition() {
        double distanceX = planete.getX() - x;
        double distanceY = planete.getY() - y;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        // Force of gravity
        double force = (6.67430e-11 * masse * planete.getMasse()) / (distance * distance);

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
