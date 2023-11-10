package com.example.BashNaBash.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String address;
    private String ShortDescription;
    private String PhoneNumber;
    private String author;
    private String foto;
    private LocalDateTime CreatelocalDateTime;

    @PrePersist
    private void init() {
        CreatelocalDateTime = LocalDateTime.now();
    }
}
