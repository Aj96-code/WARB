module com.example.warb {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javassist;
    requires java.management;
    requires java.base;
    requires java.net.http;
    requires jdk.internal.opt;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires spring.core;
    requires spring.aop;
    requires spring.beans;
    requires spring.jcl;
    requires spring.expression;
    requires spring.messaging;
    requires spring.retry;
    requires spring.tx;
    requires spring.test;
    requires spring.data.jpa;
    requires java.persistence;
    requires java.sql;
    requires java.xml.bind;
    requires java.naming;
    requires java.se;
    requires com.sun.istack.runtime;
    requires com.sun.xml.bind;
    requires com.sun.xml.fastinfoset;
    requires com.sun.jna;
    requires com.sun.jna.platform;
    requires com.sun.xml.txw2;
    requires net.bytebuddy;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;

    opens com.example.warb to spring.core, spring.beans, spring.context, spring.data.jpa;
    opens com.example.warb.SpringConfiuartion to spring.core, spring.beans, spring.context, spring.data.jpa;
    opens com.example.warb.Repositories to spring.core, spring.beans, spring.context, spring.data.jpa;
    opens com.example.warb.JPAEntities to  spring.core, spring.beans, spring.context, spring.data.jpa;
    opens com.example.warb.FXMLControllers to javafx.fxml,spring.core, spring.beans, spring.context, spring.data.jpa ;
    exports com.example.warb;
    exports com.example.warb.FXMLControllers;
    exports com.example.warb.JPAEntities;
    exports com.example.warb.Repositories;

}