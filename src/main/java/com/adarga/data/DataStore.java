package com.adarga.data;

import com.adarga.domain.Metric;
import com.adarga.domain.Tracker;

import java.util.ArrayList;

/**
 * Created by Chris on 6/14/2017.
 */
public interface DataStore {

    //TODO: Consider a better solution than this default no-op method body.
    static DataStore getInstance() {
        return null;
    };

    ArrayList<Metric> getAllMetrics();

    void addMetric(Metric m);

    Tracker getTracker();
}
