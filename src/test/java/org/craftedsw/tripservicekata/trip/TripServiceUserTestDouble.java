package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;
import org.craftedsw.tripservicekata.user.User;

public class TripServiceUserTestDouble extends TripService {

    User loggedUser;
    List<Trip> trips;

    public TripServiceUserTestDouble(User loggedUser, List<Trip> trips) {
        super();
        this.loggedUser = loggedUser;
        this.trips = trips;
    }

    @Override
    List<Trip> getTrips(User user) {
        return trips;
    }

    @Override
    User getLoggedUser() {
        return loggedUser;
    }
}
