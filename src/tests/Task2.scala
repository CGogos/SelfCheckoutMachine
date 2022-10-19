package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items._  //imports everything in the folder

class Task2 extends FunSuite {

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

  test("poopsock"){

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

    val cart: List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.length == 2)
    assert(cart.head.description() == "test item")
    assert(cart.apply(1).description() == "test item 2")
    assert(compareDoubles(cart.head.price(),100.0))

    val saleTest: Modifier = new Sale(75.0)
    testItem.addModifier(saleTest)
    val taxTest: Modifier = new SalesTax(8.0)
    testItem.addModifier(taxTest)
    testItem2.addModifier(taxTest)

    assert(compareDoubles(cart.head.price(),25.0))
    assert(compareDoubles(cart.head.tax(),2.0))
    assert(compareDoubles(cart.apply(1).tax(),33.6))
    assert(compareDoubles(testSelfCheckout.subtotal(),445.0))

    val saleTest2: Modifier = new Sale(10.0)
    testItem.addModifier(saleTest2)
    assert(compareDoubles(cart.head.price(),22.5))
    assert(compareDoubles(cart.head.tax(),1.8))

    val bottledeposhiz: Modifier = new BottleDeposit(10)
    testItem2.addModifier(bottledeposhiz)
    assert(compareDoubles(cart.apply(1).tax(),43.6))

    assert(compareDoubles(testSelfCheckout.total(),487.9))

  }

}
