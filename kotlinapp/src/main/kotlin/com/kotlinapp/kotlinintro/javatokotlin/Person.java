package com.kotlinapp.kotlinintro.javatokotlin;

import org.jetbrains.annotations.Nullable;

/**
 * @author lusinabrian on 28/05/17.
 */
public class Person {
    private String name;
    private int age;
    private Person partner;

    /**
     * Throws an exception when the name is NULL*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equals("")){
            throw new IllegalArgumentException("Name can not be null");
        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // adding this nullable annotation enables Kotlin to identify that this class has the
    // posibility of being NULL
    @Nullable
    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }
}
