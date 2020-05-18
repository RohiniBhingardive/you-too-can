package org.launchcode.youtoocan.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HelpCategory {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Category Name is required")
    @Size(min = 3, max = 100, message = "Category Name must be between 3 and 100 characters")
    private String categoryName;


    @OneToMany
    //@JoinColumn(name = "helpCategory_id")
    private List<HelpTopic> helpTopics = new ArrayList<HelpTopic>();

    public HelpCategory(){

    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
