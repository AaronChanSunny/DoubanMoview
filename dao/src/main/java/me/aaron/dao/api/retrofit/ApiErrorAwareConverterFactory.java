package me.aaron.dao.api.retrofit;

import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import me.aaron.dao.api.DoubanApiError;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class ApiErrorAwareConverterFactory extends Converter.Factory {

    private final EmptyJsonConverterFactory mEmptyJsonConverterFactory;

    public ApiErrorAwareConverterFactory(EmptyJsonConverterFactory emptyJsonConverterFactory) {
        mEmptyJsonConverterFactory = emptyJsonConverterFactory;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return mEmptyJsonConverterFactory.requestBodyConverter(type, annotations, retrofit);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        final Converter<ResponseBody, ?> apiErrorConverter =
                mEmptyJsonConverterFactory.responseBodyConverter(DoubanApiError.class,
                        annotations, retrofit);
        final Converter<ResponseBody, ?> delegateConverter =
                mEmptyJsonConverterFactory.responseBodyConverter(type, annotations,
                        retrofit);

        return new Converter<ResponseBody, Object>() {
            @Override
            public Object convert(ResponseBody value) throws IOException {
                MediaType mediaType = value.contentType();
                String stringBody = value.string();

                try {
                    Object apiError = apiErrorConverter
                            .convert(ResponseBody.create(mediaType, stringBody));
                    if (apiError instanceof DoubanApiError && ((DoubanApiError) apiError).isApiError()) {
                        throw (DoubanApiError) apiError;
                    }
                } catch (JsonSyntaxException notApiError) {
                }

                // then create a new ResponseBody for normal body
                return delegateConverter.convert(ResponseBody.create(mediaType, stringBody));
            }
        };
    }
}