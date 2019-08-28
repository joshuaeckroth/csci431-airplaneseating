package csci431.airplaneseating;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class SeatSolution {
    private List<Passenger> passengers;
    private HardMediumSoftScore score;

    public void setPassengers(List<Passenger> _passengers) { passengers = _passengers; }

    @PlanningEntityCollectionProperty
    public List<Passenger> getPassengers() { return passengers; }

    @ValueRangeProvider(id = "rows")
    @ProblemFactCollectionProperty
    public List<Integer> getRows() {
        List<Integer> rows = new ArrayList<>();
        for(int i = 0; i < SeatConfiguration.NUM_ROWS; i++) {
            rows.add(i+1);
        }
        return rows;
    }

    @ValueRangeProvider(id = "seats")
    @ProblemFactCollectionProperty
    public List<SeatConfiguration.Seat> getSeats() {
        List<SeatConfiguration.Seat> seats = new ArrayList<>();
        seats.add(SeatConfiguration.Seat.A);
        seats.add(SeatConfiguration.Seat.B);
        seats.add(SeatConfiguration.Seat.C);
        seats.add(SeatConfiguration.Seat.D);
        seats.add(SeatConfiguration.Seat.E);
        seats.add(SeatConfiguration.Seat.F);
        return seats;
    }

    @PlanningScore
    public HardMediumSoftScore getScore() { return score; }

    public void setScore(HardMediumSoftScore _score) { score = _score; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        //for()
        return sb.toString();
    }
}
