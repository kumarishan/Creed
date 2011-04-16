public class ClusterElement {
  
  private Set<String> ratingKeys;
  private Set<String> bookmarks;
  private Set<String> likes;
  private Set<String> skips;
  private Map<String, Float> ratings;
  private String id;

  public ClusterElement(String id, String form){

    //call cassandra and intialize it here ----- three casandra calls
  }

  public ClusterElement(String form){


  }

  public void setRating(Map<String, Float> rating){
    ratingKeys = rating.keySet();
    ratings = rating;
  }

  public void setBookmarks(Set<String> bookmarks){
    this.bookmarks = bookmarks;
  }

  public void setLikes(Set<String> likes){
   this.likes = likes;
  }

  public void setSkips(Set<String> skips){
    this.skips = skips;
  }

  public String getId(){
    return id;
  }

  public void intersection(Set<String> keys, String category){
    if(category.compareTo("rating") == 0){
      ratingKeys.retainAll(keys);
    }else if( category.compareTo("likes") == 0){
      likes.retainAll(keys);
    }else if( category.compareTo("bookmarks") == 0){
      bookmarks.retainAll(keys);
    }else if( category.compareTo("skips") == 0){
      skips.retainAll(keys);
    }  
  }

  public float getRating(String key){
    return ratings.get(key);      
  }

  public Set<String> getKeys(String category){
    if(category.compareTo("rating") == 0){
      return ratingKeys;
    }else if(category.compareTo("bookmarks") == 0){
      return bookmarks;
    }else if(category.compareTo("likes") == 0){
      return likes;
    }else if(category.compareTo("skips") == 0){
      return skips;
    }
  }

  public int intersectionSize(Set<String> keys, String category){
    if(category.compareTo("bookmarks") == 0){
      Set<String> temp = bookmarks.clone();
      temp.retainAll(keys);
      return temp.size();
    }else if(category.compareTo("likes") == 0){
      Set<String> temp = likes.clone();
      temp.retainAll(keys);
      return temp.size()
    }else if(category.compareTo("skips") == 0){
      Set<String> temp = skips.clone();
      temp.retainAll(keys);
      return temp.size()
    }

  }

  public int unionSize(Set<String> keys, String category){
    if(category.compareTo("bookmarks") == 0){
      Set<String> temp = bookmarks.clone();
      temp.addAll(keys);
      return temp.size();
    }else if(category.compareTo("likes") == 0){
      Set<String> temp = likes.clone();
      temp.addAll(keys);
      return temp.size()
    }else if(category.compareTo("skips") == 0){
      Set<String> temp = skips.clone();
      temp.addAll(keys);
      return temp.size()
    }

  }

}
