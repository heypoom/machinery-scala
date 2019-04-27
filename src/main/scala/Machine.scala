import scala.collection.mutable

class Machine {
  var register: mutable.HashMap[Int, Int] = new mutable.HashMap()

  // MOV EAX, 10
  def execute(instruction: Instruction, register: Register, value: Int): Unit =
    execute(instruction, register.address, value)

  // SUB EBX
  def execute(instruction: Instruction, register: Register): Unit =
    execute(instruction, register.address)

  // XOR EAX, ECX
  def execute(instruction: Instruction, destination: Register, source: Register): Unit =
    execute(instruction, destination.address, source.address)

  def execute(instruction: Instruction, operands: Int*): Unit = {
    (instruction, operands.toList) match {
      case (Move, List(dest, src)) => mov(dest, src)
      case (Increment, List(n)) => incr(n)
      case (Increment, List(a, b)) => incr(a, b)
      case (Add, List(dest, src)) => add(dest, src)
      case (XOR, List(dest, src)) => xor(dest, src)
      case _ => println("Unimplemented Instruction.")
    }
  }

  def mov(destination: Int, source: Int): Unit = {
    register(destination) = source
  }

  def incr(address: Int, by: Int = 1): Unit = {
    register(address) = register(address) + by
  }

  def add(dest: Int, src: Int): Unit = {
    register(AX.address) = register(dest) + register(src)
  }

  def xor(dest: Int, src: Int): Unit = {
    register(dest) = register(dest) ^ register(src)
  }
}
