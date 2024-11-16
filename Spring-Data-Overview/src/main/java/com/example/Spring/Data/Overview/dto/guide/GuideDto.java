package com.example.Spring.Data.Overview.dto.guide;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideDto {

    private String staffId;
    private String name;
    private Integer salary;
}
