package nl.zwennesm.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Map;

@Table("product")
public class Product {

    @PrimaryKey
    private String sku;
    private Map<String, Integer> recommendations;

    public Product() {}

    @JsonCreator
    public Product(@JsonProperty("sku") String sku, @JsonProperty("recommendations") Map<String, Integer> recs) {
        this.sku = sku;
        this.recommendations = recs;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Map<String, Integer> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(Map<String, Integer> recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public String toString() {
        return String.format("Product[sku=%s, recommendations=%s]", this.sku, this.recommendations);
    }
}
