package csci431.airplaneseating;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Passenger> passengers = new ArrayList<>();
        for(int i = 0; i < 137; i++) {
            passengers.add(new Passenger());
        }

        SolverFactory<SeatSolution> solverFactory = SolverFactory.createFromXmlResource("airplaneseating.xml");
        Solver<SeatSolution> solver = solverFactory.buildSolver();
        SeatSolution unsolvedSeatSolution = new SeatSolution();
        unsolvedSeatSolution.setPassengers(passengers);

        SeatSolution solvedSeatSolution = solver.solve(unsolvedSeatSolution);
        System.out.println(solvedSeatSolution);
    }
}
