package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items._  //imports everything in the folder

class ApplicationObjective extends FunSuite{

  //maybe need to add more methods to modifiers classes
  //just cant call them in the tests directly
  //also need to think state pattern for the app obj
  //there is a lot of freedom in how to get it working

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

  test("shittinFartin"){
    //adding the items to the cart
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()

    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(6)
    testSelfCheckout.numberPressed(9)
    testSelfCheckout.enterPressed()
  }
}
