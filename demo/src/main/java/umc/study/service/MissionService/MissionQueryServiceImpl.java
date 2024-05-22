package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissionRequest;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{
    private final MissionRepository missionRepository;

    @Override
    public boolean existById(Long id){
        return missionRepository.existsById(id);
    }
}
