class Solution
{
    //Function to find the level of node X.
    //https://practice.geeksforgeeks.org/problems/level-of-nodes-1587115620/1
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        if(X == 0){
            return 0;
        }
        boolean [] vis = new boolean[V];
        Queue<Integer>q = new LinkedList<>();
        q.add(0);
        int level = 0;
        while(q.size() != 0){
           int size = q.size();
            while(size != 0){
               int ele = q.poll();
               if(ele == X){
                 return level;  
               }
                 vis[ele] = true;
                 for(int nbr:adj.get(ele)){
                   if(vis[nbr] != true){
                       q.add(nbr);
                    }
                 }
                 size--;
            }
           level++;
        }
        return -1;
    }
}
