/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.service;

import com.anthony.backend.billing.entity.Master;
import com.anthony.backend.billing.repository.MasterRepository;
import com.anthony.backend.billing.service.implement.IMaster;
import com.billing_system_model.exception.BadRequestException;
import com.billing_system_model.exception.NotFoundException;
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
    public boolean save(Master master) {
        boolean saved = false;

        if (master != null) {
            Master masterSaved = repository.save(master);

            if (masterSaved != null) {
                saved = true;
            } else {
                throw new BadRequestException("Error saving master.");
            }
        } else {
            throw new BadRequestException("Master is required.");
        }

        return saved;
    }

    @Override
    public Master findByCodGeneral(String codGeneral) {

        if (codGeneral != null && !codGeneral.isEmpty()) {

            Master master = repository.findByCodGeneral(codGeneral);

            if (master != null) {
                return master;
            } else {
                throw new NotFoundException("No found data.");
            }

        } else {
            throw new BadRequestException("CodGeneral is required.");
        }

    }

    @Override
    public List<Master> findAllMaster() {

        List<Master> masters = repository.findAll();

        if (masters != null && !masters.isEmpty()) {
            return masters;
        } else {
            throw new BadRequestException("CodGeneral is required.");
        }

    }

}
