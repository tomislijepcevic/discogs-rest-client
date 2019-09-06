package tslic.discogs.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import java.net.URL;
import lombok.Data;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
  @Type(value = ArtistSearchResult.class, name = "artist"),
  @Type(value = MasterSearchResult.class, name = "master"),
  @Type(value = ReleaseSearchResult.class, name = "release"),
  @Type(value = LabelSearchArtist.class, name = "label"),
})
@Data
public abstract class SearchResult {

  private Integer id;

  private URI uri;

  private String title;

  @JsonProperty("thumb")
  private URL thumbnail;

  private URL coverImage;
}
