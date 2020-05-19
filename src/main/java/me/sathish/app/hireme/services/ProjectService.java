package me.sathish.app.hireme.services;

import java.util.List;
import me.sathish.app.hireme.data.Project;
import org.springframework.stereotype.Component;

@Component
public interface ProjectService {

  List<Project> findAll();
}
