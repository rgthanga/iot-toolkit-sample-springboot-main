package com.telular.iot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telular.iot.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}
