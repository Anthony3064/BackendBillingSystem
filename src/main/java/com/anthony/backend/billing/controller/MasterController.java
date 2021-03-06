/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.controller;

import com.anthony.backend.billing.entity.Master;
import com.anthony.backend.billing.service.MasterService;
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
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService service;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Master master) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(master));
    }

    @GetMapping("/findByCodGeneral")
    public ResponseEntity<Master> findByCodGeneral(@RequestParam String codGeneral) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByCodGeneral(codGeneral));
    }

    @GetMapping("/findAllMaster")
    public ResponseEntity<List<Master>> findAllMaster() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllMaster());
    }

}
