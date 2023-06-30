package de.iav.helloworld.model;

import java.util.List;

public record Student(String secureID,
                      String firstName,
                      String lastName,
                      String email,
                      List<String> courseOfStudies) {

    @Override
    public String toString()
    {
        return secureID + ": " + firstName + " " + lastName + " " + courseOfStudies;
    }
}
