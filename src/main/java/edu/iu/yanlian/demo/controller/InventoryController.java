package edu.iu.yanlian.demo.controller;

import edu.iu.yanlian.demo.model.Guitar;
import edu.iu.yanlian.demo.repository.InventoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/guitar")
public class InventoryController {

    private InventoryRepository inventoryRepository;
    public InventoryController(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addGuitar(@RequestBody Guitar guitar) {
        inventoryRepository.addGuitar(guitar.getSerialNumber(), guitar.getPrice(),
                guitar.getBuilder(), guitar.getModel(), guitar.getType(),
                guitar.getBackWood(), guitar.getTopWood());
        return new ResponseEntity<>("Guitar added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Guitar>> searchGuitars(
            @RequestParam(required = false) String serialNumber,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String topWood,
            @RequestParam(required = false) String builder,
            @RequestParam(required = false) String backWood) {
        Guitar searchGuitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        Guitar foundGuitar = inventoryRepository.search(searchGuitar);
        if (foundGuitar != null) {
            return new ResponseEntity<>(Collections.singletonList(foundGuitar), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find/{serialNumber}")
    public ResponseEntity<Guitar> getGuitar(@PathVariable String serialNumber) {
        Guitar guitar = inventoryRepository.getGuitar(serialNumber);
        if (guitar != null) {
            return new ResponseEntity<>(guitar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
