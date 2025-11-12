package com.java360.pmanager.infrascructure.controller;

import com.java360.pmanager.domain.applicationservice.ProjectService;
import com.java360.pmanager.domain.entity.Project;
import com.java360.pmanager.infrascructure.dto.ProjectDTO;
import com.java360.pmanager.infrascructure.dto.SaveProjectDataDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.java360.pmanager.infrascructure.controller.RestConstants.PATH_PROJECT;

@RestController
@RequestMapping(PATH_PROJECT)
@RequiredArgsConstructor
public class ProjectRestResource {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody @Valid SaveProjectDataDTO saveProjectData) {
        Project project = projectService.createProject(saveProjectData);
        return ResponseEntity
                .created(URI.create(PATH_PROJECT + "/" + project.getId()))
                .body(ProjectDTO.create(project));
    }
}
