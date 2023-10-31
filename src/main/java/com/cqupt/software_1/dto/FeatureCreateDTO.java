package com.cqupt.software_1.dto;


import com.cqupt.software_1.entity.RangeSplit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureCreateDTO {

    private String type;
    private String name;
    private String num;
    private String range;
    private List<RangeSplit> rangeSplit;

}
