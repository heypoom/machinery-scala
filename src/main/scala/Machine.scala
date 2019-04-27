import scala.collection.mutable

class Machine {
  var register: mutable.HashMap[Int, Int] = new mutable.HashMap()

  def execute(instruction: Instruction, operands: Any*): Unit = {
    implicit val machine: Machine = this

    operands.toList match {
      case List(register: Register) => instruction.compute(register)
      case List(dest: Register, value: Int) => instruction.compute(dest, value)
      case List(dest: Register, src: Register) => instruction.compute(dest, src)
      case _ => throw new Error("Invalid Instruction Type!")
    }
  }
}
