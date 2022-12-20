package com.studentinformationsystem.registrarservice.controller;

import com.studentinformationsystem.registrarservice.dto.address.AddressDto;
import com.studentinformationsystem.registrarservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.registrarservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.registrarservice.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddressDto> create(@RequestBody CreateAddressRequest request) {
        return ResponseEntity.ok(addressService.create(request));
    }
    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> delete(@PathVariable String addressId) {
        addressService.delete(addressId);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update")
    public ResponseEntity<AddressDto> update(@RequestBody UpdateAddressRequest request) {
        return ResponseEntity.ok(addressService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AddressDto>> getAll() {
        return ResponseEntity.ok(addressService.getAll());

    }
    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDto> getById(@PathVariable String addressId) {
        return ResponseEntity.ok(addressService.getById(addressId));
    }

}
