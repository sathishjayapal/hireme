package me.sathish.app.hireme.data;

import java.util.Date;
import lombok.Data;

@Data
public class Project {

  private Long projectID;
  private String projectName;
  private String projectPlatform;
  private String projectURL;
  private Date startDate;
  private Date tentativeEndDate;
  private Long hiringUserID;

  public Project(Long projectID, String projectName, String projectPlatform, String projectURL,
      Date startDate, Date tentativeEndDate) {
    this.projectID = projectID;
    this.projectName = projectName;
    this.projectPlatform = projectPlatform;
    this.projectURL = projectURL;
    this.startDate = startDate;
    this.tentativeEndDate = tentativeEndDate;
  }

}
