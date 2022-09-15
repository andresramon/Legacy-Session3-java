package org.craftedsw.tripservicekata.trip;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripServiceTest {

    @Test
    public void whenUserIsNotLoggedInThenExceptionIsThrown() {

        TripService tripService = new TripServiceUserTestDouble(null, null);
        assertThrows(UserNotLoggedInException.class, () -> {
                tripService.getTripsByUser(new User());
        });
    }

    @Test
    public void whenUserIsNotFriendOfLoggedUserThenTripListIsEmpty() {
        TripService tripService = new TripServiceUserTestDouble(new User(),
                Collections.singletonList(new Trip()));
        tripService.getTripsByUser(new User());

        Assertions.assertTrue(tripService.getTripsByUser(new User()).isEmpty());

    }

}
