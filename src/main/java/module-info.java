module com.example.warb {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    requires jakarta.annotation;
    requires jakarta.persistence;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires eu.hansolo.tilesfx;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires spring.core;
    requires spring.aop;
    requires spring.beans;
    requires spring.expression;
    requires spring.data.jpa;
    requires java.persistence;
    requires org.hibernate.orm.core;


    opens com.example.warb to spring.core, spring.beans, spring.context, spring.data.jpa;
    opens com.example.warb.SpringConfiuartion to spring.core, spring.beans, spring.context, spring.data.jpa,org.hibernate.orm.core ;
    opens com.example.warb.Repositories to spring.core, spring.beans, spring.context, spring.data.jpa,org.hibernate.orm.core;
    opens com.example.warb.JPAEntities to spring.core, spring.beans, spring.context, spring.data.jpa,org.hibernate.orm.core;
    opens com.example.warb.FXMLControllers to spring.core, spring.beans, spring.context, spring.data.jpa,
             javafx.base, javafx.fxml, javafx.controls, javafx.graphics,org.hibernate.orm.core;
    exports com.example.warb;
    exports com.example.warb.FXMLControllers;
    exports com.example.warb.JPAEntities;
    exports com.example.warb.Repositories;


}