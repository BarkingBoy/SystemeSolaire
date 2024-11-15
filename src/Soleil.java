public class Soleil {
    private String nom;
    private int x;
    private int y;
    private double masse;

    public Soleil(String nom, int x, int y, double masse) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.masse = masse;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getMasse() {
        return masse;
    }

    public String getNom() {
        return nom;
    }
}
