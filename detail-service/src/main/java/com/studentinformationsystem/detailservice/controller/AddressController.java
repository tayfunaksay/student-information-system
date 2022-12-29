package com.studentinformationsystem.detailservice.controller;

import com.studentinformationsystem.detailservice.dto.address.AddressDto;
import com.studentinformationsystem.detailservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.detailservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.detailservice.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddressDto> create(@RequestBody CreateAddressRequest request) {
        return ResponseEntity.ok(addressService.create(request));
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
