# Airplane Seating

## Constraint satisfaction demo with OptaPlanner

This project shows how to use OptaPlanner to search for solutions to a constraint satisfaction problem.

Suppose we need to assign seats to ticket holders on a single airplane. We have the following "problem facts":

- The plane has a certain seat configuration, defined as an array from 1-N (rows), with three seats per side, labeled A-F.
- Seats A and F are window seats; seats B and E are middle seats; seats C and D are aisle seats.
- Some people have reserved seats; these cannot be changed.

Hard, medium, and soft constraints are defined as:

- Hard constraints: only one person per seat; reserved seats cannot be changed.
- Medium constraints: every passenger has a seat.
- Soft constraints: window seats are most preferred, aisle seats second-most preferred, middle seats least preferred.
