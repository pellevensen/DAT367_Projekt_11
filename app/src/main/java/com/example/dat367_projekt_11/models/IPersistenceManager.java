package com.example.dat367_projekt_11.models;

public interface IPersistenceManager {
    void login(String email, String password);
    void register(String email, String password);
    void logOut();
    void writeNewHousehold(String id, String name, String email);

}