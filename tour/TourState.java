package tour;

import search.Action;
import search.State;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class TourState implements State {
	protected final Set<City> visitedCities;
	protected final City currentCity;
	
	public TourState(City startCity) {
		this.visitedCities = Collections.emptySet();
		this.currentCity = startCity;
	}
	public TourState(Set<City> visitedCities, City currentCity) {
		this.visitedCities = visitedCities;
		this.currentCity = currentCity;
	}
	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;
	}
	public State getActionResult(Action action) {
		Road road = (Road)action;
		Set<City> newVisitedCities = new LinkedHashSet<>(visitedCities);
		newVisitedCities.add(road.targetCity);
		return new TourState(newVisitedCities, road.targetCity);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TourState tourState = (TourState) o;
		return Objects.equals(visitedCities, tourState.visitedCities) && Objects.equals(currentCity, tourState.currentCity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(visitedCities, currentCity);
	}
}
