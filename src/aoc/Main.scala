package aoc

import java.nio.file.{Files, NoSuchFileException, Path}

// Imperative shell: reads the input file, times the parts, prints. Days stay pure.

private def readInput(day: Int): Either[String, String] =
  val path = Path.of(f"inputs/day$day%02d.txt")
  try Right(Files.readString(path))
  catch case _: NoSuchFileException => Left(s"Missing input: $path (download it from adventofcode.com)")

private def timed(label: String)(run: => Answer): String =
  val start = System.nanoTime()
  val answer = run
  f"$label: $answer  (${(System.nanoTime() - start) / 1e6}%.1f ms)"

@main def solve(day: Int): Unit =
  val result = for
    solution <- registry.get(day).toRight(s"Day $day is not registered. Run ./new-day.sh $day")
    input    <- readInput(day)
  yield List(timed("Part 1")(solution.part1(input)), timed("Part 2")(solution.part2(input)))

  result match
    case Right(lines) => lines.foreach(println)
    case Left(error) =>
      Console.err.println(error)
      sys.exit(1)
