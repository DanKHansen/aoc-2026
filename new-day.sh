#!/bin/sh
# Usage: ./new-day.sh 3   -> creates Day03, its test, and registers it.
set -eu
[ $# -eq 1 ] || { echo "usage: $0 <day>" >&2; exit 2; }
n=$(printf '%d' "$1"); dd=$(printf '%02d' "$n")
src="src/aoc/days/Day$dd.scala"; tst="test/aoc/days/Day$dd.test.scala"
[ -e "$src" ] && { echo "$src already exists" >&2; exit 1; }

cat > "$src" <<SCALA
package aoc.days

import aoc.Day

object Day$dd extends Day:
  def part1(input: String): Long = 0L

  def part2(input: String): Long = 0L
SCALA

cat > "$tst" <<SCALA
package aoc.days

class Day${dd}Test extends munit.FunSuite:
  val example = """
    |
    |""".stripMargin.trim

  test("part 1 example".ignore):
    assertEquals(Day$dd.part1(example), 0L)

  test("part 2 example".ignore):
    assertEquals(Day$dd.part2(example), 0L)
SCALA

sed -i "s|^  // @new-day|  $n -> Day$dd,\n  // @new-day|" src/aoc/Days.scala
echo "Created $src and $tst. Put your input in inputs/day$dd.txt"
