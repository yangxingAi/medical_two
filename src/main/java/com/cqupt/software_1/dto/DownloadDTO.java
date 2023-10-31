package com.cqupt.software_1.dto;


import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Data
public class DownloadDTO {


    private Set<Integer> satisfiedSamples;
    private String tableName;
}
