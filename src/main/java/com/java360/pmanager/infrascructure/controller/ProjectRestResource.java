package com.java360.pmanager.infrascructure.controller;

import com.java360.pmanager.infrascructure.dto.SaveProjectDataDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectRestResource {

    public void createProject(SaveProjectDataDTO saveProjectData) {

    }
}
