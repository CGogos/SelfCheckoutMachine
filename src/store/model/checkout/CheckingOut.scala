package store.model.checkout

import store.model.items.Item

class CheckingOut(pooCrap: SelfCheckout) extends SelfCheckoutSTATE (pooCrap: SelfCheckout){


  override def addItemToStore(barcode: String, item: Item): Unit = {}

  override def numberPressed(number: Int): Unit = {}

  override def clearPressed(): Unit = {}

  override def enterPressed(): Unit = {}

  override def checkoutPressed(): Unit = {}

  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit = {}

  override def loyaltyCardPressed(): Unit = {}

  override def displayString(): String = {
    " "
  }

  override def itemsInCart(): List[Item] = {
    List()
  }


}
