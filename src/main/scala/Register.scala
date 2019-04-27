

sealed abstract class Register(val address: Int = 0x0)

case object NoOp extends Register(address = 0x0)

// Data Registers

/** Accumulator Register */
case object AX extends Register(address = 0x1)

/** Base Register */
case object BX extends Register(address = 0x2)

/** Count Register */
case object CX extends Register(address = 0x3)

/** Data Register */
case object DX extends Register(address = 0x4)

// Pointer Registers
case object InstructionPointer extends Register(address = 0x5)
case object StackPointer extends Register(address = 0x6)
case object BasePointer extends Register(address = 0x7)

// Index Registers
case object SourceIndex extends Register(address = 0x8)
case object DestinationIndex extends Register(address = 0x9)

// Flag Registers
case object OverflowFlag extends Register(address = 0x10)
case object InterruptFlag extends Register(address = 0x11)
case object TrapFlag extends Register(address = 0x12)
case object SignFlag extends Register(address = 0x13)
case object ZeroFlag extends Register(address = 0x14)
case object AuxCarryFlag extends Register(address = 0x15)
case object ParityFlag extends Register(address = 0x16)
case object CarryFlag extends Register(address = 0x17)
