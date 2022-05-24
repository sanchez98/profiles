package com.sanchez.project.profile.utils;

import org.springframework.lang.Nullable;

public interface MockAPI<T> {

    T get(String url, Class<T> responseType);

    T post(String url, Object request, Class<T> responseType);
}
