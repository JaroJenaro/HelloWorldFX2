package de.iav.helloworld.model;

import java.util.List;
import java.util.UUID;

public record Student(UUID uuid,
                      String firstName,
                      String lastName,
                      String email,
                      List<String> courseOfStudies) {

    @Override
    public String toString()
    {
        return uuid + ": " + firstName + " " + lastName + " " + courseOfStudies;
    }
}
