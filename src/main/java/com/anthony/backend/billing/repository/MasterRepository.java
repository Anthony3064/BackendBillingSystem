/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.anthony.backend.billing.repository;

import com.anthony.backend.billing.entity.Master;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anthony
 */
@Repository("masterRepository")
public interface MasterRepository extends JpaRepository<Master, Serializable> {

    public abstract Master findByCodGeneral(String codGeneral);

    @Override
    public abstract List<Master> findAll();
}
