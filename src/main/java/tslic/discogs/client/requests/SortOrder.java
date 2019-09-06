package tslic.discogs.client.requests;

public enum SortOrder {
  ASC,
  DESC;

  @Override
  public String toString() {
    return super.toString().toLowerCase();
  }
}
