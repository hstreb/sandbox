import org.scalatest.WordSpec

import com.example.Diamond

class DiamondSpec extends WordSpec {

  "Diamond" should {

    "genereate empty sequence when input is minor than 'A'" in {
      assert(Diamond.generateSequence('@') == Seq())
    }

    "genereate charactere sequence from one input" in {
      assert(Diamond.generateSequence('A') == Seq('A'))
    }

    "genereate charactere sequence just to 'Z'" in {
      assert(Diamond.generateSequence('[').last == 'Z')
    }

    "genereate charactere sequence with lower case" in {
      assert(Diamond.generateSequence('c')(1) == 'B')
    }

    "get first line" in {
      assert(Diamond.getLine("A", 3, 0) == "  A")
    }

    "get first line from empty sequence" in {
      assert(Diamond.getLine("A", 0, 0) == "")
    }

    "get second line" in {
      assert(Diamond.getLine("B", 3, 1) == " B B")
    }

    "get third line" in {
      assert(Diamond.getLine("C", 3, 2) == "C   C")
    }

    "get third line from larger sequence" in {
      assert(Diamond.getLine("C", 5, 2) == "  C   C")
    }

    "get diamond from letter 'a'" in {
      assert(Diamond.generateDiamond(Diamond.generateSequence('a')) == Seq("A"))
    }

    "get diamond from letter 'c'" in {
      assert(Diamond.generateDiamond(Diamond.generateSequence('c')) == Seq("  A", " B B", "C   C", " B B", "  A"))
    }

  }
}
