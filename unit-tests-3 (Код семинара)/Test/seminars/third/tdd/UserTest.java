package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    public void testUserAuthenticate(){
        User firstUser = new User("Гном Гномыч", "qwerty", true);
        assertThat(firstUser.authenticate("Гном Гномыч", "qwerty")).isTrue();
    }
    @Test
    public void testUnregisterUserAuthenticate(){
        User unknownUser = new User("Паханский", "QWERTY", false);
        assertThat(unknownUser.authenticate("Паханский", "qWERTY")).isFalse();
    }
    @Test
    public void testUserDatabaseAdding(){
        UserRepository userRepository = new UserRepository();
        User firstUser = new User("Гном Гномыч", "qwerty", true);
        User secondUser = new User("Паханский", "QWERTY", false);
        User thirdUser = new User("Гуф", "LuGang", false);

        firstUser.authenticate("Гном Гномыч", "qwerty");
        secondUser.authenticate("Паханский", "QWERTY");
        thirdUser.authenticate("Гуф", "LUGang");
        userRepository.addUser(firstUser);
        userRepository.addUser(secondUser);
        userRepository.addUser(thirdUser);

        assertThat(userRepository.findByName(firstUser.name)).isTrue();
        assertThat(userRepository.findByName(secondUser.name)).isTrue();
        assertThat(userRepository.findByName(thirdUser.name)).isFalse();
    }

    @Test
    public void logOutTest(){
        UserRepository userRepository = new UserRepository();
        User firstUser = new User("Гном Гномыч", "qwerty", true);
        User secondUser = new User("Паханский", "QWERTY", false);
        User thirdUser = new User("Гуф", "LuGang", false);

        firstUser.authenticate("Гном Гномыч", "qwerty");
        secondUser.authenticate("Паханский", "QWERTY");
        thirdUser.authenticate("Гуф", "LuGang");
        userRepository.addUser(firstUser);
        userRepository.addUser(secondUser);
        userRepository.addUser(thirdUser);
        userRepository.logOutAll();


        assertTrue(userRepository.findByName("Паханский"));
    }
}