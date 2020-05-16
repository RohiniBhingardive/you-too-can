package org.launchcode.youtoocan.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HelpUser {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "First Name is required")
    @Size(min = 3, max = 100, message = "Category Name must be between 3 and 100 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Size(min = 3, max = 100, message = "Category Name must be between 3 and 100 characters")
    private String lastName;


    @OneToMany
    @JoinColumn(name = "helpuser_id")
    private List<HelpTopic> helperTopics = new ArrayList<HelpTopic>();

    public HelpUser() {

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
