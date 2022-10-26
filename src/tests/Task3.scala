package tests
import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items._  //imports everything in the folder

class Task3 extends FunSuite {

  //function that compares doubles for assertion
  val epsilon: Double = 0.001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < epsilon
  }

  var testSelfCheckout: SelfCheckout = new SelfCheckout()

  //creating some items to test with
  var testItem: Item = new Item("test item", 100.0)
  var testItem2: Item = new Item("test item 2", 420.0)

  //adding the items to the global store
  testSelfCheckout.addItemToStore("123", testItem)
  testSelfCheckout.addItemToStore("42069", testItem2)

  test("shitted"){

    //checking the new enterPressed() functionality
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.displayString() == "")
    testSelfCheckout.cashPressed()
    testSelfCheckout.creditPressed()
    testSelfCheckout.enterPressed()
    var cart: List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.head == testItem)
    assert(cart(1) == testItem)
    assert(cart.length == 2)

  }

  test("shittedDos"){
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    var cart: List[Item] = testSelfCheckout.itemsInCart()
    testSelfCheckout.checkoutPressed()
    assert(testSelfCheckout.displayString() == "cash or credit")
    testSelfCheckout.cashPressed()
    cart = testSelfCheckout.itemsInCart()
    assert(cart.isEmpty)
  }

}
