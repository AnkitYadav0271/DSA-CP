class Solution {

    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<String>();
        
        Backtrack(s,path);

        return res;
    }

    public void Backtrack(String s , List<String> path){
     if( s.length() == 0){
       res.add(new ArrayList<>(path));
     }

    for(int i = 1; i <= s.length(); i++ ){
      String choice = s.substring(0,i);

      if (!isPalindrome(choice)){
       continue;
       }

      path.add(choice);

      Backtrack(s.substring(i),path);
      path.remove(path.size()-1);
   }
  }


  public static boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}

}