module ca.qc.bdeb.sim.animation {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.qc.bdeb.sim.animation to javafx.fxml;
    exports ca.qc.bdeb.sim.animation;
}