package store.model.items

class Item(val itemDescription: String = "error", var bPrice: Double = 0.0) {
  // TODO: Complete this class according to the features listed in the HW document

  var modsList: List[Modifier] = List()  //setting up the list to hold the modifiers

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

  //how in the world to use the polymorphism here????
  def price(): Double = {
    var actualPrice: Double = this.bPrice
    for (mod <- modsList){
      actualPrice = mod.updatePrice(actualPrice)
    }
    actualPrice
  }

  //method named "addModifier" that takes a Modifier as a parameter and returns Unit

  //is this how to use the polymorphism?????? prolly not
  def addModifier(mod: Modifier): Unit = {
    modsList = modsList :+ mod
  }

  def tax(): Double = {
    val untaxPrice: Double = price()
    var taxMoneys: Double = 0.0
    for (mod <- modsList){
      taxMoneys += mod.computeTax(untaxPrice)
    }
    taxMoneys
  }

}
