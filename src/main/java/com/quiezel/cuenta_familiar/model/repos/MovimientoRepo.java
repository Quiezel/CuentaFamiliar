/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiezel.cuenta_familiar.model.repos;

import com.quiezel.cuenta_familiar.model.Movimiento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Chalio
 */
public interface MovimientoRepo extends CrudRepository<Movimiento, Long>{
    
}
