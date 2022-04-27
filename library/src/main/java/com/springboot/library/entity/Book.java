package com.springboot.library.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author;
    @Column(name = "category")
    private String category;

    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "student_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> persons;

    public Book(){}

    public Book(String title, String description, String author, String category) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        if(persons==null){
            persons = new ArrayList<>();
        }
        persons.add(person);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
