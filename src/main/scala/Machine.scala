import scala.collection.mutable

class Machine {
  var register: mutable.HashMap[Int, Int] = new mutable.HashMap()
  implicit val machine: Machine = this

  def execute(instruction: Instruction, register: Register): Unit = {
    instruction.compute(register)
  }

  def execute(instruction: Instruction, dest: Register, value: Int): Unit = {
    instruction.compute(dest, value)
  }

  def execute(instruction: Instruction, dest: Register, src: Register): Unit = {
    instruction.compute(dest, src)
  }
}
