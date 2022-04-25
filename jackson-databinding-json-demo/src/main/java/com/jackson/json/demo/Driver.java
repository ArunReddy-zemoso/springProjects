package com.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper= new ObjectMapper();

            Student student=mapper.readValue(new File("data/sample-full.json"),Student.class);

            System.out.println(student.getFirstName());
            System.out.println(student.getLastName());

            Address address=student.getAddress();

            System.out.println(address.getStreet());
            System.out.println(address.getCity());
            System.out.println(address.getState());

            for(String language:student.getLanguages()){
                System.out.println(language);
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
