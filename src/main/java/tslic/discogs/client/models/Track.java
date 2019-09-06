package tslic.discogs.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedList;
import java.util.List;
import lombok.Data;

@Data
public class Track {

  private String title;

  private String duration;

  private String position;

  private List<TrackArtist> artists = new LinkedList<>();

  @JsonProperty("extraartists")
  private List<TrackExtraArtist> extraArtists = new LinkedList<>();
}
