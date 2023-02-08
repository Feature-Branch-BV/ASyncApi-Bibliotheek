package nl.ind.gebeurtenissturingpoc.ledenservice.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.Objects;


public class SentAt {
    
    private @Valid java.time.OffsetDateTime sentAt;
    

    

    /**
     * Datum en tijd dat bericht gestuurd is.
     */
    @JsonProperty("sentAt")@NotNull
    public java.time.OffsetDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(java.time.OffsetDateTime sentAt) {
        this.sentAt = sentAt;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SentAt sentAt = (SentAt) o;
        return 
            Objects.equals(this.sentAt, sentAt.sentAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentAt);
    }

    @Override
    public String toString() {
        return "class SentAt {\n" +
        
                "    sentAt: " + toIndentedString(sentAt) + "\n" +
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