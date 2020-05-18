package me.sathish.app.hireme.services;

import java.util.List;
import me.sathish.app.hireme.data.HiringUser;
import me.sathish.app.hireme.exceptions.HiringUserException;
import org.springframework.stereotype.Component;

@Component
public interface HiringService {
  public List<HiringUser> findAll();

  public void save(HiringUser hiringUser) throws HiringUserException;

  public HiringUser find(Long hiringUserID) throws HiringUserException;
}
