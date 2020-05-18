package me.sathish.app.hireme.services.Impl;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import me.sathish.app.hireme.data.HiringUser;
import me.sathish.app.hireme.exceptions.HiringUserException;
import me.sathish.app.hireme.services.HiringService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

@Component
public class HiringServiceImpl implements HiringService {

  public static List<HiringUser> hiringUserList = new ArrayList<HiringUser> ();
  static final Faker faker = Faker.instance ();

  static {
    for (int i = 0; i < 5; i++) {
      hiringUserList.add (
          new HiringUser (new Long (i), faker.name ().fullName (),
              faker.internet ().emailAddress (),
              faker.internet ().url (), faker.twinPeaks ().character (), new Date ()));
    }
  }

  public List<HiringUser> findAll() {
    return hiringUserList;
  }

  public void save(HiringUser hiringUser) throws HiringUserException {
    if (hiringUser.getIdentifyNme () == null|| hiringUserList.size () > 20 ) {
      throw new HiringUserException ("Hiring user queue exceeded. Please try later.");
    } else {
      hiringUser.setId (RandomUtils.nextLong (1000L,20000L));
      hiringUserList.add (hiringUser);
    }
  }

  public HiringUser find(Long hiringUserID) throws HiringUserException {
    Optional<HiringUser> hiringUser = hiringUserList.stream ()
        .filter (data -> data.getId ().equals (hiringUserID)).findFirst ();
    if (hiringUser.isPresent ()) {
      return hiringUser.get ();
    } else {
      throw new HiringUserException ("User not found");
    }
  }
}
