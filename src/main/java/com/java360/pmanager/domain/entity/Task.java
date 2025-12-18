package com.java360.pmanager.domain.entity;

import com.java360.pmanager.domain.model.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String  id;

    @Column(name = "title", nullable = false, length = 100)
    private String  title;

    @Column(name = "description", nullable = false, length = 200)
    private String  description;

    @Column(name = "number_of_days", nullable = false)
    private Integer numberOfDays;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus  status;

    @ManyToOne
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "fk_task_project"))
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assigned_member", foreignKey = @ForeignKey(name = "fk_task_member"))
    private Member assignedMember;
}
