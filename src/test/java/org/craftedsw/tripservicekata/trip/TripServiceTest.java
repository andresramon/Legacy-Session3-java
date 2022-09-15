package org.craftedsw.tripservicekata.trip;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripServiceTest{

    @Test
    public void whenUserIsNotLoggedInThenExceptionIsThrown(){

        TripService tripService = new TripServiceUserTestDouble(null, null);
        assertThrows(UserNotLoggedInException.class, () -> {
            tripService.getTripsByUser(new User());
        });
    }

    @Test
    public void whenUserIsNotFriendOfLoggedUserThenTripListIsEmpty(){
        TripService tripService = new TripServiceUserTestDouble(new User(), Collections.singletonList(new Trip()));
        tripService.getTripsByUser(new User());

        Assertions.assertTrue(tripService.getTripsByUser(new User()).isEmpty());

    }

    @Test
    public void whenUserIsFriendOfLoggedUserThenTripListIsNotEmpty(){

        User user = new User();
        User loggedUser = new User();
        user.addFriend(loggedUser);

        final List<Trip> trips = Collections.singletonList(new Trip());
        TripService tripService = new TripServiceUserTestDouble(loggedUser, trips);

        List<Trip> userTrips = tripService.getTripsByUser(user);

        Assertions.assertSame(trips, userTrips);

    }

    @Test
    public void whenUserHasFriendsButLoggedUserIsNotFriend(){

        User user = new User();
        User loggedUser = new User();
        user.addFriend(new User());

        final List<Trip> trips = Collections.singletonList(new Trip());
        TripService tripService = new TripServiceUserTestDouble(loggedUser, trips);

        Assertions.assertTrue(tripService.getTripsByUser(user).isEmpty());
    }

}
