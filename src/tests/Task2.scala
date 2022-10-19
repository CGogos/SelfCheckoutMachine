package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items._  //imports everything in the folder

class Task2 extends FunSuite {

  // maybe need to check the variables reference.
  // good examples in the wednesday 10/5 lecture slides on slide 4
  // checking to see if they are being stored at the same reference.

  // override just makes a method that exists do something else (what u tell it to)

  // override the .toString for the item class, gives better information for debugging
  // good example of this in the 10/5 lecture slides aswell
  // slide 7 is the result of doing this

  /////// Some more stuff said in lecture
  //make sure state and county taxes are computed separately
  //
  //
  //


  //function that compares doubles for assertion
  def compareDoubles(d1: Double, d2: Double): Double = {
    (d1-d2).abs
  }

  //Written in class
//  test("Testing multiple sales") {
//    val item: Item = new Item("testing", 100.0)
//    val sale1: Sale = new Sale(20.0)
//    val sale2: Sale = new Sale(10.0)
//
//    item.addModifier(sale1)
//    item.addModifier(sale2)
//
//    assert(compareDoubles(item.price(), 72.0) < 0.001)
//    assert(compareDoubles(item.tax(), 0.0) < 0.001) //making sure there is no tax on this one
//
//    //remember when you pay tax, you are paying tax on the the sale price, the price u r paying
//  }


}
