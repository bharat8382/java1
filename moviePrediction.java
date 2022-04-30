package DAY1;

import java.util.*;
public class moviePrediction{
    static Movie[] train_data = new Movie[4];
    static {
        train_data[0] = new Movie("Action",100,0);
        train_data[1] = new Movie("Comedy",0,100);
        train_data[2] = new Movie("Action",90,17);
        train_data[3] = new Movie("Comedy",21,80);
    }
    static class Movie{
        private String category;
        final int action_scenes;
        final int comedy_scenes;
        Movie(String category,int action_scenes, int comedy_scenes){
            this.category = category;this.action_scenes = action_scenes;this.comedy_scenes = comedy_scenes;
        }
        void setCategory(String category){
            this.category = category;
        }
    }
    static int getEuclideanDistance(int x1,int x2,int y1,int y2){
        x1 = x1 - x2; y1 = y1 - y2;
        double d1 = Math.pow(x1,2);
        double d2 = Math.pow(y1,2);
        d1 = d1 + d2;
        d1 = Math.pow(d1,2);
        return (int) (d1);
    }
    static String predictMovieCategory(Movie movie){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0;i< train_data.length;i++){
            int dis = getEuclideanDistance(movie.action_scenes,train_data[i].action_scenes,
                    movie.comedy_scenes,train_data[i].comedy_scenes);
            if (dis < min){
                min = dis;
                minIndex = i;
            }
        }
        return train_data[minIndex].category;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Number of movies to predict: ");
        int n = input.nextInt();
        Movie[] movies = new Movie[n];
        for (int i = 0;i<n;i++)
            System.out.println(moviePrediction.predictMovieCategory(new Movie("TBD",input.nextInt(),input.nextInt())));
    }
}
