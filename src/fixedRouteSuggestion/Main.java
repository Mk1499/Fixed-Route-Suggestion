package fixedRouteSuggestion;

import java.util.Scanner;

/**
 *
 * @author MKhaled
 */
//import java.io.*;
public class Main {

    static Scanner in = new Scanner(System.in); //define input object 

    static void setRouteData(Route[] r) {

        for (int i = 0; i < r.length; i++) {
            r[i] = new Route();
            r[i].setNoOfStations(in.nextInt());
            r[i].setRouteStations();
        }
    }

    // Set Station suggested from user data
    static void setUserRoutedata(Route r) {
        r.setNoOfStations(in.nextInt());
        r.setRouteStations();
    }

    // determin distance between two stations 
    static int distanceBetweenStations(Station s1, Station s2) {
        int distance;
        distance = Math.abs(s1.getX() - s2.getX()) + Math.abs(s1.getY() - s2.getY());
        return distance;
    }

    
    // Find The Nearest SWVL Station to User Suggested Station 
    static String findStation(Station userStation, Route[] SwvlRoutes) {

        String rslt = userStation.getName();
        String stationName;
        int minDistance;

        // intialize nearest station with first station of first SWVL Route 
        minDistance = distanceBetweenStations(SwvlRoutes[0].getRouteStations()[0], userStation);
        stationName = SwvlRoutes[0].getRouteStations()[0].getName();

        for (int i = 0; i < SwvlRoutes.length; i++) {

            Station[] stationsArr = SwvlRoutes[i].getRouteStations();

            for (int k = 0; k < stationsArr.length; k++) {
                if (distanceBetweenStations(stationsArr[k], userStation) < minDistance) {
                    minDistance = distanceBetweenStations(stationsArr[k], userStation);
                    stationName = stationsArr[k].getName();
                }
            }
        }
        rslt += " " + stationName;

        return rslt;
    }

    
    //===================  Start Main ===================== //
    public static void main(String[] args) {
        // TODO code application logic here

        Route[] SWVL_Routes; // Define Array of SWVL Fixed Routes 
        Route User_Routes = new Route(); // Define User Suggestion Fixed Route 
        Station[] userRoueStations;

        // ==================== Take Input Data From User ========================
        SWVL_Routes = new Route[in.nextInt()]; // Set Array for Swvl Fixed Routes    
        setRouteData(SWVL_Routes);

        setUserRoutedata(User_Routes); // set User Route Stations

        // =========== find Nearst ======================//
        userRoueStations = User_Routes.getRouteStations();
        for (int i = 0; i < userRoueStations.length; i++) {
            System.out.println(findStation(userRoueStations[i], SWVL_Routes));
        }
    }

}
