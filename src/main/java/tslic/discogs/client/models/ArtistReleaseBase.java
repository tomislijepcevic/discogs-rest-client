package tslic.discogs.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URL;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = ArtistRelease.class)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ArtistRelease.class, name = "releases"),
  @JsonSubTypes.Type(value = ArtistMaster.class, name = "master")
})
public abstract class ArtistReleaseBase extends ReleaseSummary {

  private String artist;

  private Integer year;

  private String role;

  @JsonProperty("thumb")
  private URL thumbnail;
}
