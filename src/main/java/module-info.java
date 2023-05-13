module at.technikum.tourplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires org.mybatis;
    
    opens at.technikum.tourplanner to javafx.fxml;
    exports at.technikum.tourplanner;
}