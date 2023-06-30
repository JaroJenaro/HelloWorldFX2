module de.iav.helloworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    opens de.iav.helloworld to javafx.fxml;
    opens de.iav.helloworld.SceneBuilder to javafx.fxml;

    exports de.iav.helloworld;
    exports de.iav.helloworld.SceneBuilder;
    exports de.iav.helloworld.model;

}