package store.model.items

import store.model.checkout.SelfCheckout

class NotLoyal extends LoyalMahBallzAPI{

  override def loyaltyNumber: Double = {
    0.0
  }

}
