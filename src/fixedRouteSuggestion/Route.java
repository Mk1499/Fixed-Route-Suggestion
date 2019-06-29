
package fixedRouteSuggestion;

import java.util.Scanner;

/**
 *
 * @author MKhaled
 */
public class Route {

    private int noOfStations;
    private Station[] RouteStations;
    Scanner in = new Scanner(System.in);

    public Route() {

    }

    public int getNoOfStations() {
        return noOfStations;
    }

    public void setNoOfStations(int noOfStations) {
        this.noOfStations = noOfStations;
        this.RouteStations = new Station[noOfStations];
    }

    public void setRouteStations() {
        for (int i = 0; i < this.noOfStations; i++) {

            RouteStations[i] = new Station();

            RouteStations[i].setName(in.next());

            RouteStations[i].setX(in.nextInt());

            RouteStations[i].setY(in.nextInt());
        }
    }

    public void viewRouteStations() {
        for (int i = 0; i < this.noOfStations; i++) {

            System.out.print(RouteStations[i].getName());
            System.out.print(" " + RouteStations[i].getX());
            System.out.println(" " + RouteStations[i].getY());
        }
    }

    public Station[] getRouteStations() {
        return RouteStations;
    }

}
