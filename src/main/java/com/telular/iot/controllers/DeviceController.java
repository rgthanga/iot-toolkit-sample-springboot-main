package com.telular.iot.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.telular.iot.repositories.DeviceRepository;
import java.util.List;
import com.telular.iot.entities.Device;

@RestController
public class DeviceController {
    private final DeviceRepository repository;


    DeviceController(DeviceRepository repository) {
        this.repository = repository;
      }

    // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/devices")
  List<Device> all() {
    return repository.findAll();
  }

  // end::get-aggregate-root[]

  @PostMapping("/devices")
  Device newDevice(@RequestBody Device newDevice) {
    return repository.save(newDevice);
  }

  // Single item

    @GetMapping("/health-check")

  String getHealthCheck() {

    return "Success";

  }
  
  @GetMapping("/devices/{id}")
  Device one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new DeviceNotFoundException(id));
  }

  @PutMapping("/devices/{id}")
  Device replaceDevice(@RequestBody Device newDevice, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(device -> {
        device.setDeviceStatus(device.getDeviceStatus());
        return repository.save(device);
      })
      .orElseGet(() -> {
        newDevice.setDeviceID(id);
        return repository.save(newDevice);
      });
  }

  @DeleteMapping("/devices/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
    
}
