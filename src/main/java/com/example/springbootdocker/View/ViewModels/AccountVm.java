package com.example.springbootdocker.View.ViewModels;

import com.example.springbootdocker.entitys.Message;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class AccountVm {
    int id;
    private String email;
    private List<Message> receivedMessages;
    private List<Message> sentMessages;
    private String firstName;
    private String lastName;
    private int age;
    private String type;
    private String password;

    public AccountVm(int id,String email, List<Message> receivedMessages, List<Message> sentMessages,String firstName,String lastName,int age) {
        this.id = id;
        this.email = email;
        this.receivedMessages = receivedMessages;
        this.sentMessages = sentMessages;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public AccountVm(String email,String firstName,String lastName,String type,String password) {
        this.email = email;
        this.receivedMessages = new ArrayList<>();
        this.sentMessages = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = -1;
        this.type = type;
        this.password = password;
    }

    public AccountVm() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountVm{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", receivedMessages=" + receivedMessages +
                ", sentMessages=" + sentMessages +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
