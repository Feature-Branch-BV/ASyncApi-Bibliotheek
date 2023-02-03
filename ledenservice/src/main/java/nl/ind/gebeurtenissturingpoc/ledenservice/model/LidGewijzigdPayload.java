package nl.ind.gebeurtenissturingpoc.ledenservice.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.Objects;


public class LidGewijzigdPayload {
    
    private @Valid java.util.UUID id;
    
    private @Valid String email;
    
    private @Valid String telefoonnummer;
    
    private @Valid String adres;
    

    

    /**
     * Unieke identificatie van het lid te wijzigen
     */
    @JsonProperty("id")
    public java.util.UUID getId() {
        return id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }
    

    /**
     * Email adres van het lid
     */
    @JsonProperty("email")@NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    /**
     * Telefoonnummer van het lid
     */
    @JsonProperty("telefoonnummer")@NotNull
    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }
    

    /**
     * Adres van het lid
     */
    @JsonProperty("adres")@NotNull
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LidGewijzigdPayload lidGewijzigdPayload = (LidGewijzigdPayload) o;
        return 
            Objects.equals(this.id, lidGewijzigdPayload.id) &&
            Objects.equals(this.email, lidGewijzigdPayload.email) &&
            Objects.equals(this.telefoonnummer, lidGewijzigdPayload.telefoonnummer) &&
            Objects.equals(this.adres, lidGewijzigdPayload.adres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, telefoonnummer, adres);
    }

    @Override
    public String toString() {
        return "class LidGewijzigdPayload {\n" +
        
                "    id: " + toIndentedString(id) + "\n" +
                "    email: " + toIndentedString(email) + "\n" +
                "    telefoonnummer: " + toIndentedString(telefoonnummer) + "\n" +
                "    adres: " + toIndentedString(adres) + "\n" +
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