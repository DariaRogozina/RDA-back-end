package org.example.lesson4;

import java.util.LinkedHashMap;
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
        "username",
        "firstName",
        "lastName",
        "email"
})
@Generated("jsonschema2pojo")
@Data
public class UserForm {

    @JsonProperty("username")
    private String username;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public UserForm(String dashaR, String rogoz, String dasha, String s) {
    }

//    @JsonProperty("username")
//    public String getUsername() {
//        return username;
//    }
//
//    @JsonProperty("username")
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @JsonProperty("firstName")
//    public String getFirstName() {
//        return firstName;
//    }
//
//    @JsonProperty("firstName")
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    @JsonProperty("lastName")
//    public String getLastName() {
//        return lastName;
//    }
//
//    @JsonProperty("lastName")
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @JsonProperty("email")
//    public String getEmail() {
//        return email;
//    }
//
//    @JsonProperty("email")
//    public void setEmail(String email) {
//        this.email = email;
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

}


