package com.java360.pmanager.domain.repository;

import com.java360.pmanager.domain.entity.Task;
import com.java360.pmanager.domain.model.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    @Query("""
            SELECT t
              FROM Task t
             WHERE (t.project.id = :projectId OR :projectId IS NULL)
               AND (t.assignedMember.id = :memberId OR :memberId IS NULL)
               AND (t.status = :statusStr OR :statusStr IS NULL)
               AND (UPPER(t.title) LIKE CONCAT('%', UPPER(:partialTitle), '%') OR :partialTitle IS NULL)
            """)
//    List<Task> find(
//            @Param("projectId") String projectId,
//            @Param("memberId") String memberId,
//            @Param("statusStr") TaskStatus statusStr,
//            @Param("partialTitle") String partialTitle
//    );
    Page<Task> find(
            @Param("projectId") String projectId,
            @Param("memberId") String memberId,
            @Param("statusStr") TaskStatus statusStr,
            @Param("partialTitle") String partialTitle,
            Pageable pageable
    );

}
