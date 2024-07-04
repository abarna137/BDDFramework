package com.datagenerator;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class TestDataGenerator {
    private static Faker javaFaker = new Faker();

    public static Map<String,String> generateUsernamePassword() {
        Map<String, String> userMap = new HashMap<>();
        userMap.put(javaFaker.name().username(), javaFaker.internet().password(8,11));
        return userMap;
    }

    public static CustomerDetails generateCustomerDetails() {
        CustomerDetails customer = new CustomerDetails();
        customer.firstName=javaFaker.name().firstName();
        customer.lastName=javaFaker.name().lastName();
        customer.addressStreet=javaFaker.address().streetAddress();
        customer.addressCity=javaFaker.address().city();
        customer.addressState=javaFaker.address().state();
        customer.addressZipcode=javaFaker.address().zipCode();
        customer.phoneNumber=javaFaker.phoneNumber().toString();
        customer.ssnNumber=javaFaker.regexify("[A-Z]{9}");
        customer.username=customer.firstName+customer.lastName+javaFaker.regexify("[0-9]{4}");
        customer.password=javaFaker.internet().password(8,11);
        return customer;
    }
}
