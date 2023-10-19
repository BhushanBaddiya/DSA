  //https://leetcode.com/problems/asteroid-collision/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> st = new Stack<>();
		for(int asteroid : asteroids){
			if(asteroid >= 0){
				//no treat to stable universe
				st.push(asteroid);
			 }else{
					//try to destroy as much as asteroid moving towards right
					while(st.size() > 0 && st.peek() >= 0 && st.peek() < -1*asteroid){
						//destroy peek person
						st.pop();
					}
					if(st.size() > 0 && st.peek() > 0 && st.peek() > -1*asteroid){
						// dont do any thing because incoming asteroid destroying
					}else if(st.size() > 0 && st.peek() > 0 && st.peek() == -1*asteroid){
						//when incoming astroid same as peek astroid destroy each other so pop() 
						st.pop();
					}else{
						st.push(asteroid);
					}
			   }
		}
		int n = st.size();
		int[] arr = new int[n];
		for(int i =n-1; i >= 0; i--){
			arr[i] = st.pop();
		}
		return arr;
    }
}
