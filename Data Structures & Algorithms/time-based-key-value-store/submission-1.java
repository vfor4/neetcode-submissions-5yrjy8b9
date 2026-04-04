class TimeMap {


    private record TimeRecord(String value, int timestamp) {
    }

    private final Map<String, List<TimeRecord>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        final var timeRecordValues = new ArrayList<TimeRecord>();
        timeRecordValues.add(new TimeRecord(value, timestamp));
        map.merge(key, timeRecordValues, (oldValue, newValue) -> {
            oldValue.addAll(newValue);
            return oldValue;
        });
    }

    public String get(String key, int timestamp) {
        return binarySearch(map.getOrDefault(key, List.of()), timestamp);
    }

    private String binarySearch(final List<TimeRecord> records, final int target) {
        var left = 0;
        var right = records.size() - 1;
        var mostRecent = "";
        while (left <= right) {
            var mid = left + (right - left) / 2;
            var record = records.get(mid);
            var timestamp = record.timestamp();
            if (timestamp == target) {
                return record.value();
            } else if (target > timestamp) {
                left = mid + 1;
                mostRecent = record.value();
            } else {
                right = mid - 1;
            }
        }
        return mostRecent;
    }
}
