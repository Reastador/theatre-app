package project.spring.service.mapper;

import project.spring.dto.request.TheatreStageRequestDto;
import project.spring.dto.response.TheatreStageResponseDto;
import project.spring.model.TheatreStage;
import org.springframework.stereotype.Component;

@Component
public class TheatreStageMapper implements RequestDtoMapper<TheatreStageRequestDto, TheatreStage>,
        ResponseDtoMapper<TheatreStageResponseDto, TheatreStage> {
    @Override
    public TheatreStage mapToModel(TheatreStageRequestDto dto) {
        TheatreStage theatreStage = new TheatreStage();
        theatreStage.setDescription(dto.getDescription());
        theatreStage.setCapacity(dto.getCapacity());
        return theatreStage;
    }

    @Override
    public TheatreStageResponseDto mapToDto(TheatreStage theatreStage) {
        TheatreStageResponseDto responseDto = new TheatreStageResponseDto();
        responseDto.setId(theatreStage.getId());
        responseDto.setDescription(theatreStage.getDescription());
        return responseDto;
    }
}
