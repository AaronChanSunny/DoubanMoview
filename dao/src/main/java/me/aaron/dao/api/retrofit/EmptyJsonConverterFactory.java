package me.aaron.dao.api.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class EmptyJsonConverterFactory extends Converter.Factory {

    private final GsonConverterFactory mGsonConverterFactory;

    public EmptyJsonConverterFactory(GsonConverterFactory gsonConverterFactory) {
        mGsonConverterFactory = gsonConverterFactory;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return mGsonConverterFactory.requestBodyConverter(type, annotations, retrofit);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        final Converter<ResponseBody, ?> delegateConverter = mGsonConverterFactory.responseBodyConverter(type, annotations, retrofit);

        return value -> {
            if (value.contentLength() == 0) return null;
            return delegateConverter.convert(value);
        };
    }
}