package com.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        apiService.fetchData();
        System.out.println("Retrieved fact: " + apiService.getData().getFacts());
    }
}
