package ca.qc.bdeb.sim.animation;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Grele extends Flocon {

    private boolean dejaRebondi;

    public Grele() {
        super(3, 4, Color.WHITE);
        dejaRebondi = false;
    }

    @Override
    public void update(double deltaTemps) {

        // FIXME : Code partiellement copié-collé...
        //  Avez-vous une idée d'amélioration?
        velocite = velocite.add(acceleration.multiply(deltaTemps));
        position = position.add(velocite.multiply(deltaTemps));

        // Si un flocon sort de l'écran
        if (position.getY() + taille.getY() > MainJavaFX.HEIGHT) {
            if (dejaRebondi) {
                recommencer();
                dejaRebondi = false;
            } else {
                dejaRebondi = true;

                // On ramène le flocon dans l'écran pour éviter le
                // glitch décrit dans les notes de cours!
                position = new Point2D(
                        position.getX(),
                        Math.clamp(position.getY(), 0, MainJavaFX.HEIGHT - taille.getY())
                );

                velocite = new Point2D(velocite.getX(), velocite.getY() * -0.3);
            }
        }
    }
}
