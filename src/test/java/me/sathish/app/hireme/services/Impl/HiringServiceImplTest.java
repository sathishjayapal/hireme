package me.sathish.app.hireme.services.Impl;

import static org.junit.jupiter.api.Assertions.*;

import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import lombok.SneakyThrows;
import me.sathish.app.hireme.data.HiringUser;
import me.sathish.app.hireme.services.HiringService;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HiringServiceImplTest {

  @Autowired
  HiringService hiringService;
  Faker faker = Faker.instance ();

  @BeforeEach
  void setUp() {
  }

  @Test
  void findAll() {
    Iterable<HiringUser> collection = hiringService.findAll ();
    Assert.assertThat ("This is not empty List", collection,
        Matchers.<HiringUser>iterableWithSize (5));

  }

  @SneakyThrows
  @Test
  void save() {
    int size = hiringService.findAll ().size ();
    HiringUser user = new HiringUser (new Random ().nextLong (), faker.name ().fullName (),
        faker.internet ().emailAddress (),
        faker.internet ().url (), faker.twinPeaks ().character (), new Date ());
    hiringService.save (user);
    Assert.assertThat ("One record was added", size + 1,
        IsEqual.equalTo (hiringService.findAll ().size ()));
  }

  @SneakyThrows
  @Test
  void find() {
    HiringUser hiringUser= hiringService.find (new Long (1));
    Assert.assertThat ("The ID Value is matching", new Long(1), IsEqual.equalTo (hiringUser.getId ()));
  }
}
