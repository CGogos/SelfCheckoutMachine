package store.model.items

class BottleDeposit(depAmount: Double) extends Modifier {

  //return the input price unmodified
  override def updatePrice(currentP: Double): Double = {
    currentP
  }

  //doesnt depend on the price of the item
  //should just return the deposit amount
  override def computeTax(currentP: Double): Double = {
    depAmount
  }
}
