/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.service;

import edu.ijse.absd.onlnecmpshp.dto.ItemDto;
import edu.ijse.absd.onlnecmpshp.dto.UserDto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dilin
 */
public interface AdminService extends SuperService {

    public boolean saveUser(UserDto userDto);

    public List<UserDto> showUsers();

    public boolean editUser(UserDto userDto);

    public boolean removeUser(UserDto userDto);

    public boolean saveItem(ItemDto itemDto);

    public boolean editItem(ItemDto itemDto);

    public boolean deleteItem(ItemDto itemDto);
}
