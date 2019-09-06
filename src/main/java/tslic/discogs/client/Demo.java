package tslic.discogs.client;

import tslic.discogs.client.requests.ArtistReleasesRequest;
import tslic.discogs.client.requests.MasterVersionsRequest;
import tslic.discogs.client.requests.PageRequest;
import tslic.discogs.client.requests.SearchRequest;
import tslic.discogs.client.requests.SearchRequest.SearchType;

public class Demo {

  public static void main(String[] args) {
    DiscogsClient client = DiscogsClient.authWithToken(System.getenv("DISCOGS_TOKEN"));

    //    artist(client);
    //    artistReleases(client);
    //    release(client);
    //    master(client);
    //    masterVersions(client);
    //    label(client);
    //    labelReleases(client);
    //    search(client);
  }

  private static void artist(DiscogsClient client) {
    System.out.println(client.artist(1));
  }

  private static void artistReleases(DiscogsClient client) {
    ArtistReleasesRequest request = new ArtistReleasesRequest();
    request.perPage(2);

    System.out.println(client.artistReleases(1, request));
  }

  private static void release(DiscogsClient client) {
    System.out.println(client.release(1));
  }

  private static void master(DiscogsClient client) {
    System.out.println(client.master(1));
  }

  private static void masterVersions(DiscogsClient client) {
    MasterVersionsRequest request = new MasterVersionsRequest();
    request.perPage(2);

    System.out.println(client.masterVersions(1, request));
  }

  private static void label(DiscogsClient client) {
    System.out.println(client.label(1));
  }

  private static void labelReleases(DiscogsClient client) {
    PageRequest request = new PageRequest();

    System.out.println(client.labelReleases(1, request));
  }

  private static void search(DiscogsClient client) {
    SearchRequest request = new SearchRequest();
    request.query("foo");
    request.type(SearchType.ARTIST);

    System.out.println(client.search(request));
  }
}
