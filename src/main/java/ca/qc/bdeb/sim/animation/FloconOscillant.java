package ca.qc.bdeb.sim.animation;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class FloconOscillant extends Flocon {
    private double tempsTotalEcoule = 0;
    private double xCentre;

    public FloconOscillant() {
        super(2, 2, Color.GRAY);
        this.xCentre = position.getX();

        // Évite de synchroniser tous les flocons avec exactement la
        // même oscillation en même temps
        this.tempsTotalEcoule = Math.random() * 10;
    }

    @Override
    public void update(double deltaTemps) {
        // TODO : code dupliqué ici... Avez-vous une meilleure idée?
        velocite = velocite.add(acceleration.multiply(deltaTemps));
        position = position.add(velocite.multiply(deltaTemps));

        // Si un flocon sort de l'écran
        if (position.getY() + taille.getY() > MainJavaFX.HEIGHT) {
            // Déplace les flocons vers le haut
            recommencer();
        }

        tempsTotalEcoule += deltaTemps;
        position = new Point2D(
                xCentre + 5 * Math.sin(10 * tempsTotalEcoule),
                position.getY()
        );
    }
}
