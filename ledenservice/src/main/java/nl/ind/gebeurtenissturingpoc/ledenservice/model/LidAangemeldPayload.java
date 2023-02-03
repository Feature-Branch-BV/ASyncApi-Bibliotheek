package nl.ind.gebeurtenissturingpoc.ledenservice.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.Objects;


public class LidAangemeldPayload {
    
    private @Valid java.util.UUID id;
    
    private @Valid String naam;
    
    private @Valid String email;
    
    private @Valid String telefoonnummer;
    
    private @Valid String adres;
    
    private @Valid java.time.LocalDate geboortedatum;
    
    private @Valid java.time.OffsetDateTime sentAt;
    

    

    /**
     * Unieke identificatie van het lid te registreren
     */
    @JsonProperty("id")@NotNull
    public java.util.UUID getId() {
        return id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }
    

    /**
     * De naam van het lid
     */
    @JsonProperty("naam")@NotNull
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
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
    

    /**
     * Geboortedatum van het lid
     */
    @JsonProperty("geboortedatum")@NotNull
    public java.time.LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(java.time.LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }
    

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
        LidAangemeldPayload lidAangemeldPayload = (LidAangemeldPayload) o;
        return 
            Objects.equals(this.id, lidAangemeldPayload.id) &&
            Objects.equals(this.naam, lidAangemeldPayload.naam) &&
            Objects.equals(this.email, lidAangemeldPayload.email) &&
            Objects.equals(this.telefoonnummer, lidAangemeldPayload.telefoonnummer) &&
            Objects.equals(this.adres, lidAangemeldPayload.adres) &&
            Objects.equals(this.geboortedatum, lidAangemeldPayload.geboortedatum) &&
            Objects.equals(this.sentAt, lidAangemeldPayload.sentAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, email, telefoonnummer, adres, geboortedatum, sentAt);
    }

    @Override
    public String toString() {
        return "class LidAangemeldPayload {\n" +
        
                "    id: " + toIndentedString(id) + "\n" +
                "    naam: " + toIndentedString(naam) + "\n" +
                "    email: " + toIndentedString(email) + "\n" +
                "    telefoonnummer: " + toIndentedString(telefoonnummer) + "\n" +
                "    adres: " + toIndentedString(adres) + "\n" +
                "    geboortedatum: " + toIndentedString(geboortedatum) + "\n" +
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