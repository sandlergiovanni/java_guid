/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.itaupersonnalite.fw;

import java.util.Random;
import java.util.UUID;

/**
 * @author Tuerê Pinto
 */
public class Guid {

    private static Guid guidFactory = new Guid();
    static Random random = new Random();

    public static String getString(int position) {
        String guid = "";
        switch (position) {
            case 22:
                guid = getString22();
                break;
            case 36:
                guid = getString36();
                break;
        }
        return guid;
    }

    protected static String getString36() {
        return UUID.randomUUID().toString();
    }

    protected static String getString22() {
        return guidFactory.getGuidString().toUpperCase();
    }

    protected String getGuidString() {
        long rand = (random.nextLong() & 0x7FFFFFFFFFFFFFFFL) |
                0x4000000000000000L;
        return Long.toString(rand, 32) +
                Long.toString(System.currentTimeMillis() & 0xFFFFFFFFFFFFFL, 32);
    }

}
