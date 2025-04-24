package org.example.bootjwtmaxex.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

@Entity
@Data
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @CreationTimestamp
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneOffset.UTC);

}
