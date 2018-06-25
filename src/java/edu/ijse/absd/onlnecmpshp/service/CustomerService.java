/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.service;

import edu.ijse.absd.onlnecmpshp.dto.ItemDto;
import java.util.List;

/**
 *
 * @author dilin
 */
public interface CustomerService extends SuperService {

    public boolean purchaseGoods(List<ItemDto> items);

}
