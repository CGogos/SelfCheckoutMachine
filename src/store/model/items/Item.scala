package store.model.items

class Item(val itemDescription: String, var bPrice: Double) {
  // TODO: Complete this class according to the features listed in the HW document

  //Returns the description of the item, from the constructor, as a String
  def description(): String = {
    this.itemDescription
  }

  //This method will change the base price of this item to the value of the parameter of this method
  def setBasePrice(newBPrice: Double): Unit = {
    this.bPrice = newBPrice
  }

  //returns the current price of the item. This price will initially be the base price from the constructor,
  //then will be overwritten whenever setBasePrice is called.
  def price(): Double = {
    this.bPrice
  }


}
