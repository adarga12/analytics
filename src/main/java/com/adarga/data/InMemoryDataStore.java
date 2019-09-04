package com.adarga.data;

import com.adarga.domain.Goal;
import com.adarga.domain.Record;
import com.adarga.domain.Tracker;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

/**
 * A Singleton in memory collection of Goals and Records, encapsulated by a Tracker.
 * Created by cbolton on 6/9/17.
 */
@Repository
public class InMemoryDataStore implements DataStore {
    private ArrayList<Record> records;
    private static DataStore dataStore;
    private Tracker tracker;
    private ArrayList<Tracker> trackers;

    private InMemoryDataStore(){
        records = new ArrayList<>();
        initializeRecords();
    }

    public static DataStore getInstance() {
        if (InMemoryDataStore.dataStore == null) {
            InMemoryDataStore.dataStore = new InMemoryDataStore();
        }
        return InMemoryDataStore.dataStore;
    }

    private void initializeRecords() {
        Goal goal = new Goal(0, 10.0f, "Cardio", "Minutes spent on cardiovascular exercise");
        records.add(new Record(0, 5.2f, "minutes", new DateTime(2019,6,13,11,33)));
        records.add(new Record(0, 7.6f, "minutes", new DateTime(2019,7,4,10,45)));
        records.add(new Record(0, 8.1f, "minutes", new DateTime(2019,7,19,13,12)));
        records.add(new Record(0, 2.98f, "minutes", new DateTime(2019,8,5,15,26)));
        records.add(new Record(0, 3.1f, "minutes", new DateTime(2019,9,2,9,8)));
        tracker = new Tracker(goal, records);
        trackers = new ArrayList<>();
        trackers.add(tracker);
    }

    @Override
    public ArrayList<Record>getAllRecords() {
        return records;
    }

    @Override
    public void addRecord(Record m) {
        records.add(m);
    }

    @Override
    public ArrayList<Tracker> getTrackers() {
        return trackers;
    }

    @Override
    public Tracker getTracker(int goalId) {
        Optional<Tracker> optional = trackers.stream().filter(t -> t.getGoal().getId() == goalId).findFirst();
        return optional.orElse(null);
    }

    @Override
    public void addGoal(Goal g) {
        Tracker tracker = new Tracker(g);
        trackers.add(tracker);
    }

}
