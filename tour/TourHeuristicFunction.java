package tour;

import search.Node;
import search.NodeFunction;

import java.util.Set;

public class TourHeuristicFunction implements NodeFunction {
    protected final Set<City> allCities;
    protected final City goalCity;

    public TourHeuristicFunction(Set<City> allCities, City goalCity) {
        this.allCities = allCities;
        this.goalCity = goalCity;
    }

    @Override
    public int getValue(Node n) {
        City farthestUnvisitedCity = null;
        int distanceToFarthestUnvisitedCity = -1;
        TourState tourState = (TourState)n.state;
        for (City city : allCities) {
            if (tourState.visitedCities.contains(city)) {
                continue;
            }
            int distance = tourState.currentCity.getShortestDistanceTo(city);
            if (distanceToFarthestUnvisitedCity < 0 || distance > distanceToFarthestUnvisitedCity) {
                distanceToFarthestUnvisitedCity = distance;
                farthestUnvisitedCity = city;
            }
        }
        if (farthestUnvisitedCity == null) {
            return 0;
        }
        return distanceToFarthestUnvisitedCity + farthestUnvisitedCity.getShortestDistanceTo(goalCity);
    }
}
