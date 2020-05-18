package me.sathish.app.hireme.data;

import java.util.Date;
import lombok.Data;

@Data
public class HiringUser {
  private Long id;
  private String IdentifyNme;
  private String emailID;
  private String website;
  private String twitterHandle;
  private Date tentativeHiringDate;

  public HiringUser(Long i, String fullName, String emailAddress, String url, String character, Date tentativeHiringDate) {
    this.IdentifyNme=fullName;
    this.emailID=emailAddress;
    this.website=url;
    this.twitterHandle=character;
    this.tentativeHiringDate= tentativeHiringDate;
    this.id=i;
  }
}
