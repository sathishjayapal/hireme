package me.sathish.app.hireme.controller;

import java.net.URI;
import java.util.List;
import me.sathish.app.hireme.data.HiringUser;
import me.sathish.app.hireme.exceptions.HiringUserException;
import me.sathish.app.hireme.services.HiringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class HiringResourceController {

  @Autowired
  HiringService hiringService;

  @GetMapping("/hiringUser/allRecruiters")
  public List<HiringUser> getAllHiringUsers() {
    return hiringService.findAll ();
  }

  @GetMapping("/hiringUser/{id}")
  public HiringUser getHiringUser(@PathVariable Long id) throws HiringUserException {
    return hiringService.find (id);
  }

  @PostMapping("/hiringUser")
  public ResponseEntity<HiringUser> getHiringUser(@RequestBody HiringUser hiringUser) throws HiringUserException {
    hiringService.save (hiringUser);

    URI returnURI = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}")
        .buildAndExpand (hiringUser.getId ()).toUri ();
    return ResponseEntity.created (returnURI).build ();
  }
}
