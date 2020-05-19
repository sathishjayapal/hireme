package me.sathish.app.hireme.services;

import java.util.List;
import me.sathish.app.hireme.data.HiringUser;
import me.sathish.app.hireme.exceptions.HiringUserException;
import org.springframework.stereotype.Component;

@Component
public interface HiringService {

  List<HiringUser> findAll();

  void save(HiringUser hiringUser) throws HiringUserException;

  HiringUser find(Long hiringUserID) throws HiringUserException;
}
