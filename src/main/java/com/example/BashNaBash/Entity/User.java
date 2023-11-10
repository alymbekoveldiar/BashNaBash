package com.example.BashNaBash.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Table(name = "Account_details")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gmail")
    private String gmail;
    @Column(name = "password")
    private String password;
    @Column(name = "namber_phone")
    private String namberPhone;
    @Column(name = "AmountOfDeals")
    private int AmountOfDeals;
}
