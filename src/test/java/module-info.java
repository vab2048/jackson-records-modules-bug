open module com.example.demo.test {
    exports com.example.demo.test;

    requires com.example.demo;

    requires spring.boot.test;
    requires org.junit.jupiter.api;
    requires spring.beans;
    requires com.fasterxml.jackson.databind;

    requires org.assertj.core;
    requires net.bytebuddy;

}