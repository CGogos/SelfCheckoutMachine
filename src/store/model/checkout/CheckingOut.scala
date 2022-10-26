package store.model.checkout

import store.model.checkout.SelfCheckoutSTATE
import store.model.items.Item

class CheckingOut(pooCrap: SelfCheckout) extends SelfCheckoutSTATE(pooCrap) {

  override def numberPressed(number: Int): Unit = {
    pooCrap.dispStr += number.toString
    pooCrap.barcode = pooCrap.dispStr
  }

  override def clearPressed(): Unit = {
    pooCrap.dispStr = ""
  }

  override def enterPressed(): Unit = {
    pooCrap.dispStr = ""
    val itemForCart: Item = pooCrap.storeInventory.getOrElse(pooCrap.barcode, new Item("error", 0.0))
    pooCrap.customerCart  = pooCrap.customerCart :+ itemForCart
  }

  override def checkoutPressed(): Unit = {
    pooCrap.dispStr = "cash or credit"
    pooCrap.state = new WeDoneHere(pooCrap)
  }

  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit = {}

  override def loyaltyCardPressed(): Unit = {}


}
