package store.model.items

class Sale(couponPercent: Double) extends Modifier {

  //updatePrice method should take the price of an item before the sale is applied and
  //return the new price with the sale applied
  //Example: If the sale is 20% and the input is 100.0, this method returns 80.0
  override def updatePrice(currentP: Double): Double = {
   currentP - ((couponPercent/100) * currentP)
  }

  // this method should always return 0
  override def computeTax(currentP: Double): Double = {
      0.0
  }


}
