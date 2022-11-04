package store.model.items

abstract class Modifier {

  var loyalMaybe: Double

  // A method named "updatePrice" that takes a Double as a parameter and returns a Double.
  // The input represents the price of an item before the modifier is applied and the method
  // returns the new price with the modifier applied
  // written as an abstract class that will be overridden later
  def updatePrice(currentP: Double): Double = {
    0.0
  }


  //A method named "computeTax" that takes a Double as a parameter and returns a Double.
  // The input represents the price of an item (not the base price) and
  // the method returns the amount of tax to be charged by the modifier
  // another abstract method that will be overridden later
  def computeTax(currentP: Double): Double = {
    0.0
  }


}
