package ca.qc.bdeb.sim.animation;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Flocon {
    public static final Point2D VELOCITE_INITIALE = new Point2D(0, 100);

    // position = coin en haut à gauche du flocon
    protected Point2D position;
    protected Point2D taille;

    // Physique
    protected Point2D velocite = VELOCITE_INITIALE.add(new Point2D(Math.random() * 50 - 25, 0));
    protected Point2D acceleration = new Point2D(0, 200);

    protected Color color;

    public Flocon() {
        this(3, 3, Color.rgb(125, 190, 225));
    }

    public Flocon(double w, double h, Color color) {
        this.position = new Point2D(Math.random() * MainJavaFX.WIDTH, Math.random() * MainJavaFX.HEIGHT);
        this.taille = new Point2D(w, h);
        this.color = color;
    }

    public void update(double deltaTemps) {
        velocite = velocite.add(acceleration.multiply(deltaTemps));
        position = position.add(velocite.multiply(deltaTemps));

        // Si un flocon sort de l'écran
        if (position.getY() + taille.getY() > MainJavaFX.HEIGHT) {
            recommencer();
        }
    }

    public void recommencer() {
        // Déplace les flocons vers le haut
        position = new Point2D(Math.random() * MainJavaFX.WIDTH, -Math.random() * 30);
        velocite = VELOCITE_INITIALE.add(new Point2D(Math.random() * 50 - 25, 0));
    }

    public void draw(GraphicsContext context) {
        context.setFill(color);
        context.fillRect(
                position.getX(),
                position.getY(),
                taille.getX(),
                taille.getY());
    }
}
