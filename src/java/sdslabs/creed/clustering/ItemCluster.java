public class ItemClustering {

  private List<ClusterElement> centroid;
  private float weight[4];
 
  public ItemClustering(){


  }

  public List<ClusterData> cluster(ClusterData data){
    
    //get two ramdom centroids
    
    //@iterate: until not much differnce between centroids
      //@iterate: through each cluster data
        //calculate similarity with centroid1
        //calculate similarity with centroid2
        //accd put the item into particular cluster
        //do some calculation required for new centroid calculation
      //we have the new calculated centroids as well in the previous iteration

    //return the two cluster
       
    //*******************************************//

    centroid = data.getRandomCentroid(2);
    List<ClusterElement> prevCentroid = new ArrayList<ClusterElement>();
    List<ClusterData> newCluster = new ArrayList<ClusterData>();
    ClusterData cluster1 = new ClusterData("item");
    ClusterDAta cluster2 = new ClusterData("item");
    newCluster.add(cluster1);
    newCluster.add(cluster2);

    while(compare(prevCentroid.get(0), prevCentroid.get(1)) == false ){
      ClusterElement ele;
      newCluster.get(0).reset();
      newCluster.get(1).reset();
      while(ele = data.getNext()){
        newCluster.get(similarity(ele)).addElement(ele);
      }
      prevCentroid.add(0, centroid.get(0));
      prevCentroid.add(1, centroid.get(1));
      centroid.add(0, newCluster.get(0).getCentroid());
      centroid.add(1, newCluster.get(1).getCentroid());
    }

    return newCluster;
  }

  private boolean compare(ClusterElement ele1, ClusterElement ele2 ){
    ClusterElement tempEle = ele1.clone();
    tempEle.intersection(centroid.get(0).getKeys("rating"), "rating");
    float meanE;
    float meanC;
    float meanCE;
    float meanC2;
    float meanE2;
    float meanEmC2;

    int noOfElement1 = 0;
    
    for(String entry : tempELe.getKeys("rating")){
      float eleRating = tempEle.getRating(entry);
      float centRating = centroid.get(0).getRating(entry);
      meanE += eleRating;
      meanC += centRating;
      meanCE += eleRating*centRating;
      meanC2 += centRating*centRating;
      meanE2 += eleRating*eleRating;
      meanEmC2 += (eleRating - centRating)*(eleRating - centRating);
      noOfElement1++;
    }
    
    float cent1Sim = weight[0]*(0.5*(noOfElement1*meanCE[0] - meanE[0]*meanC[0]) / Math.sqrt((noOfElement1*meanE2[0] - meanE[0]*meanE[0])*(noOfElement1*meanC2[0] - meanC[0]*meanC[0])) + 0.5*Math.sqrt(meanEmC2[0]);

    int unionSize = tempEle.unionSize(centroid.get(0).getKeys("likes"), "likes");
    int intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("likes"), "likes");
    cent1Sim +=  weight[1]*unionSize/intersectionSize;
    
    unionSize = tempEle.unionSize(centroid.get(0).getKeys("bookmark"), "bookmark");
    intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("bookmark"), "bookmark");
    cent1Sim +=  weight[2]*unionSize/intersectionSize;

    unionSize = tempEle.unionSize(centroid.get(0).getKeys("skips"), "skips");
    intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("skips"), "skips");
    cent1Sim +=  weight[3]*unionSize/intersectionSize;

    tempEle = ele2.clone();
    tempEle.intersection(centroid.get(1).getKeys("rating"), "rating");
    float meanE;
    float meanC;
    float meanCE;
    float meanC2;
    float meanE2;
    float meanEmC2;

    int noOfElement1 = 0;
    
    for(String entry : tempELe.getKeys("rating")){
      float eleRating = tempEle.getRating(entry);
      float centRating = centroid.get(1).getRating(entry);
      meanE += eleRating;
      meanC += centRating;
      meanCE += eleRating*centRating;
      meanC2 += centRating*centRating;
      meanE2 += eleRating*eleRating;
      meanEmC2 += (eleRating - centRating)*(eleRating - centRating);
      noOfElement1++;
    }
    
    float cent2Sim = weight[0]*(0.5*(noOfElement1*meanCE[0] - meanE[0]*meanC[0]) / Math.sqrt((noOfElement1*meanE2[0] - meanE[0]*meanE[0])*(noOfElement1*meanC2[0] - meanC[0]*meanC[0])) + 0.5*Math.sqrt(meanEmC2[0]);

    int unionSize = tempEle.unionSize(centroid.get(1).getKeys("likes"), "likes");
    int intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("likes"), "likes");
    cent2Sim +=  weight[1]*unionSize/intersectionSize;
    
    unionSize = tempEle.unionSize(centroid.get(1).getKeys("bookmark"), "bookmark");
    intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("bookmark"), "bookmark");
    cent2Sim +=  weight[2]*unionSize/intersectionSize;

    unionSize = tempEle.unionSize(centroid.get(1).getKeys("skips"), "skips");
    intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("skips"), "skips");
    cent2Sim +=  weight[3]*unionSize/intersectionSize;

    if(cent1Sim > 0.8 &&  cent2Sim > 0.8){
      return true;
    }else{
      return false;
    }
  }
     
    

  }
  
  private int similarity(ClusterElement ele){

    //rating calculation
    ClusterElement tempEle = ele.clone();
    tempEle.intersection(centroid.get(0).getKeys("rating"), "rating");
    float meanE;
    float meanC;
    float meanCE;
    float meanC2;
    float meanE2;
    float meanEmC2;

    int noOfElement1 = 0;
    
    for(String entry : tempELe.getKeys("rating")){
      float eleRating = tempEle.getRating(entry);
      float centRating = centroid.get(0).getRating(entry);
      meanE += eleRating;
      meanC += centRating;
      meanCE += eleRating*centRating;
      meanC2 += centRating*centRating;
      meanE2 += eleRating*eleRating;
      meanEmC2 += (eleRating - centRating)*(eleRating - centRating);
      noOfElement1++;
    }
    
    float cent1Sim = weight[0]*(0.5*(noOfElement1*meanCE[0] - meanE[0]*meanC[0]) / Math.sqrt((noOfElement1*meanE2[0] - meanE[0]*meanE[0])*(noOfElement1*meanC2[0] - meanC[0]*meanC[0])) + 0.5*Math.sqrt(meanEmC2[0]);

    int unionSize = tempEle.unionSize(centroid.get(0).getKeys("likes"), "likes");
    int intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("likes"), "likes");
    cent1Sim +=  weight[1]*unionSize/intersectionSize;
    
    unionSize = tempEle.unionSize(centroid.get(0).getKeys("bookmark"), "bookmark");
    intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("bookmark"), "bookmark");
    cent1Sim +=  weight[2]*unionSize/intersectionSize;

    unionSize = tempEle.unionSize(centroid.get(0).getKeys("skips"), "skips");
    intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("skips"), "skips");
    cent1Sim +=  weight[3]*unionSize/intersectionSize;

    tempEle = ele.clone();
    tempEle.intersection(centroid.get(1).getKeys("rating"), "rating");
    float meanE;
    float meanC;
    float meanCE;
    float meanC2;
    float meanE2;
    float meanEmC2;

    int noOfElement1 = 0;
    
    for(String entry : tempELe.getKeys("rating")){
      float eleRating = tempEle.getRating(entry);
      float centRating = centroid.get(1).getRating(entry);
      meanE += eleRating;
      meanC += centRating;
      meanCE += eleRating*centRating;
      meanC2 += centRating*centRating;
      meanE2 += eleRating*eleRating;
      meanEmC2 += (eleRating - centRating)*(eleRating - centRating);
      noOfElement1++;
    }
    
    float cent2Sim = weight[0]*(0.5*(noOfElement1*meanCE[0] - meanE[0]*meanC[0]) / Math.sqrt((noOfElement1*meanE2[0] - meanE[0]*meanE[0])*(noOfElement1*meanC2[0] - meanC[0]*meanC[0])) + 0.5*Math.sqrt(meanEmC2[0]);

    int unionSize = tempEle.unionSize(centroid.get(1).getKeys("likes"), "likes");
    int intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("likes"), "likes");
    cent2Sim +=  weight[1]*unionSize/intersectionSize;
    
    unionSize = tempEle.unionSize(centroid.get(1).getKeys("bookmark"), "bookmark");
    intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("bookmark"), "bookmark");
    cent2Sim +=  weight[2]*unionSize/intersectionSize;

    unionSize = tempEle.unionSize(centroid.get(1).getKeys("skips"), "skips");
    intersectionSize = tempEle.intersectionSize(centroid.get(0).getKeys("skips"), "skips");
    cent2Sim +=  weight[3]*unionSize/intersectionSize;

    if(cent1Sim > cent2Sim){
      return 0;
    }else{
      return 1;
    }
  }

}























