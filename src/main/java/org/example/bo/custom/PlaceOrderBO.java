package org.example.bo.custom;

import org.example.bo.SuperBO;

public interface PlaceOrderBO extends SuperBO {

/*
    void placeOrder(String cid, String oid, String iid, double price, int qty, double tot, String des, int qtyOnHand, String qtyy);
*/

    void placeOrder(String cid, String oid, String iid, double price, int qtyy, double tot, String des, int qtyOnHand);
}
