package com.example.a125project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class defaultdict<K, V> extends HashMap<K, V> {

    Class<V> dd;
    public defaultdict(Class dd) {
        this.dd = dd;    
    }

    @Override
    public V get(Object key) {
        V returnValue = super.get(key);
        if (returnValue == null) {
            try {
                returnValue = dd.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            this.put((K) key, returnValue);
        }
        return returnValue;
    }    
}