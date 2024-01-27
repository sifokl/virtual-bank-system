package com.banking.system.vsbank.api.rest;

import com.banking.system.vsbank.api.constants.RestConstants;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;

@RestController
@CrossOrigin("*")
@Produces((RestConstants.CONTENT_TYPE_APPLICATION_JSON))
@RequestMapping("/vsbank/v1/")
public interface MasterInterfaceRest {
}

