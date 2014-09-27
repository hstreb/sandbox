def numberOfHoles(word: String): Int = {
  val letters = Map('8'->2,'%'->2,'B'->2,'&'->1,'4'->1,'6'->1,'9'->1,'0'->1,'§'->1,'@'->1,'g'->1,'q'->1,'Q'->1,'R'->1,'o'->1,'O'->1,'p'->1,'P'->1,'ª'->1,'º'->1,'a'->1,'A'->1,'d'->1,'D'->1,'b'->1,'°'->1,'¢'->1,'e'->1)
  word.map { s => letters.get(s).getOrElse(0) }.sum
}
assert(numberOfHoles("ABACO") == 5)