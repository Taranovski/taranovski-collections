/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.collections.exceptions;

/**
 *
 * @author Oleksandr_Taranovsky
 */
public class MyIllegalArgumentException extends RuntimeException {

    /**
     *
     */
    public MyIllegalArgumentException() {
        super("my invalid argument exception");
    }
}
