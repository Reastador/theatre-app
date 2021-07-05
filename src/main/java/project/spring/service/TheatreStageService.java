package project.spring.service;

import java.util.List;
import project.spring.model.TheatreStage;

public interface TheatreStageService {
    TheatreStage add(TheatreStage theatreStage);

    TheatreStage get(Long id);

    List<TheatreStage> getAll();
}
