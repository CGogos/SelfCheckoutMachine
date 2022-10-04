package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task1 extends FunSuite {

  test("Testing self checkout correct barcode") {

    var testSelfCheckout: SelfCheckout = new SelfCheckout()

    var testItem: Item = new Item("test item", 100.0)    //this creates an item in the store
    assert(testItem.description() == "test item")   //checking if the description in item class works
    assert(testItem.price() - 100.0 < 0.001)  //checking the item price

                                                                    // these are
    testSelfCheckout.addItemToStore("020", testItem)      // adding the item to the store
    testSelfCheckout.numberPressed(0)                     //typing in the numbers for barcode
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.enterPressed()                               //pressing enter on the keypad
    val cart: List[Item] = testSelfCheckout.itemsInCart()         //putting the cart items in a value (to be checked)

    assert(cart.length == 1)         // making sure the cart will only have 1 item in it
    assert(cart.head.description() == "test item")    // checking to see if the correct item is in the cart
  }


  test("Testing multiple items, and same item added many times with a price change") {

    var testSelfCheckout: SelfCheckout = new SelfCheckout()

    var testItem: Item = new Item("test item", 100.0)
    assert(testItem.description() == "test item")
    assert(testItem.price() - 100.0 < 0.001)
    var testItem2: Item = new Item("test item 2", 420.0)

    testSelfCheckout.addItemToStore("123", testItem)
    testSelfCheckout.addItemToStore("42069", testItem2)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()

    testItem.setBasePrice(69.0)
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

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.enterPressed()

    val cart: List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.length == 4)

    assert(cart.head.description() == "test item")
    assert((cart.head.price() - 69.0).abs < 0.001)

    assert(cart.apply(1).description() == "test item")
    assert((cart.apply(1).price() - 69.0).abs < 0.001)

    assert(cart.apply(2).description() == "test item 2")
    assert((cart.apply(2).price() - 420.0).abs < 0.001)

    assert(cart.last.description() == "error")
    assert((cart.last.price() - 0.0).abs < 0.001)
  }


  test("Testing self checkout Wrong barcode") {

    var testSelfCheckout: SelfCheckout = new SelfCheckout()

    var testItem: Item = new Item("test item", 100.0)
    assert(testItem.description() == "test item")
    assert(testItem.price() - 100.0 < 0.001)

    testSelfCheckout.addItemToStore("123", testItem)
    testSelfCheckout.numberPressed(4) //making sure to punch in wrong numbers
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.enterPressed()
    val cart: List[Item] = testSelfCheckout.itemsInCart()

    assert(cart.length == 1)
    assert(cart.head.description() == "error")
  }


  test("Testing the display and keypad functions") {

    var testSelfCheckout: SelfCheckout = new SelfCheckout()

    assert(testSelfCheckout.displayString() == "")   // checking to make sure the display boots up as empty string
    testSelfCheckout.numberPressed(4)   //punching numbers in the keypad
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(0)
    assert(testSelfCheckout.displayString() == "420") //checking to see if the input numbers are on the display
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.displayString() == "") //checking if enter clears the display
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString() == "")  //checking if clear clears the display
  }


  test("Testing setBasePrice") {

    var testItem: Item = new Item("test item", 100.0)
    assert(testItem.price() - 100.0 < 0.001) // checking initial price is correct
    testItem.setBasePrice(69.0)
    assert(testItem.price() - 69.0 < 0.001) // checking to see if the new price was set
  }


  test("Testing price") {

    var testItem: Item = new Item("test item", 100.0)
    assert(testItem.price() - 100.0 < 0.001)
  }


}
