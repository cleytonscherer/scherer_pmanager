package com.java360.pmanager.domain.applicationservice;

import com.java360.pmanager.domain.entity.Project;
import com.java360.pmanager.domain.exception.ProjectNotFoundException;
import com.java360.pmanager.domain.model.ProjectStatus;
import com.java360.pmanager.domain.repository.ProjectRepository;
import com.java360.pmanager.infrascructure.dto.SaveProjectDataDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

//    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);

    private final ProjectRepository projectRepository;

    @Transactional
    public Project createProject(SaveProjectDataDTO saveProjectData){
        Project project = Project.builder()
                .name(saveProjectData.getName())
                .description(saveProjectData.getDescription())
                .initialDate(saveProjectData.getInitialDate())
                .finalDate(saveProjectData.getFinalDate())
                .status(ProjectStatus.PENDING)
                .build();

        projectRepository.save(project);

//        System.out.println(project);
        log.info("Project created: {} ", project);

        return project;
    }

    public Project loadProject(String projectId) {
        return projectRepository
                .findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
    }

}
