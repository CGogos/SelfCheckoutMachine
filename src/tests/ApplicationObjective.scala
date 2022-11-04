package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items._  //imports everything in the folder


//what needs to be tested:
//- LoyaltySale class that inherits Modifier
//	- takes a double that is the percentage of the sale
//	- the sale price is NOT applied to the item unless 	loyalty card button has been pressed.
//	- when the customer checks out, sale needs to be 	inactive again
//- when loyalty card button is pressed, the items in the cart must update to reflect the loyalty sale prices
//- when loyalty card button is pressed, the items u scan in the future will need to be the loyalty sale price
//- assume no items or loyalty sale items are created after a customer presses the checkout button
//- NO TAX applied by a loyalty sale
//- MUST support multiple items with different percentage sales
//	- e.g. an item with 20% loyalty sale and another item 	with a 30% loyalty sale, BOTH IN SAME CART


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

  test("loyalty press prior to cart"){
    //add the loyalty sale modifier
    val loyalCustomer: Modifier = new LoyaltySale(50)
    testItem.addModifier(loyalCustomer)

    //adding the items to the cart
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    testSelfCheckout.loyaltyCardPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart().head.price(), 50.0))
    testSelfCheckout.loyaltyCardPressed()
    testSelfCheckout.loyaltyCardPressed()
    testSelfCheckout.loyaltyCardPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart().head.price(), 50.0))

    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart()(1).price(),50.0))
    testSelfCheckout.checkoutPressed()
    testSelfCheckout.cashPressed()

    //this is a new sale with no loyalty card pressed yet
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart().head.price(), 100.0))

    //now we will press it
    testSelfCheckout.checkoutPressed()
    testSelfCheckout.loyaltyCardPressed()
    assert(compareDoubles(testSelfCheckout.itemsInCart().head.price(), 50.0))


  }
}
