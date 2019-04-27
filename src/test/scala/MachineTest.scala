import org.scalatest._

class MachineTest extends FlatSpec with Matchers {
  "Machine" should "be able to move value into register" in {
    val m = new Machine()
    m.mov(1, 1024)
    m.register(1) should be (1024)
  }

  "Machine" should "be able to execute MOV" in {
    val m = new Machine()
    m.execute(Move, 50, 9000)
    m.register(50) should be (9000)
  }

  "Machine" should "be able to execute INC directly with address" in {
    val m = new Machine()
    m.execute(Move, 1, 10)
    m.execute(Increment, 1)
    m.register(1) should be (11)
  }

  "Machine" should "be able to execute INC" in {
    val m = new Machine()
    m.execute(Move, AX, 10)
    m.execute(Increment, AX)
    m.register(AX.address) should be (11)
  }

  "Machine" should "be able to execute SUM" in {
    val m = new Machine()
    m.execute(Move, AX, 50)
    m.execute(Move, BX, 120)
    m.execute(Add, AX, BX)
    m.register(AX.address) should be (120 + 50)
  }

  "Machine" should "clear the register when XORing with itself" in {
    val m = new Machine()
    m.execute(Move, AX, 20)
    m.execute(XOR, AX, AX)
    m.register(AX.address) should be (0)
  }

  "Machine" should "be able to XOR properly" in {
    val m = new Machine()
    m.execute(Move, AX, 20)
    m.execute(Move, BX, 50)
    m.execute(XOR, AX, BX)
    m.register(AX.address) should be (38)
  }
}
