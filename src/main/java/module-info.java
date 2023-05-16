module org.fancylynx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires org.mybatis;
    requires com.fasterxml.jackson.databind;
    requires lombok;

    opens org.fancylynx to javafx.fxml;
    opens org.fancylynx.playground to com.fasterxml.jackson.databind;

    exports org.fancylynx;
}