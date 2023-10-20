 //https://leetcode.com/problems/find-center-of-star-graph/
class Solution {
    public int findCenter(int[][] edges) {
        int [] indegree = new int[edges.length+2];
        for(int [] arr: edges){
            int u = arr[0];
            int v = arr[1];
            indegree[u]++;
            indegree[v]++;
        }
        for(int i = 1; i < indegree.length; i++){
             if(indegree[i] == edges.length){
                 return i;
             }
        }
        return -1
    }
}
