package store.model.checkout

import store.model.items.Item

abstract class SelfCheckoutSTATE(pooCrap: SelfCheckout) {

  def numberPressed(number: Int) : Unit = {}

  def clearPressed(): Unit = {}

  def enterPressed() : Unit = {}

  //checkoutPressed may be what switches the states
  def checkoutPressed(): Unit = {}

  def cashPressed(): Unit = {}

  def creditPressed(): Unit = {}

  def loyaltyCardPressed(): Unit = {}


}
