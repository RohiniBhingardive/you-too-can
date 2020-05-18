package org.launchcode.youtoocan.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class HelpTopic {

    @Id
    @GeneratedValue
    private int id;


    @ManyToOne
    private HelpCategory category;

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters")
    private String title;

    private String description;

    //@NotBlank(message = "Zip code is required")
    //@Size(min = 5, max = 5, message = "Zip code must be 5 digits")
    //@NotNull
    private int zipCode;

    @Email
    private String helperUser;

    @Email
    private String needyUser;

    public int getId() {

        return id;
    }

    public HelpCategory getCategory() {
        return category;
    }

    public void setCategory(HelpCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getHelperUser() {
        return helperUser;
    }

    public void setHelperUser(String helperUser)
    {

        this.helperUser = helperUser;
    }


    public String getNeedyUser() {
        return needyUser;
    }

    public void setNeedyUser(String needyUser) {
        this.needyUser = needyUser;
    }



}
