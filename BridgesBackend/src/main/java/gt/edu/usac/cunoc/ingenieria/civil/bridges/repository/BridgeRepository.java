/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;

/**
 *
 * @author daniel
 */

/**
 * Access to the database
 */
@Repository
public interface BridgeRepository extends JpaRepository<Bridge, Long> {

}
