package me.sathish.app.hireme.services.Impl;

import com.github.javafaker.Faker;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import me.sathish.app.hireme.data.HiringUser;
import me.sathish.app.hireme.data.Project;
import me.sathish.app.hireme.services.HiringService;
import me.sathish.app.hireme.services.ProjectService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectServiceImpl implements ProjectService {

  private static List<Project> projectList = new ArrayList<> ();
  private static Faker faker = Faker.instance ();

  static {
    for (long i = 1; i < 10; i++) {
      Project project = new Project (i, faker.harryPotter ().spell (),
          faker.programmingLanguage ().name (), faker.internet ().url (), faker.date ().between (
          Date.valueOf (LocalDate.now ().minusYears (2)), Date.valueOf (LocalDate.now ())),
          faker.date ().between (
              Date.valueOf (LocalDate.now ().minusDays (2)), Date.valueOf (LocalDate.now ())));
      projectList.add (project);
    }
  }

  @Autowired
  HiringService hiringService;

  public List<Project> findAll() {
    List<HiringUser> hiringUserList = hiringService.findAll ();
    int count = hiringUserList.size ();

    projectList.stream ().forEach (data -> {
      Long someLong = RandomUtils.nextLong (0, count);
      Long id = hiringUserList.stream ()
          .filter (data1 -> data1.getId ().equals (someLong)).findFirst ().get ()
          .getId ();
      data.setHiringUserID (id);
    });
    return projectList;
  }
}
