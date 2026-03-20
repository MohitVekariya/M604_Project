package com.m604.expense_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ExpenseTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseTrackerApplication.class, args);
    }

    @EventListener({ApplicationReadyEvent.class})
    public void launchBrowser() {
        System.out.println("Server is ready! Launching browser...");
        try {
            new ProcessBuilder("cmd", "/c", "start", "http://localhost:8080").start();
            
        } catch (Exception e) {
            System.out.println("Could not auto-launch browser. Please open http://localhost:8080 manually.");
        }
    }
}