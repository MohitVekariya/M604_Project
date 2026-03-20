package com.m604.expense_tracker.model; 

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data 
@Entity // 
@Table(name = "expenses") 
public class Expense {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate date;

    private String description;
}