package com.sales.summary.usecase;

import com.sales.summary.domain.Summary;

import java.util.UUID;

public interface GetOutputResult {

    Summary execute(UUID uuid);

}
