# Advent of Code 2026 (Scala 3)

Tier: Prototype (personal puzzle repo).

## Layout

- `src/aoc/Day.scala`: the `Day` trait. Each day is an `object DayNN extends Day` with pure `part1`/`part2`.
- `src/aoc/Days.scala`: registry of days (filled in by `new-day.sh`).
- `src/aoc/Main.scala`: the only I/O: reads `inputs/dayNN.txt`, runs and times both parts.
- `test/`: munit tests, one file per day with the puzzle's example.
- `inputs/`: your puzzle inputs. Git ignores them; don't publish them.

Requires Scala CLI; versions are pinned in `project.scala`.

## One-time setup

1. Open the repo folder in VSCodium.
2. Install the **Metals** extension (`scalameta.metals`) and accept when it asks to import the build.
   The BSP files come from `scala-cli setup-ide .`; run that again if Metals can't find the build.

## Daily routine

Run everything from the repo root. Day 3 as the example.

1. **Create the day**

   ```sh
   ./new-day.sh 3
   ```

   Creates `src/aoc/days/Day03.scala` (empty `part1`/`part2` returning `0L`),
   `test/aoc/days/Day03.test.scala`, and registers the day in `src/aoc/Days.scala`.

2. **Put the puzzle example in the test.** Paste the example input between the `"""`,
   replace `0L` with the expected answer, and remove `.ignore`:

   ```scala
   test("part 1 example"):
     assertEquals(Day03.part1(example), 142L)
   ```

3. **Solve `part1`** in `Day03.scala`. It takes the whole input as a `String` and returns
   a `Long` or a `String` (add `.toLong` to an `Int` result).

4. **Run the tests until they pass** (add `--watch` to rerun on every save):

   ```sh
   scala-cli test . --test-only 'aoc.days.Day03*'
   ```

5. **Get your input**: while logged in, open `https://adventofcode.com/2026/day/3/input`
   and save it as `inputs/day03.txt`.

6. **Run on the real input**, then submit the answer on the site:

   ```sh
   scala-cli run . -- 3
   ```

   Prints both parts with timings. Repeat steps 2–6 for part 2.

7. **Commit and push.** `inputs/` is git-ignored, so inputs stay private; solutions are public.

## Troubleshooting

| Message | Fix |
|---|---|
| `Day 3 is not registered. Run ./new-day.sh 3` | Run `./new-day.sh 3`. |
| `Missing input: inputs/day03.txt` | Save your input there (step 5). |
| `src/aoc/days/Day03.scala already exists` | The day is already created; open the file. |
