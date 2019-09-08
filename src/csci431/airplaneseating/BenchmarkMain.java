package csci431.airplaneseating;

import org.optaplanner.benchmark.api.PlannerBenchmark;
import org.optaplanner.benchmark.api.PlannerBenchmarkFactory;

import java.util.ArrayList;
import java.util.List;

public class BenchmarkMain {
    public static void main(String[] args) {
        List<Passenger> passengers = new ArrayList<>();
        for(int i = 0; i < 137; i++) {
            passengers.add(new Passenger());
        }
        SeatSolution unsolvedSeatSolution = new SeatSolution();
        unsolvedSeatSolution.setPassengers(passengers);

        PlannerBenchmarkFactory plannerBenchmarkFactory = PlannerBenchmarkFactory.createFromXmlResource("benchmarkConfig.xml");
        PlannerBenchmark plannerBenchmark = plannerBenchmarkFactory.buildPlannerBenchmark(unsolvedSeatSolution);
        plannerBenchmark.benchmark();
    }
}
