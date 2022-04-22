/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.anthony.backend.billing.repository;

import com.anthony.backend.billing.entity.Detail;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anthony
 */
@Repository("detailRepository")
public interface DetailRepository extends JpaRepository<Detail, Serializable> {

    @Query(value = "SELECT d FROM Detail d WHERE d.master.codGeneral = :codGeneral")
    public abstract List<Detail> findByMasterCodGeneral(@Param("codGeneral") String codGeneralString);

    public abstract Detail findByCodGeneral(String codGeneral);

}
