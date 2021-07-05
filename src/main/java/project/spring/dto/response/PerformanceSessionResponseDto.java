package project.spring.dto.response;

import lombok.Data;

@Data
public class PerformanceSessionResponseDto {
    private Long performanceSessionId;
    private Long performanceId;
    private String performanceTitle;
    private Long theatreStageId;
    private String showTime;
}
