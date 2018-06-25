/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.model;

/**
 *
 * @author dilin
 */
public class ItemModel extends SuperModel{
    private String itemCode;
    private String desc;
    private int qtyOnHand;
    private double unitPrice;

    public ItemModel() {
    }

    public ItemModel(String itemCode, String desc, int qtyOnHand, double unitPrice) {
        this.itemCode = itemCode;
        this.desc = desc;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
    
    
}
