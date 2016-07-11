package com.jovannypcg.daggerusage.model;

/**
 * Represents a user and contains attributes like:
 *
 * - Name
 * - Age
 * - email
 *
 * @version 1.0.
 */
public class User {
    /**
     * The name of the user.
     */
    private String name;

    /**
     * The age of the user.
     */
    private int age;

    /**
     * The email of the user.
     */
    private String email;

    /**
     * Constructor.
     *
     * @param name The name of the user.
     * @param age The age of the user.
     * @param email The email of the user.
     */
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    /**
     * Constructor
     */
    public User() {}

    /**
     * Gets the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * @param name The name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the user.
     * @return The age of the user.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the user.
     * @param age The age of the user.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the email of the user.
     * @return The age of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     * @param email The email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
