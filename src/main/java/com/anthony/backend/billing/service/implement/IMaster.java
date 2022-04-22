/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.anthony.backend.billing.service.implement;

import com.anthony.backend.billing.entity.Master;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface IMaster {

    public boolean save(Master master) throws Exception;

    public Master findByCodGeneral(String codGeneral) throws Exception;

    public List<Master> findAllMaster() throws Exception;

}
