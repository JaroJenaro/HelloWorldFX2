package de.iav.helloworld.model;

import java.util.List;

public record Student(String firstName,
                      String lastName,
                      String email,
                      List<String> courseOfStudies) {
}
