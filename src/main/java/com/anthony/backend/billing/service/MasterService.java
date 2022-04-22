/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.service;

import com.anthony.backend.billing.entity.Master;
import com.anthony.backend.billing.repository.MasterRepository;
import com.anthony.backend.billing.service.implement.IMaster;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anthony
 */
@Service("masterService")
public class MasterService implements IMaster {

    @Autowired
    MasterRepository repository;

    @Override
    public boolean save(Master master) throws Exception {
        boolean saved = false;
        try {
            repository.save(master);
            saved = true;
        } catch (Exception e) {
            throw new Exception("Save fail" + e.getMessage());
        }
        return saved;
    }

    @Override
    public Master findByCodGeneral(String codGeneral) throws Exception {

        try {
            if (codGeneral != null && !codGeneral.isEmpty()) {
                return repository.findByCodGeneral(codGeneral);
            } else {
                throw new Exception("Not found data");
            }
        } catch (Exception e) {
            throw new Exception("Error " + e.getMessage());
        }

    }

    @Override
    public List<Master> findAllMaster() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new Exception("Not found data.");
        }
    }

}
