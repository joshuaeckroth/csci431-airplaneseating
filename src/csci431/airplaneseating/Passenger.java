package csci431.airplaneseating;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Passenger {
    private Integer row;
    private SeatConfiguration.Seat seat;
    private String name;

    public void setRow(Integer _row) { row = _row; }

    @PlanningVariable(valueRangeProviderRefs = {"rows"})
    public Integer getRow() { return row; }

    public void setSeat(SeatConfiguration.Seat _seat) { seat = _seat; }

    @PlanningVariable(valueRangeProviderRefs = {"seats"})
    public SeatConfiguration.Seat getSeat() { return seat; }

    public void setName(String _name) { name = _name; }
    public String getName() { return name; }
}
