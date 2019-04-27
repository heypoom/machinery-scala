class ListNode[T](val value: T) {
  override def toString: String = {
    next match {
      case Some(v) => s"${value.toString} -> $v"
      case None => value.toString
    }
  }

  var next: Option[ListNode[T]] = None

  def next_=(list: ListNode[T]): Unit = {
    next = Some(list)
  }
}

object ListNode {
  def printList[T](maybeList: Option[ListNode[T]]): Unit = {
    maybeList match {
      case Some(list: ListNode[T]) => println(list)
      case _ =>
    }
  }
}