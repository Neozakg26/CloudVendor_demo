package com.example.cloudVendordemo.controller;

import com.example.cloudVendordemo.model.CloudVendor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class CloudAPIService {

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId) {
        return new CloudVendor("123",
                "Neo", "Home",
                "072 phone number");
    }

}
