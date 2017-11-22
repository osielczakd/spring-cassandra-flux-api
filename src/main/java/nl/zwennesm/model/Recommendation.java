package nl.zwennesm.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.Map;

@Table("product")
public class Recommendation {

    @PrimaryKey
    private String sku;
    private List<Long> recommendations;

    public Recommendation() {}

    @JsonCreator
    public Recommendation(@JsonProperty("sku") String sku, @JsonProperty("recommendations") List<Long> recs) {
        this.sku = sku;
        this.recommendations = recs;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<Long> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Long> recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public String toString() {
        return String.format("Product[sku=%s, recommendations=%s]", this.sku, this.recommendations);
    }
}
