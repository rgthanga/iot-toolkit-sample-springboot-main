package com.telular.iot.controllers;

public class DeviceNotFoundException extends RuntimeException{

    DeviceNotFoundException(Long id) {
        super("Could not find device " + id);
      }

}
