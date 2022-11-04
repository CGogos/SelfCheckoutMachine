package store.model.checkout

import store.model.items.{NotLoyal, UrLoyal}

class WeDoneHere(pooCrap: SelfCheckout) extends SelfCheckoutSTATE(pooCrap) {

  override def numberPressed(number: Int): Unit = {}

  override def clearPressed(): Unit = {}

  override def enterPressed(): Unit = {}

  override def checkoutPressed(): Unit = {}

  override def cashPressed(): Unit = {
    pooCrap.customerCart = List()
    pooCrap.dispStr = ""
    pooCrap.state = new CheckingOut(pooCrap)
    //need to turn the loyalty sale state back to not loyal when ur done checking out
    for (item <- pooCrap.storeInventory.values){
      for (mod <- item.modsList){
        mod.loyalMaybe = new NotLoyal().loyaltyNumber
      }
    }
  }

  override def creditPressed(): Unit = {
    pooCrap.customerCart = List()
    pooCrap.dispStr = ""
    pooCrap.state = new CheckingOut(pooCrap)
    //need to turn the loyalty sale state back to not loyal when ur done checking out
    for (item <- pooCrap.storeInventory.values) {
      for (mod <- item.modsList) {
        mod.loyalMaybe = new NotLoyal().loyaltyNumber
      }
    }
  }

}
