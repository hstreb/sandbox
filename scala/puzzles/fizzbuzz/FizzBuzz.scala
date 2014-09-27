def isFizz(x: Int) = x % 3 == 0
def isBuzz(x: Int) = x % 5 == 0
def isFizzBuzz(x: Int) = isFizz(x) && isBuzz(x)
def fizzBuzz(x: Int) = {
	if(isFizzBuzz(x)) "fizzbuzz" 
	else if (isFizz(x)) "fizz"
	else if (isBuzz(x)) "buzz"
	else s"$x"
}
1 to 100 map fizzBuzz foreach println
