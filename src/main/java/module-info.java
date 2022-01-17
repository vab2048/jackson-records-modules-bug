module com.example.demo {
    opens com.example.demo to spring.boot, spring.core;

    exports com.example.demo;

    requires java.annotation;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires spring.context;
    requires spring.core;


}