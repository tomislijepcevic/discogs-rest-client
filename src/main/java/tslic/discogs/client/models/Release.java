package tslic.discogs.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import lombok.Data;

@Data
public class Release {

  private Integer id;

  private URI uri;

  private String title;

  private Integer year;

  private String country;

  private String notes;

  private String released;

  private String releasedFormatted;

  private String status;

  private String dataQuality;

  private Integer masterId;

  @JsonProperty("thumb")
  private URL thumbnail;

  private String dateChanged;

  private String dateAdded;

  private List<String> genres = new LinkedList<>();

  private List<String> styles = new LinkedList<>();

  private List<ReleaseArtist> artists = new LinkedList<>();

  @JsonProperty("extraartists")
  private List<ReleaseExtraArtist> extraArtists = new LinkedList<>();

  private List<ReleaseFormat> formats = new LinkedList<>();

  private List<Video> videos = new LinkedList<>();

  private List<Company> companies = new LinkedList<>();

  private List<ReleaseLabel> labels = new LinkedList<>();

  @JsonProperty("tracklist")
  private List<Track> tracks = new LinkedList<>();

  private List<Image> images = new LinkedList<>();

  // identifiers
}
