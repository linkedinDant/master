

import java.util.ArrayList;
import java.util.List;

public class BlogManager {

  private Blog blog;
  private List<String> users;
  
  public BlogManager() {
    this(new Blog());
  }
  
  public BlogManager(Blog blog) {
    this.blog = blog;
    users = new ArrayList<String>();
  }
  
  public void addUser(String user) {
    users.add(user);
  }
  
  public List<Post> getPosts() {
    return blog.getPosts();
  }
  
  public boolean publish(String user, String message) {
    if(false == users.contains(user)) {
      return false;
    }
    return blog.publish(user, message);
  }
  
}
