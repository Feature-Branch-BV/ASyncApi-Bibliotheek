package nl.ind.gebeurtenissturingpoc.ledenviewservice.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.Objects;


public class LidVerwijderdPayload {
    
    private @Valid java.util.UUID id;
    

    

    /**
     * Unieke identificatie van het lid te verwijderen.
     */
    @JsonProperty("id")@NotNull
    public java.util.UUID getId() {
        return id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LidVerwijderdPayload lidVerwijderdPayload = (LidVerwijderdPayload) o;
        return 
            Objects.equals(this.id, lidVerwijderdPayload.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "class LidVerwijderdPayload {\n" +
        
                "    id: " + toIndentedString(id) + "\n" +
                "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
           return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}