package com.record.demo.Controller;

import com.record.demo.Services.ServiceCarro;
import com.record.demo.model.carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cars")
public class ControllerCarro {
    @Autowired
    ServiceCarro sc;

    @GetMapping("/hello")
    public String mensaje() {
        return "hola";
    }

    @GetMapping("/list_car")
    public ResponseEntity<LinkedList<carro>> ListcarResponseEntity(){
        LinkedList<carro> aux=sc.listcarro();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
    }

    @PostMapping("/created_car")
    public ResponseEntity<carro> createdcarResponseEntity(@RequestBody carro carInsert){
            sc.InsertCarro(
                    new carro(
                            carInsert.getId(),
                            carInsert.getNombre_carro(),
                            carInsert.getPuertas(),
                            carInsert.getModelo(),
                            carInsert.getMarca(),
                            carInsert.getColor()
                    )
            );
            return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update_car")
    public ResponseEntity<carro> UpdateCarResponseEntity(@RequestBody carro carUpdate){
        sc.UpdateCarro_id(carUpdate.getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
