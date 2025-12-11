package com.leoli.FunctionStore;

public class ColorStore {

    public String red(String string) {
        return "\u001B[31m" + string + "\u001B[0m";
    }

    public String green(String string) {
        return "\u001B[32m" + string + "\u001B[0m";
    }

    public String blue(String string) {
        return "\u001B[34m" + string + "\u001B[0m";
    }

    public String yellow(String string) {
        return "\u001B[33m" + string + "\u001B[0m";
    }

    public String purple(String string) {
        return "\u001B[35m" + string + "\u001B[0m";
    }

    public String cyan(String string) {
        return "\u001B[36m" + string + "\u001B[0m";
    }

    public String brightBlue(String string) {
        return "\033[94m" + string + "\033[0m";
    }



}
