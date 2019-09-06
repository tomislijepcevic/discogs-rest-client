package tslic.discogs.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.logging.LoggingFeature;
import tslic.discogs.client.models.Artist;
import tslic.discogs.client.models.ArtistReleases;
import tslic.discogs.client.models.Label;
import tslic.discogs.client.models.LabelReleases;
import tslic.discogs.client.models.Master;
import tslic.discogs.client.models.MasterVersions;
import tslic.discogs.client.models.Release;
import tslic.discogs.client.models.SearchResults;
import tslic.discogs.client.requests.ArtistReleasesRequest;
import tslic.discogs.client.requests.MasterVersionsRequest;
import tslic.discogs.client.requests.PageRequest;
import tslic.discogs.client.requests.SearchRequest;

public class DiscogsClient {

  private static final String DISCOGS_API_URL = "https://api.discogs.com/";

  private final WebTarget webTarget;

  public DiscogsClient() {
    JacksonJaxbJsonProvider jacksonProvider = new JacksonJaxbJsonProvider();
    jacksonProvider.setMapper(
        new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES));

    Client client = ClientBuilder.newClient(new ClientConfig().register(jacksonProvider));

    Logger logger = Logger.getLogger(getClass().getName());
    client.register(new LoggingFeature(logger, Level.ALL, null, null));

    webTarget = client.target(DISCOGS_API_URL);
  }

  private DiscogsClient(Authorization authorization) {
    this();

    webTarget.register(authorization);
  }

  public Release release(int releaseId) {
    return webTarget
        .path("releases/" + releaseId)
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(Release.class);
  }

  public Master master(int masterId) {
    return webTarget
        .path("masters/" + masterId)
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(Master.class);
  }

  public Artist artist(int artistId) {
    return webTarget
        .path("artists/" + artistId)
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(Artist.class);
  }

  public Label label(int labelId) {
    return webTarget
        .path("labels/" + labelId)
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(Label.class);
  }

  public MasterVersions masterVersions(int masterId) {
    return masterVersions(masterId, null);
  }

  public MasterVersions masterVersions(int masterId, MasterVersionsRequest request) {
    if (request == null) {
      request = new MasterVersionsRequest();
    }

    return webTarget
        .path(String.format("masters/%d/versions", masterId))
        .queryParam("page", request.page())
        .queryParam("per_page", request.perPage())
        .queryParam("format", request.format())
        .queryParam("label", request.label())
        .queryParam("released", request.released())
        .queryParam("country", request.country())
        .queryParam("sort", request.sort())
        .queryParam("sort_order", request.sortOrder())
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(MasterVersions.class);
  }

  public ArtistReleases artistReleases(int artistId) {
    return artistReleases(artistId, null);
  }

  public ArtistReleases artistReleases(int artistId, ArtistReleasesRequest request) {
    if (request == null) {
      request = new ArtistReleasesRequest();
    }

    return webTarget
        .path(String.format("artists/%d/releases", artistId))
        .queryParam("field", request.sort())
        .queryParam("order", request.sortOrder())
        .queryParam("page", request.page())
        .queryParam("per_page", request.perPage())
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(ArtistReleases.class);
  }

  public LabelReleases labelReleases(int labelId) {
    return labelReleases(labelId, null);
  }

  public LabelReleases labelReleases(int labelId, PageRequest request) {
    if (request == null) {
      request = new PageRequest();
    }

    return webTarget
        .path(String.format("labels/%d/releases", labelId))
        .queryParam("page", request.page())
        .queryParam("per_page", request.perPage())
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(LabelReleases.class);
  }

  public SearchResults search(SearchRequest request) {
    return webTarget
        .path("database/search")
        .queryParam("page", request.page())
        .queryParam("per_page", request.perPage())
        .queryParam("query", request.query())
        .queryParam("type", request.type())
        .queryParam("title", request.title())
        .queryParam("release_title", request.releaseTitle())
        .queryParam("credit", request.credit())
        .queryParam("artist", request.artist())
        .queryParam("anv", request.anv())
        .queryParam("label", request.label())
        .queryParam("genre", request.genre())
        .queryParam("style", request.style())
        .queryParam("country", request.country())
        .queryParam("year", request.year())
        .queryParam("format", request.format())
        .queryParam("catno", request.catno())
        .queryParam("barcode", request.barcode())
        .queryParam("track", request.track())
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(SearchResults.class);
  }

  public static DiscogsClient authWithToken(String token) {
    return new DiscogsClient(new Authorization(String.format("Discogs token=%s", token)));
  }

  public static DiscogsClient authWithKeySecret(String key, String secret) {
    return new DiscogsClient(
        new Authorization(String.format("Discogs key=%s, secret=%s", key, secret)));
  }

  public static class Authorization implements ClientRequestFilter {

    private final String credentials;

    private Authorization(String credentials) {
      this.credentials = credentials;
    }

    public void filter(ClientRequestContext requestContext) {
      requestContext.getHeaders().add("Authorization", credentials);
    }
  }
}
