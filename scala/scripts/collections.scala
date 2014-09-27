case class Person(name:String, age:Int, salary:Double, city:String)

val people = List(
  Person("a", 19, 1000.0, "Porto Alegre"),
  Person("b", 20, 2000.0, "Porto Alegre"),
  Person("c", 18, 1000.0, "Santa Maria"),
  Person("d", 40, 3000.0, "Porto Alegre"),
  Person("e", 50, 5000.0, "Porto Alegre"),
  Person("f", 35, 3000.0, "Santa Maria"),
  Person("g", 60, 6000.0, "Porto Alegre"),
  Person("h", 30, 4000.0, "Porto Alegre"),
  Person("i", 37, 3000.0, "Canoas"),
  Person("j", 22, 2000.0, "Porto Alegre"),
  Person("k", 27, 2000.0, "Rio Grande"),
  Person("l", 42, 3000.0, "São Paulo"),
  Person("m", 51, 3000.0, "Santa Maria"),
  Person("n", 38, 4000.0, "Porto Alegre"),
  Person("o", 18, 1000.0, "Porto Alegre"),
  Person("p", 17, 1000.0, "Porto Alegre"),
  Person("q", 48, 4000.0, "Porto Alegre"),
  Person("r", 58, 4000.0, "Rio Grande"),
  Person("s", 81, 5000.0, "Porto Alegre"),
  Person("t", 62, 10000.0, "Porto Alegre"),
  Person("u", 32, 3000.0, "Santa Maria"),
  Person("v", 28, 2000.0, "Porto Alegre"),
  Person("w", 18, 1000.0, "Santa Maria"),
  Person("x", 26, 2000.0, "Santa Maria"),
  Person("y", 31, 3000.0, "Porto Alegre"),
  Person("z", 43, 2000.0, "Canoas"))
  
/*
- Filtrar salário > 3k, idade entre 20 e 40 de poa
- Contar pessoas por cidade
- Somatório da renda de Santa Maria 
- Listar apenas renda e idade
- Contar pessoas que estao devendo 
- Aumentar 10% salário de quem mora em poa
 */
def filterPoa(p: Person): Boolean = p.salary > 3000.0 && p.age > 20 && p.age < 40 && p.city == "Porto Alegre"
println(people.filter(filterPoa))
//List(Person(h,30,4000.0,Porto Alegre), Person(n,38,4000.0,Porto Alegre))

println(people.groupBy(_.city).map{ c => c._1 -> c._2.size })
// Map(Canoas -> 2, São Paulo -> 1, Porto Alegre -> 15, Santa Maria -> 6, Rio Grande -> 2)

println(people.filter(_.city == "Santa Maria").map(_.salary).sum)
// 13000.0

println(people.map(p => (p.salary, p.age)))
// List((1000.0,19), (2000.0,20), (1000.0,18), ...

val listDebtors = List("1", "3", "a", "a2", "w")
println(people.count(p => listDebtors.contains(p.name)))
// 2

def increasePoa(p: Person) = if (p.city == "Porto Alegre") p.copy(salary = p.salary * 1.1) else p
println(people.map(increasePoa))
// List(Person(a,19,1100.0,Porto Alegre), Person(b,20,2200.0,Porto Alegre), Person(c,18,1000.0,Santa Maria), ...

val result = for{ 
  p <- people
  d <- 1 to 5
  if d % 4 != 0
} yield s"${p.name}-${d}" 
println(result)
// List(a-1, a-2, a-3, a-5, b-1, b-2, b-3, b-5, c-1, c-2, c-3, c-5, ...

println(people.foldLeft("foldLeft:")((a, e:Person) => s"$a, ${e.name}"))
// foldLeft:, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z

println(people.aggregate("agregate:")(_ + ", " + _.name, _ + _))
// agregate:, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z

println(people.map(_.name).reduce((a, n) => s"$a, $n"))
// a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z