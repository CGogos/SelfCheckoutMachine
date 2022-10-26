package store.model.checkout

import store.model.items.Item

class SelfCheckout {

  var barcode: String = ""
  var dispStr: String = ""
  var storeInventory: Map[String, Item] = Map()
  var customerCart: List[Item] = List()

  var state: SelfCheckoutSTATE = new CheckingOut(this)

  def addItemToStore(barcode: String, item: Item): Unit = {
    // This method adds an item to your store's checkout system. It does not add an item to the customer's cart
    this.storeInventory += (barcode -> item)
  }

  def numberPressed(number: Int): Unit = {
//    this.barcode += number.toString
    this.state.numberPressed(number)
  }

  def clearPressed(): Unit = {
//    this.barcode = ""
    this.state.clearPressed()
  }

  def enterPressed(): Unit = {
//    val itemForCart: Item = this.storeInventory.getOrElse(barcode, new Item("error", 0.0))
//    this.customerCart  = customerCart :+ itemForCart
//    this.barcode = ""
    this.state.enterPressed()
  }

  def checkoutPressed(): Unit = {
    // TODO
    this.state.checkoutPressed()
  }

  def cashPressed(): Unit = {
    // TODO
    this.state.cashPressed()
  }

  def creditPressed(): Unit = {
    // TODO
    this.state.creditPressed()
  }

  def loyaltyCardPressed(): Unit = {
    // TODO
    this.state.loyaltyCardPressed()
  }

  def displayString(): String = {
    this.dispStr
  }

  def itemsInCart(): List[Item] = {
    this.customerCart
  }

  def subtotal(): Double = {
    var poosock: Double = 0.0
    for (itoom <- this.itemsInCart()){
      poosock += itoom.price()
    }
    poosock
  }

  def tax(): Double = {
    var poosock: Double = 0.0
    for (itoom <- this.itemsInCart()){
      poosock += itoom.tax()
    }
    poosock
  }

  def total(): Double = {
    tax() + subtotal()
  }

  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.

    // Example usage:
    val testItem: Item = new Item("test item", 100.0)
    this.addItemToStore("472", testItem)
  }

}
