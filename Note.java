package ru.gb.example_hw_sem6.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "context", nullable = false)
    private String context;
    @Column(name = "local_date_time")
    private LocalDateTime localDateTime;

}
