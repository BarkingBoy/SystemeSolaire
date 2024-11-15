import java.awt.*;
import java.util.Random;

public class Asteroids {
    private String nom;
    private int radius;
    private int mass;
    private int vitesse;
    private int positionDepartX;
    private int positionDepartY;
    private int dx; // Direction de mouvement en X
    private int dy; // Direction de mouvement en Y
    private Color couleur;
    private static final Random rand = new Random();

    public Asteroids(String nom, int radius, int mass, int vitesse, int positionDepartX, int positionDepartY, Color couleur) {
        this.nom = nom;
        this.radius = radius;
        this.mass = mass;
        this.vitesse = vitesse;
        this.positionDepartX = positionDepartX;
        this.positionDepartY = positionDepartY;
        this.couleur = couleur;
        this.dx = rand.nextInt(3) - 1; // -1, 0, ou 1 pour un mouvement aléatoire en X
        this.dy = rand.nextInt(3) - 1; // -1, 0, ou 1 pour un mouvement aléatoire en Y
        // Assurez-vous que l'astéroïde ne reste pas statique en ayant dx et dy à 0
        if (dx == 0 && dy == 0) {
            dx = 1; // Mouvement par défaut
        }
    }

    public void updatePosition() {
        positionDepartX += dx * vitesse;
        positionDepartY += dy * vitesse;

        // Repositionner les astéroïdes pour qu'ils restent dans la fenêtre
        if (positionDepartX < 0) {
            positionDepartX = 1200;
        } else if (positionDepartX > 1200) {
            positionDepartX = 0;
        }

        if (positionDepartY < 0) {
            positionDepartY = 800;
        } else if (positionDepartY > 800) {
            positionDepartY = 0;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getPositionDepartX() {
        return positionDepartX;
    }

    public void setPositionDepartX(int positionDepartX) {
        this.positionDepartX = positionDepartX;
    }

    public int getPositionDepartY() {
        return positionDepartY;
    }

    public void setPositionDepartY(int positionDepartY) {
        this.positionDepartY = positionDepartY;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
