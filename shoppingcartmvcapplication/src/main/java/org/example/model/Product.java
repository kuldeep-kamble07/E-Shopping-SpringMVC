package org.example.model;

import lombok.Data;
import org.example.Enum.Category;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;


private String name;
private double price;

private int quantity;

@Enumerated(EnumType.STRING)
private Category category;

private String  expiryDate;

    @ManyToOne()
    private Cart cart;


}
