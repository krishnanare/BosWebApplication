/**
 * 
 */
package com.WebServices.BOSWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WebServices.BOSWeb.ModelDTO.SetPasswordDTO;

/**
 * @author 2622807
 *
 */
public interface SetPasswordRepo extends JpaRepository<SetPasswordDTO, Long> {
	SetPasswordDTO findByCustomerId(String Customerid);
}
