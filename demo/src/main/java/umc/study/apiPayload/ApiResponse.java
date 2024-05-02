package umc.study.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.apiPayload.code.BaseCode;
import umc.study.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"}) // 이 순서대로
public class ApiResponse<T> {

    @JsonProperty("isSuccess") // 필드 값 지정
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL) // null값이 아닐 때 반환
    private T result; // result 마다 DTO가 다르기 때문에 타입도 다 다름


    // 성공한 경우 응답 생성

    public static <T> ApiResponse<T> onSuccess(T result){ //제너릭 매서드 - static이기 때문에 제너릭으로 클래스 생성과 무관하게 쓸 수 있도록 타입 명시
        return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result){
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }


    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(false, code, message, data);
    }
}
