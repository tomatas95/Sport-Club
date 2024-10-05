package com.sportclubs.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// ^ getters / setters
@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
