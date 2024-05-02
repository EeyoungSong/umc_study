package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.TempConverter;
import umc.study.service.TempService.TempQueryService;
import umc.study.web.dto.TempResponse;

@RestController // controller + responseBody
@RequestMapping("/temp") // url 맨 앞에 뭐가 올지 명시
@RequiredArgsConstructor // constructor 생성자를 만들어주겠다. -> 자동 의존 관계 주입의 핵심
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test") // get 메소드임
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());

    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
