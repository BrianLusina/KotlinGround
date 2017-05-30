package com.kotlinapp.kotlinintro.functions.defaultparams;
import com.kotlinapp.kotlinintro.functions.defaultparams.LoggerKt;

/**
 * @author lusinabrian on 30/05/17.
 */
public class Logger {

    public static void main(String[] args) {
        LoggerKt.logger("Hello from Java");
        LoggerKt.logger("Hello from Java overloaded", 5);
    }
}
