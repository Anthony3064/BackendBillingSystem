/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.anthony.backend.billing.service.implement;

import com.anthony.backend.billing.entity.Detail;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface IDetail {

    public Detail findByCodGeneral(String codGeneral);

    public List<Detail> findAllDetailsByMasterCodGeneral(String codGeneral);

    public boolean save(Detail detail);

}
