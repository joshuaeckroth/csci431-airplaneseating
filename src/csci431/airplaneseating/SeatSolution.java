package csci431.airplaneseating;

import csci431.airplaneseating.SeatConfiguration.Seat;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;

import java.util.*;

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
    public List<Seat> getSeats() {
        List<Seat> seats = new ArrayList<>();
        seats.add(Seat.A);
        seats.add(Seat.B);
        seats.add(Seat.C);
        seats.add(Seat.D);
        seats.add(Seat.E);
        seats.add(Seat.F);
        return seats;
    }

    @PlanningScore
    public HardMediumSoftScore getScore() { return score; }

    public void setScore(HardMediumSoftScore _score) { score = _score; }

    public String toString() {
        Map<Integer, Set<Seat>> assigned = new HashMap<>();
        for(Passenger p : getPassengers()) {
            if (p.getRow() != null && p.getSeat() != null) {
                Set<Seat> row = assigned.get(p.getRow());
                if (row == null) {
                    row = new HashSet<>();
                    row.add(p.getSeat());
                    assigned.put(p.getRow(), row);
                } else {
                    row.add(p.getSeat());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" \tABC DEF\n");
        for(int i = 1; i <= SeatConfiguration.NUM_ROWS; i++) {
            sb.append(i+1);
            sb.append("\t");
            if(assigned.containsKey(i) && assigned.get(i).contains(Seat.A)) {
                sb.append("x");
            } else {
                sb.append(".");
            }
            if(assigned.containsKey(i) && assigned.get(i).contains(Seat.B)) {
                sb.append("x");
            } else {
                sb.append(".");
            }
            if(assigned.containsKey(i) && assigned.get(i).contains(Seat.C)) {
                sb.append("x");
            } else {
                sb.append(".");
            }
            sb.append(" ");
            if(assigned.containsKey(i) && assigned.get(i).contains(Seat.D)) {
                sb.append("x");
            } else {
                sb.append(".");
            }
            if(assigned.containsKey(i) && assigned.get(i).contains(Seat.E)) {
                sb.append("x");
            } else {
                sb.append(".");
            }
            if(assigned.containsKey(i) && assigned.get(i).contains(Seat.F)) {
                sb.append("x");
            } else {
                sb.append(".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
