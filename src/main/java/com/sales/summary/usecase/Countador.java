package com.sales.summary.usecase;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Countador {

    private int count;

    public Countador() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public int getAndAdd() {
        count += 1;
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
