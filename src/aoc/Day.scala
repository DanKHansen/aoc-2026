package aoc

/** Most puzzle answers are numbers; a few are strings. */
type Answer = Long | String

/** One puzzle day. Both parts are pure: answer from input text, no I/O. */
trait Day:
  def part1(input: String): Answer
  def part2(input: String): Answer
