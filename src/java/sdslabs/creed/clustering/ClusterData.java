public class ClusterData {

  List<String> clusterElementId;
  String type;
  int nextI = -1;
  Map<String, Float> centroidRating;
  Set<String> centroidBookmarks;
  Set<String> centroidLikes;
  Set<String> centroidSkips;
  Map<String, Integer> ratingCount;

  public ClusterData(String clusterId, String type){
    //initilaize the list clusterElementId
    
  }
  
  public ClusterData(String type){
    centroidRating = new HashMap<String, Float>();
    centroidBookmarks = new SortedSet<String>();
    centroidLikes = new SortedSet<String>();
    centroidSkips = new SortedSet<String>();
    ratingCount = new HashMap<String, Integer>();
  }


  public List<ClusterELement> getRandomCentroid(int number){
    Random rand = new Random();
    int i = rand.nextInt(clusterElement.size());
    List<ClusterElement> list = new ArrayList<ClusterElement>();
    list.add(new ClusterElement(clusterElementId.get(i), type);
    i = rand.nextInt(clusterElement.size());
    list.add(new ClusterElement(clusterElementId.get(i), type);
    return list;   
  }

  public void addElement(ClusterElement ele){
    clusterElementId.add(ele.getId());
    centroidBookmarks.addAll(ele.getKeys("bookmarks"));
    centroidLikes.addAll(ele.getKeys("likes"));
    centroidSkips.addAll(ele.getKeys("skips"));
    for(String key : ele.getKeys("rating")){
      if(centroidRating.containsKey(key)){
        centroidRating.put(key, centroidRating.get(key) + ele.getRating(key));
        ratingCount.put(key, ratingCount.get(key)+1);       
      }else{
        centroidRating.put(key, ele.getRating(key));
        ratingCount.put(key, 1);
      }
    }
  }

  public ClusterElement getCentroid(){
    for(Map.Entry<String, Float> entry : centroidRating.entrySet()){
      centroidRating.put(entry,getKey(), entry,getValue()/ratingCount.get(entry.getKey()));
    }
    ClusterElement centroid = new ClusterElement(type);
    centroid.setRating(centroidRating);
    centroid.setSkips(centroidSkips);
    centroid.setLikes(centroidLikes);
    centroid.setBookmarks(centroidBookmarks);
    return centroid;
  }

  public ClusterElement getNext(){
    nextI++;
    return new ClusterElement(clusterElementId.get(i), type);
  }


  public void reset(){
    clusterElementId.clear();
    centroidRating.clear();
    centroidSkips.clear();
    centroidLikes.clear();
    cenroidBookmarks.clear();
    ratingCount.clear();
  } 
  


}

