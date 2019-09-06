# discogs-rest-client

Discogs rest-client written using JAX-RS client.

Demo:

```java
public class Demo {

  public static void main(String[] args) {
    DiscogsClient client = DiscogsClient.authWithToken(token);
    // or DiscogsClient client = DiscogsClient.authWithKeySecret(key, secret);
    
    System.out.println(client.artist(1));
  }
}
```

More examples are in Demo class.
