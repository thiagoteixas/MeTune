package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Followers {
  private int user_id;
  private ArrayList<Integer> follows_id;

  public Followers() {
    this.user_id = -1;
    this.follows_id.add(-1);
  }

  public Followers(int user_id, Integer[] follows_id) {
    this.user_id = user_id;
    this.follows_id = new ArrayList<Integer>(Arrays.asList(follows_id));
  }
  
  public int getUserId() {
    return user_id;
  }

  public ArrayList<Integer> getFollowers() {
    return follows_id;
  }

  public void setUserId(int id) {
    this.user_id = id;
  }
  
  public void addToFollowerList(int id) {
    this.follows_id.add(id);
  }
  
  public void removeFollower(int id) {
    Iterator<Integer> followers = follows_id.iterator();
    while (followers.hasNext()) {
      if (followers.next().equals(id)) {
          followers.remove();
      }
    }
  }
}
