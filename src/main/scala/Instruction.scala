sealed trait Instruction {
  def compute(register: Register)(implicit m: Machine): Unit = ()
  def compute(dest: Register, value: Int)(implicit m: Machine): Unit = ()
  def compute(dest: Register, source: Register)(implicit m: Machine): Unit = ()
}

case object Move extends Instruction {
  override def compute(dest: Register, source: Register)(implicit m: Machine): Unit = {
    m.register(dest) = m.register(source)
  }

  override def compute(dest: Register, value: Int)(implicit m: Machine): Unit = {
    m.register(dest) = value
  }
}

case object Increment extends Instruction {
  override def compute(register: Register)(implicit m: Machine): Unit = {
    compute(register, 1)
  }

  override def compute(dest: Register, incrBy: Int)(implicit m: Machine): Unit = {
    m.register(dest) += incrBy
  }
}

case object Add extends Instruction {
  override def compute(dest: Register, source: Register)(implicit m: Machine): Unit = {
    m.register(AX) = m.register(source) + m.register(dest)
  }
}

case object Subtract extends Instruction {
  override def compute(dest: Register, source: Register)(implicit m: Machine): Unit = {
    m.register(AX) = m.register(source) - m.register(dest)
  }
}

/** Exclusive OR */
case object XOR extends Instruction {
  override def compute(dest: Register, source: Register)(implicit m: Machine): Unit = {
    m.register(dest) = m.register(dest) ^ m.register(source)
  }
}
