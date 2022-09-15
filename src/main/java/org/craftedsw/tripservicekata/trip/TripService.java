package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService{

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException{

        User loggedUser = getLoggedUser();
        if(userIsNotLogged(loggedUser)){
            throw new UserNotLoggedInException();
        }

        if(user.isFriend(loggedUser)){
            return getTrips(user);
        }
        return noTrips();
    }

    private boolean userIsNotLogged(User loggedUser){
        return loggedUser == null;
    }

    private ArrayList<Trip> noTrips(){
        return new ArrayList<Trip>();
    }

    List<Trip> getTrips(User user){
        return TripDAO.findTripsByUser(user);
    }

    User getLoggedUser(){
        return UserSession.getInstance().getLoggedUser();
    }

}
