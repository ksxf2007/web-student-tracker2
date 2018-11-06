/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.web.jdbc;

import java.io.Serializable;

/**
 *
 * @author max
 */
public class Client extends Object implements Serializable{
    
    
    private String firstName;
    private String lastName;
   

    public Client() {
        firstName=null;
        lastName=null;
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

    

   

   
}
