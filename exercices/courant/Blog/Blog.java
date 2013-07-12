

import java.util.ArrayList;
import java.util.List;

public class Blog {

  private List<Post> posts;

  public Blog() {
    posts = new ArrayList<Post>();
  }

  public boolean publish(String auteur, String message) {
    return posts.add(new Post(auteur, message, System.currentTimeMillis()));
  }

  public List<Post> getPosts() {
    return posts;
  }

  public Post getPost(int i) {
    return posts.get(i);
  }

  public boolean removePost(Post p) {
    return posts.remove(p);
  }

  public List<Post> getPostsBefore(long date) {
    List<Post> p = new ArrayList<>();
    for (int i = 0; i < posts.size(); i++) {
      Post post = getPost(i);
      if (post.getDate() < date) {
        p.add(post);
      }
    }
    return p;
  }

  public List<Post> getPostsAfter(long date) {
    List<Post> p = new ArrayList<>();
    for (int i = 0; i < posts.size(); i++) {
      Post post = getPost(i);
      if (post.getDate() > date) {
        p.add(post);
      }
    }
    return p;
  }

  public List<Post> getPostsFrom(String auteur) {
    List<Post> p = new ArrayList<>();
    for (int i = 0; i < posts.size(); i++) {
      Post post = getPost(i);
      if (post.getAuteur().equals(auteur)) {
        p.add(post);
      }
    }
    return p;
  }

}
