
package org.example.lesson4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aisles",
    "cost",
    "startDate",
    "endDate"
})
@Generated("jsonschema2pojo")
@Data
public class ResponseList {

    @JsonProperty("aisles")
    private List<Aisle> aisles = new ArrayList<Aisle>();
    @JsonProperty("cost")
    private Double cost;
    @JsonProperty("startDate")
    private Integer startDate;
    @JsonProperty("endDate")
    private Integer endDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

//    @JsonProperty("aisles")
//    public List<Aisle> getAisles() {
//        return aisles;
//    }
//
//    @JsonProperty("aisles")
//    public void setAisles(List<Aisle> aisles) {
//        this.aisles = aisles;
//    }
//
//    public ResponseList() {
//    }
//
//    @JsonProperty("cost")
//    public Double getCost() {
//        return cost;
//    }
//
//    @JsonProperty("cost")
//    public void setCost(Double cost) {
//        this.cost = cost;
//    }
//
//    @JsonProperty("startDate")
//    public Integer getStartDate() {
//        return startDate;
//    }
//
//    @JsonProperty("startDate")
//    public void setStartDate(Integer startDate) {
//        this.startDate = startDate;
//    }
//
//    @JsonProperty("endDate")
//    public Integer getEndDate() {
//        return endDate;
//    }
//
//    @JsonProperty("endDate")
//    public void setEndDate(Integer endDate) {
//        this.endDate = endDate;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "aisle",
            "items"
    })
    @Generated("jsonschema2pojo")
    @Data
    private class Aisle {

        @JsonProperty("aisle")
        private String aisle;
        @JsonProperty("items")
        private List<Item> items = new ArrayList<Item>();
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        public Aisle() {
        }

        @JsonProperty("aisle")
        public String getAisle() {
            return aisle;
        }

        @JsonProperty("aisle")
        public void setAisle(String aisle) {
            this.aisle = aisle;
        }

        @JsonProperty("items")
        public List<Item> getItems() {
            return items;
        }

        @JsonProperty("items")
        public void setItems(List<Item> items) {
            this.items = items;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "id",
                "name",
                "measures",
                "pantryItem",
                "aisle",
                "cost",
                "ingredientId"
        })
        @Generated("jsonschema2pojo")
        @Data
        private class Item {

            @JsonProperty("id")
            private Integer id;
            @JsonProperty("name")
            private String name;
            @JsonProperty("measures")
            private Measures measures;
            @JsonProperty("pantryItem")
            private Boolean pantryItem;
            @JsonProperty("aisle")
            private String aisle;
            @JsonProperty("cost")
            private Double cost;
            @JsonProperty("ingredientId")
            private Integer ingredientId;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

            public Item() {
            }

            @JsonProperty("id")
            public Integer getId() {
                return id;
            }

            @JsonProperty("id")
            public void setId(Integer id) {
                this.id = id;
            }

            @JsonProperty("name")
            public String getName() {
                return name;
            }

            @JsonProperty("name")
            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty("measures")
            public Measures getMeasures() {
                return measures;
            }

            @JsonProperty("measures")
            public void setMeasures(Measures measures) {
                this.measures = measures;
            }

            @JsonProperty("pantryItem")
            public Boolean getPantryItem() {
                return pantryItem;
            }

            @JsonProperty("pantryItem")
            public void setPantryItem(Boolean pantryItem) {
                this.pantryItem = pantryItem;
            }

            @JsonProperty("aisle")
            public String getAisle() {
                return aisle;
            }

            @JsonProperty("aisle")
            public void setAisle(String aisle) {
                this.aisle = aisle;
            }

            @JsonProperty("cost")
            public Double getCost() {
                return cost;
            }

            @JsonProperty("cost")
            public void setCost(Double cost) {
                this.cost = cost;
            }

            @JsonProperty("ingredientId")
            public Integer getIngredientId() {
                return ingredientId;
            }

            @JsonProperty("ingredientId")
            public void setIngredientId(Integer ingredientId) {
                this.ingredientId = ingredientId;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonPropertyOrder({
                    "original",
                    "metric",
                    "us"
            })
            @Generated("jsonschema2pojo")
            @Data
            private class Measures {

                @JsonProperty("original")
                private Original original;
                @JsonProperty("metric")
                private Metric metric;
                @JsonProperty("us")
                private Us us;
                @JsonIgnore
                private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

                public Measures() {
                }

                @JsonProperty("original")
                public Original getOriginal() {
                    return original;
                }

                @JsonProperty("original")
                public void setOriginal(Original original) {
                    this.original = original;
                }

                @JsonProperty("metric")
                public Metric getMetric() {
                    return metric;
                }

                @JsonProperty("metric")
                public void setMetric(Metric metric) {
                    this.metric = metric;
                }

                @JsonProperty("us")
                public Us getUs() {
                    return us;
                }

                @JsonProperty("us")
                public void setUs(Us us) {
                    this.us = us;
                }

                @JsonAnyGetter
                public Map<String, Object> getAdditionalProperties() {
                    return this.additionalProperties;
                }

                @JsonAnySetter
                public void setAdditionalProperty(String name, Object value) {
                    this.additionalProperties.put(name, value);
                }

                @JsonInclude(JsonInclude.Include.NON_NULL)
                @JsonPropertyOrder({
                        "amount",
                        "unit"
                })
                @Generated("jsonschema2pojo")
                @Data
                private class Original {

                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("unit")
                    private String unit;
                    @JsonIgnore
                    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

                    @JsonProperty("amount")
                    public Double getAmount() {
                        return amount;
                    }

                    public Original() {
                    }

                    @JsonProperty("amount")
                    public void setAmount(Double amount) {
                        this.amount = amount;
                    }

                    @JsonProperty("unit")
                    public String getUnit() {
                        return unit;
                    }

                    @JsonProperty("unit")
                    public void setUnit(String unit) {
                        this.unit = unit;
                    }

                    @JsonAnyGetter
                    public Map<String, Object> getAdditionalProperties() {
                        return this.additionalProperties;
                    }

                    @JsonAnySetter
                    public void setAdditionalProperty(String name, Object value) {
                        this.additionalProperties.put(name, value);
                    }
                }
                @JsonInclude(JsonInclude.Include.NON_NULL)
                @JsonPropertyOrder({
                        "amount",
                        "unit"
                })
                @Generated("jsonschema2pojo")
                @Data
                private class Metric {

                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("unit")
                    private String unit;
                    @JsonIgnore
                    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

                    @JsonProperty("amount")
                    public Double getAmount() {
                        return amount;
                    }

                    public Metric() {
                    }

                    @JsonProperty("amount")
                    public void setAmount(Double amount) {
                        this.amount = amount;
                    }

                    @JsonProperty("unit")
                    public String getUnit() {
                        return unit;
                    }

                    @JsonProperty("unit")
                    public void setUnit(String unit) {
                        this.unit = unit;
                    }

                    @JsonAnyGetter
                    public Map<String, Object> getAdditionalProperties() {
                        return this.additionalProperties;
                    }

                    @JsonAnySetter
                    public void setAdditionalProperty(String name, Object value) {
                        this.additionalProperties.put(name, value);
                    }

                }
                @JsonInclude(JsonInclude.Include.NON_NULL)
                @JsonPropertyOrder({
                        "amount",
                        "unit"
                })
                @Generated("jsonschema2pojo")
                @Data
                private class Us {

                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("unit")
                    private String unit;
                    @JsonIgnore
                    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

                    @JsonProperty("amount")
                    public Double getAmount() {
                        return amount;
                    }

                    public Us() {
                    }

                    @JsonProperty("amount")
                    public void setAmount(Double amount) {
                        this.amount = amount;
                    }

                    @JsonProperty("unit")
                    public String getUnit() {
                        return unit;
                    }

                    @JsonProperty("unit")
                    public void setUnit(String unit) {
                        this.unit = unit;
                    }

                    @JsonAnyGetter
                    public Map<String, Object> getAdditionalProperties() {
                        return this.additionalProperties;
                    }

                    @JsonAnySetter
                    public void setAdditionalProperty(String name, Object value) {
                        this.additionalProperties.put(name, value);
                    }

                }
                }}}}
