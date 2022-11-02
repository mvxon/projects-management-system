package com.strigalev.projectsservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "employees", fetch = FetchType.LAZY)
    @Where(clause = "active")
    private Set<Project> workingProjects;

    @ManyToMany(mappedBy = "employees", fetch = FetchType.LAZY)
    @Where(clause = "active")
    private Set<Task> workingTasks;
}
