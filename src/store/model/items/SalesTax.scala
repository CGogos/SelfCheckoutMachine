package store.model.items

class SalesTax(sTax: Double) extends Modifier {

  override var loyalMaybe = 0.0

  //return the current price
  override def updatePrice(currentP: Double): Double = {
    currentP
  }

  //The computeTax method should return the amount of sales tax
  //that should be charged based on the inputted price of the item
  override def computeTax(currentP: Double): Double = {
    val taxPrice: Double =  currentP * (this.sTax/100.0)
    taxPrice
  }

}
