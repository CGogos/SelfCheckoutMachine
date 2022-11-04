package store.model.items

class LoyaltySale(salePercent: Double) extends Modifier {

  override var loyalMaybe: Double = new NotLoyal().loyaltyNumber

  override def updatePrice(currentP: Double): Double = {
    val salePrice: Double = currentP - (((this.salePercent / 100) * currentP) * loyalMaybe)
    salePrice
  }

  override def computeTax(currentP: Double): Double = {
    0.0
  }

}
