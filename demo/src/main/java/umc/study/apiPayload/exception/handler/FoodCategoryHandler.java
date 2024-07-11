package umc.study.apiPayload.exception.handler;

import com.fasterxml.jackson.databind.ser.Serializers;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) { super(errorCode); }
}
