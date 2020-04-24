package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> timeEntryValues = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(timeEntryValues.size() + 1);
        TimeEntry timeEntry1 = new TimeEntry(timeEntry.getId(), timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryValues.put(timeEntry.getId(), timeEntry1);
        return timeEntry1;
    }

    @Override
    public TimeEntry find(Long id) {
        return timeEntryValues.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryValues.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if(timeEntryValues.containsKey(id)) {
            timeEntry.setId(id);
            timeEntryValues.replace(id, timeEntry);
            return timeEntry;
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        timeEntryValues.remove(id);
    }


}
