/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.controller;

import com.anthony.backend.billing.entity.Detail;
import com.anthony.backend.billing.service.DetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anthony
 */
@RestController
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private DetailService service;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Detail detail) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(detail));
    }

    @GetMapping("/findByCodGeneral")
    public ResponseEntity<Detail> findByCodGeneral(@RequestParam String codGeneral) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByCodGeneral(codGeneral));
    }

    @GetMapping("/findAllByMasterCodGeneral")
    public ResponseEntity<List<Detail>> findAllDetailsByMasterCodGeneral(@RequestParam String codGeneral) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllDetailsByMasterCodGeneral(codGeneral));
    }

}
