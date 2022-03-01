package tour;

import search.Node;
import search.NodeFunction;

import java.util.Set;

public class TourHeuristicFunction implements NodeFunction {
    protected final Set<City> unvisitedCities;
    protected final City goalCity;

    public TourHeuristicFunction(Set<City> unvisitedCities, City goalCity) {
        this.unvisitedCities = unvisitedCities;
        this.goalCity = goalCity;
    }

    @Override
    public int getValue(Node n) {
        City farthestUnvisitedCity = null;
        int distanceToFarthestUnvisitedCity = -1;
        TourState tourState = (TourState)n.state;
        for (City city : unvisitedCities) {
            int distance = tourState.currentCity.getShortestDistanceTo(city);
            if (distanceToFarthestUnvisitedCity < 0 || distance > distanceToFarthestUnvisitedCity) {
                distanceToFarthestUnvisitedCity = distance;
                farthestUnvisitedCity = city;
            }
        }
        return distanceToFarthestUnvisitedCity + farthestUnvisitedCity.getShortestDistanceTo(goalCity);
    }
}
