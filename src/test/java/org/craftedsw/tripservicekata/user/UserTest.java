package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {


    @Test
    public void whenUserIsFriendShouldReturnTrue(){
        User user = new User();
        User userFriend = new User();
        user.addFriend(userFriend);

        Assertions.assertTrue(user.isFriend(userFriend));
    }

    @Test
    public void whenUserIsNotFriendShouldReturnFalse(){
        User user = new User();
        User userFriend = new User();
        User otherUser = new User();
        user.addFriend(userFriend);

        Assertions.assertFalse(user.isFriend(otherUser));
    }

    @Test
    public void whenUserHasNotFriendShouldReturnFalse(){
        User user = new User();
        User otherUser = new User();

        Assertions.assertFalse(user.isFriend(otherUser));
    }

}
