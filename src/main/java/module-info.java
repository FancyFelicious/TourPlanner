module at.technikum.tourplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires org.mybatis;
    requires com.fasterxml.jackson.databind;

    opens at.technikum.tourplanner to javafx.fxml;
    opens at.technikum.tourplanner.playground to com.fasterxml.jackson.databind;
    exports at.technikum.tourplanner;
}