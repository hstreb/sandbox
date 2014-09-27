package com.example

object Diamond {

  def generateSequence(end: Char): Seq[Char] = {
    val endUpper = if (end.toUpper > 'Z') 'Z' else end.toUpper
    'A' to endUpper
  }

  def getLine(letter: String, size: Int, position: Int): String = {
    if (size > 0) {
      if (position == 0) addSpaces(letter, size)
      else addSpaces(letter, spacesBefore(size, position)) + addSpaces(letter, spacesAfter(size, position))
    } else ""
  }
  
  def generateDiamond(sequence: Seq[Char]) = {
    val temp = sequence ++ sequence.reverse.tail
    temp.map(f => getLine(f.toString, sequence.size, sequence.indexOf(f)))
  }

  private def addSpaces(letter: String, spaces: Int) = letter.formatted(s"%${spaces}s")
  
  private def spacesBefore(size: Int, position: Int) = size - position
  
  private def spacesAfter(size: Int, position: Int) = size + position - spacesBefore(size, position)

}

object Main {
  def main(args: Array[String]) {
    val letter = if (args.length > 0) args(0).toCharArray()(0) else 'e' 
    val diamond = Diamond.generateDiamond(Diamond.generateSequence(letter))
    println(diamond.mkString("\n"))
  }
}