package com.example.demo.test;

import com.example.demo.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    record Dog(String name, int age) {}

    <T> void serialiseDeserialize(T item, Class<T> cls) {
        // Given: an item

        // When: We attempt to serialize and deserialize it.
        assertThatCode(() -> {
            String json = objectMapper.writeValueAsString(item);
            objectMapper.readValue(json, cls);
        })
                // Then: it does not throw...
                .doesNotThrowAnyException();

    }

    @Test
    void serialiseDeserialize_WithLocalRecord_ShouldSucceed() {
        Dog dog = new Dog("Fido", 2);
        serialiseDeserialize(dog, Dog.class);
    }


    @Test
    void serialiseDeserialize_WithRecordInOtherModule_ShouldSucceed() {
        Cat cat = new Cat("Felix", 3);
        serialiseDeserialize(cat, Cat.class);
    }


}
