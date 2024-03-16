package com.dixie.error.item02;

import lombok.Getter;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2024/3/16 12:52
 */
public class Data {

    @Getter
    private static int counter = 0;

    public static int reset() {
        counter = 0;
        return counter;
    }
    public synchronized void wrong() {
        counter++;
    }

    private static Object locker = new Object();
    public void right() {
        synchronized (locker) {
            counter++;
        }
    }
}
