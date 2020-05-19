package me.sathish.app.hireme.controller;

import java.util.List;
import me.sathish.app.hireme.data.Project;
import me.sathish.app.hireme.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectResourceController {

  private final ProjectService projectService;

  @Autowired
  public ProjectResourceController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @GetMapping("/allProjects")
  public List<Project> getAllProjects() {
    return projectService.findAll ();
  }
}
