package io.imagekit.sdk.tasks;

public class QueryMaker {
    private final StringBuilder query = new StringBuilder();

    public void put(String q) {
        if (query.length() != 0) {
            query.append("&");
        }
        query.append(q);
    }

    public String get() {
        return query.toString();
    }

    public String getAsQueryString() {
        return "?" + get();
    }
}
