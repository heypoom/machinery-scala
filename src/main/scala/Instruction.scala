sealed trait Instruction

case object Move extends Instruction
case object Increment extends Instruction
case object Add extends Instruction
case object Subtract extends Instruction

/** Exclusive OR */
case object XOR extends Instruction
