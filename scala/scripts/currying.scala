def discountIR = (salary:Double) => {
  salary match {
    case s if s < 1787.77 => 0.0
    case s if s > 1787.77 && s < 2679.29 => 7.75
    case s if s > 2679.29 && s < 3572.43 => 15.0
    case s if s > 3572.43 && s < 4463.83 => 22.5
    case s if s > 4463.81 => 27.5
  }
} 

def discountINSS = (salary:Double) => {
  salary match {
    case s if s < 1317.07 => 8.0
    case s if s > 1317.08 && s < 2195.12 => 9.0
    case s if s > 2195.13 && s < 4390.24 => 11.0
    case _ => 0.0
  }
}

val discounts = List(discountIR, discountINSS)

def calculateDiscounts(discount: Double => Double)(salary: Double) = { discount(salary) }
  
def calculateSalary(salary: Double) = {
  val totalOfDiscounts = discounts.map(_(salary)).sum 
  (1 - (totalOfDiscounts / 100)) * salary
}

val salary1 = calculateSalary(1788.0)
val salary2 = calculateSalary(1787.0)

assert(discountIR(1000.0) == 0.0)
assert(discountIR(2000.0) == 7.75)
assert(discountIR(3000.0) == 15.0)
assert(discountIR(4000.0) == 22.5)
assert(discountIR(5000.0) == 27.5)

assert(discountINSS(1000.0) == 8.0)
assert(discountINSS(2000.0) == 9.0)
assert(discountINSS(3000.0) == 11.0)
assert(discountINSS(5000.0) == 0.0)

assert(calculateDiscounts(discountIR)(1000) == 0)
assert(calculateDiscounts(discountINSS)(1000) == 8.0)

assert(salary1 == 1488.51)
assert(salary2 == 1626.17)