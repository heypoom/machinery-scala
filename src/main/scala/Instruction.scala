sealed trait Instruction {
  def compute(register: Register)(implicit m: Machine): Unit = ()
  def compute(dest: Register, value: Int)(implicit m: Machine): Unit = ()
  def compute(dest: Register, source: Register)(implicit m: Machine): Unit = ()
}

case object Move extends Instruction {
  override def compute(dest: Register, source: Register)(implicit m: Machine): Unit = {
    m.register(dest.address) = m.register(source.address)
  }

  override def compute(dest: Register, value: Int)(implicit m: Machine): Unit = {
    m.register(dest.address) = value
  }
}

case object Increment extends Instruction {
  override def compute(register: Register)(implicit m: Machine): Unit = {
    compute(register, 1)
  }

  override def compute(dest: Register, incrBy: Int)(implicit m: Machine): Unit = {
    m.register(dest.address) += incrBy
  }
}

case object Add extends Instruction {
  override def compute(dest: Register, source: Register)(implicit m: Machine): Unit = {
    m.register(AX.address) = m.register(source.address) + m.register(dest.address)
  }
}

case object Subtract extends Instruction {
  override def compute(dest: Register, source: Register)(implicit m: Machine): Unit = {
    m.register(AX.address) = m.register(source.address) - m.register(dest.address)
  }
}

/** Exclusive OR */
case object XOR extends Instruction {
  override def compute(dest: Register, source: Register)(implicit m: Machine): Unit = {
    m.register(dest.address) = m.register(dest.address) ^ m.register(source.address)
  }
}
