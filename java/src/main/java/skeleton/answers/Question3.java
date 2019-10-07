package skeleton.answers;
import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Question3 
{
       public static int whereDidIFinish(int[] scores, int[] alice) 
       {
              int modal=0;
              int n = scores.length;
              int[] ranks = new int[n]; 
        
           
              for(int i=0, rank=1; i < n; i++)
              {
                     int s;
                     s=scores[i];
                     if(i > 0 && scores[i-1] != s)
                     rank++;
                     ranks[i] = rank;    
              }
        
              int aliceRank = ranks[ranks.length-1] + 1; 
              int leaderboardIndex = n-1;
              int m = alice.length;
        
              int prevScore = -1; 
              //int res[]=new int[m];
              //int p=0;
              
              for(int aliceScores=0; aliceScores < m; aliceScores++)
              {
                     int levelScore = alice[aliceScores];
         
                     for(int i = leaderboardIndex; i >= -1; i--)
                     {
                            if(i < 0 || scores[i] > levelScore)
                            {
                                   //res[p++]=aliceRank;
                                   modal+=aliceRank;
                                   break;
                            }
                            else if(scores[i] < levelScore)
                            {
                                   if(scores[i] != prevScore)//We have went up a ranking
                                   {
                                          aliceRank--;    
                                   }
                                          leaderboardIndex--;
                            }
                            else 
                            {
                                   leaderboardIndex--;
                                   aliceRank = ranks[i];
                     
                            }
                            prevScore = scores[i];
                     }
              }
    
              return (modal/m);

    }
}
