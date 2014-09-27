def fizzBuzz(x: Int) = if(x % 15 == 0) "FizzBuzz " else if (x % 3 == 0) "Fizz " else if (x % 5 == 0) "Buzz " else s"$x "
1 to 100 map fizzBuzz foreach print

def fizzBuzz(n: Int, div: Int, met: String, notMet: String): String = if (n % div == 0) met else notMet
for (i <- 1 to 100) print(fizzBuzz(i, 15, "FizzBuzz ", fizzBuzz(i, 3, "Fizz ", fizzBuzz(i, 5, "Buzz ", s"$i "))))
