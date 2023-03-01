package entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.JsonReadContext;

import javax.json.JsonArray;
import java.lang.reflect.Array;

@JsonIgnoreProperties({"page", "total_pages", "total_results"})
@JsonPropertyOrder({"results"})
public class Movie {
    private Array results;

    @JsonGetter("results")
    public Array getResults() {
        return results;
    }
    @JsonSetter("results")
    public void setResults(Array results) {
        this.results = results;
    }
}
