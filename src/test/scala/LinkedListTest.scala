import org.scalatest._

class LinkedListTest extends FlatSpec with Matchers {
  "Linked List" should "traverse properly" in {
    val ll = new ListNode(20)
    val ll2 = new ListNode(50)
    val ll3 = new ListNode(100)

    ll.next = Some(ll2)
    ll2.next = Some(ll3)

    println(ll)

    ll.value should be (20)
    ll.next.get.value should be (50)
    ll.next.get.next.get.value should be (100)
  }

  "Linked List" should "work with string types" in {
    val ll = new ListNode("Phoom")
    val ll2 = new ListNode("Mano")

    ll.next = Some(ll2)

    println(ll)

    ll.value should be ("Phoom")
    ll.next.get.value should be ("Mano")
  }
}
