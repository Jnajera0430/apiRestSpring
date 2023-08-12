package com.api.restApi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String name;
    private String documentType;
    private Integer identity;
    private Integer edad;
    private Integer priority;
    private boolean state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public boolean getState(){
        return state;
    }

    public void setState(boolean state){
        this.state = state;
    }

    public void deleteUser(){
        setState(false);
    }

    public void updateUser(UserModel user){
        setName(user.getName());
        setDocumentType(user.getDocumentType());
        setIdentity(user.getIdentity());
        setEdad(user.getEdad());
        setPriority(user.getPriority());
    }
}
