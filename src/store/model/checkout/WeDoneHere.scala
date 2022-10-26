package store.model.checkout

class WeDoneHere(pooCrap: SelfCheckout) extends SelfCheckoutSTATE(pooCrap) {

  override def numberPressed(number: Int): Unit = {}

  override def clearPressed(): Unit = {}

  override def enterPressed(): Unit = {}

  override def checkoutPressed(): Unit = {}

  override def cashPressed(): Unit = {
    pooCrap.customerCart = List()
    pooCrap.dispStr = ""
    pooCrap.state = new CheckingOut(pooCrap)
  }

  override def creditPressed(): Unit = {
    pooCrap.customerCart = List()
    pooCrap.dispStr = ""
    pooCrap.state = new CheckingOut(pooCrap)
  }

  override def loyaltyCardPressed(): Unit = {}

}
