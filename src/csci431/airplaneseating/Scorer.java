package csci431.airplaneseating;

import csci431.airplaneseating.SeatConfiguration.Seat;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Scorer implements EasyScoreCalculator<SeatSolution> {
    public HardMediumSoftScore calculateScore(SeatSolution solution) {
        int hardScore = 0;
        int mediumScore = 0;
        int softScore = 0;

        Map<Integer, Set<Seat>> assigned = new HashMap<>();
        for(Passenger p : solution.getPassengers()) {
            // ensure every passenger has a seat
            if(p.getRow() == null || p.getSeat() == null) {
                mediumScore--;
                continue;
            }
            // prefer middle seats are empty
            if(p.getSeat() == Seat.B ||
                    p.getSeat() == Seat.E) {
                softScore--;
            }
            Set<Seat> row = assigned.get(p.getRow());
            if(row == null) {
                row = new HashSet<>();
                row.add(p.getSeat());
                assigned.put(p.getRow(), row);
            } else if(row.contains(p.getSeat())) {
                // ensure no seat has two people
                hardScore--;
            } else {
                row.add(p.getSeat());
            }
        }
        return HardMediumSoftScore.of(hardScore, mediumScore, softScore);
    }
}
