package com.wings.wrapper;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<T> {
    
    private boolean status;

    private List<String> messages = new ArrayList<>();

    private T payload;
}
