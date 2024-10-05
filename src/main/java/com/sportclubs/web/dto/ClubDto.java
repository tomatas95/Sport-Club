package com.sportclubs.web.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class ClubDto {
    private Long id;
    @NotEmpty(message = "Name should not be empty.")
    @Size(min = 4, message = "Name should have at least 4 characters.")
    @Pattern(regexp="[a-zA-Z]+", message="Name must contain only letters.")
    private String name;
    @NotEmpty(message = "Surname should not be empty.")
    @Size(min = 4, message = "Surname should have at least 4 characters.")
    @Pattern(regexp="[a-zA-Z]+", message="Name must contain only letters.")
    private String surname;
    @NotEmpty(message = "Email should not be empty.")
    @Email(message = "Invalid email format.")
    private String email;
    @NotEmpty(message = "Phone should not be empty.")
    @Pattern(regexp="[0-9]+", message="Phone number must contain only digits.")
    private String phone;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
