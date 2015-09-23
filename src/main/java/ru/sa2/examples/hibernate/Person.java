package ru.sa2.examples.hibernate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alexander Smirnov (AlVyaSmirnov) on 22.09.2015.
 * email: asmirnov@vrn.beeline.ru
 */

@Entity
@Table(name = "persons", schema = "hibernatetest")
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString(){
        return "Person:\t" + id + ", " + firstName + ", " + lastName;
    }
}
