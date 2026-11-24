# Advent of Code 2026 (Scala 3)

Tier: Prototype (personal puzzle repo).

## Layout

- `src/aoc/Day.scala`: the `Day` trait. Each day is an `object DayNN extends Day` with pure `part1`/`part2`.
- `src/aoc/Days.scala`: registry of days (filled in by `new-day.sh`).
- `src/aoc/Main.scala`: the only I/O: reads `inputs/dayNN.txt`, runs and times both parts.
- `test/`: munit tests, one file per day with the puzzle's example.
- `inputs/`: your puzzle inputs. Git ignores them; don't publish them.

## Daily routine

```sh
./new-day.sh 3                 # creates Day03 + test, registers it
# paste the example into test/aoc/days/Day03.test.scala, drop `.ignore`
scala-cli test . --test-only 'aoc.days.Day03*'
# save your input as inputs/day03.txt
scala-cli run . -- 3
```

Requires Scala CLI; versions are pinned in `project.scala`.
