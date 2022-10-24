/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.service;

import com.anthony.backend.billing.entity.Detail;
import com.anthony.backend.billing.repository.DetailRepository;
import com.anthony.backend.billing.service.implement.IDetail;
import com.billing_system_model.exception.BadRequestException;
import com.billing_system_model.exception.NotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anthony
 */
@Service("detailService")
public class DetailService implements IDetail {

    @Autowired
    private DetailRepository repository;

    @Override
    public boolean save(Detail detail) {
        boolean saved = false;

        if (detail != null) {
            Detail detailSaved = this.repository.save(detail);

            if (detailSaved != null) {
                saved = true;
            } else {
                throw new BadRequestException("Error saving detail.");
            }

        } else {
            throw new BadRequestException("Detail is required.");
        }

        return saved;
    }

    @Override
    public Detail findByCodGeneral(String codGeneral) {

        if (codGeneral != null && !codGeneral.isEmpty()) {

            Detail detail = repository.findByCodGeneral(codGeneral);

            if (detail != null) {
                return detail;
            } else {
                throw new NotFoundException("No found data.");
            }

        } else {
            throw new BadRequestException("CodGeneral is required.");
        }

    }

    @Override
    public List<Detail> findAllDetailsByMasterCodGeneral(String codGeneral) {

        if (codGeneral != null && !codGeneral.isEmpty()) {
            List<Detail> details = repository.findByMasterCodGeneral(codGeneral);

            if (details != null && !details.isEmpty()) {
                return details;
            } else {
                throw new NotFoundException("No found data.");
            }

        } else {
            throw new BadRequestException("CodGeneral is required.");
        }

    }

}
