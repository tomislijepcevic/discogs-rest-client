package tslic.discogs.client.models;

import java.util.List;
import lombok.Data;

@Data
public class MasterVersions {

  private Pagination pagination;

  private List<MasterVersion> versions;
}
