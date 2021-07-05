package project.spring.dto.response;

import lombok.Data;

@Data
public class PerformanceResponseDto {
    private Long performanceId;
    private String performanceTitle;
    private String performanceDescription;
}
