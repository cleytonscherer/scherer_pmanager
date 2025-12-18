package com.java360.pmanager.domain.entity;

import com.java360.pmanager.domain.model.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "project")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String  id;

    @Column(name = "name", nullable = false, length = 100)
    private String  name;

    @Column(name = "description", nullable = false, length = 200)
    private String  description;

    @Column(name = "initial_date", nullable = false)
    private LocalDate   initialDate;

    @Column(name = "final_date", nullable = false)
    private LocalDate   finalDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectStatus   status;

    @ManyToMany
    @JoinTable(
            name = "project_member",
            joinColumns = @JoinColumn(name = "project_id"),
            foreignKey = @ForeignKey(name = "fk_project"),
            inverseJoinColumns = @JoinColumn(name = "member_id"),
            inverseForeignKey = @ForeignKey(name = "fk_member")
    )
    private List<Member> members;

    @OneToMany(mappedBy = "project", orphanRemoval = true)
    private List<Task> tasks;
}
