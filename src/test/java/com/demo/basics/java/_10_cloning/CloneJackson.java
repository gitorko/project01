package com.demo.basics.java._10_cloning;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class CloneJackson {

    @Test
    public void test() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
        AddressD address1 = new AddressD("Downing St 10");
        UserD user1 = new UserD("John", address1);
        ObjectMapper objectMapper = new ObjectMapper();
        UserD user2 = objectMapper.readValue(objectMapper.writeValueAsString(user1), UserD.class);

        user1.getAddress().street = "New Street";
        System.out.println(user1);
        System.out.println(user2);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class AddressD {
    String street;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class UserD {
    String name;
    AddressD address;

}
