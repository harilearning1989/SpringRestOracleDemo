package com.example.demo.entity;

import javax.persistence.*;

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = Person.NamedQuery_MoveToHistory,
                procedureName = "MOVE_TO_HISTORY",
                parameters = {
                        @StoredProcedureParameter(type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(type = String.class, mode = ParameterMode.OUT),
                }
        ),
        @NamedStoredProcedureQuery(
                name = Person.NamedQuery_FetchFromHistory,
                procedureName = "FETCH_PERSON_HISTORY",
                resultClasses = Person.class,
                parameters = {
                        @StoredProcedureParameter(type = void.class, mode = ParameterMode.REF_CURSOR)
                }
        )})

@Entity
public class Person {
    public static final String NamedQuery_MoveToHistory = "moveToHistory";
    public static final String NamedQuery_FetchFromHistory = "fetchFromHistory";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERSON")
    @SequenceGenerator(sequenceName = "SQ_PERSON", allocationSize = 1, name = "SQ_PERSON")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Person create(String firstName, String lastName, String address) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}