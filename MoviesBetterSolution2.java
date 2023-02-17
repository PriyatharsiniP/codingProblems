import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*Coding problem:
Alice has a list of movies to watch. Each movie can be of 1.01 to 3 units. In one day Alice can only spend 3 units of time to watch movies.
Find the number of days she spend to finish all movies.
Eg: [2.5, 1.04, 1.9, 1.75, 1.2]
On day 1, she will watch: 1.75 + 1.2 = 2.95
On day 2, she will watch: 2.5
On day 3, she will watch: 1.04 +1.9 = 2.94
So, the answer is 3 days.*/

public class MoviesBetterSolution2 {

	public static void main(String[] args) {
		double maxMovieDuration = 3.00;
		List<Double> watchedList = new ArrayList<>();
		List<Double> movieList= new ArrayList<>();
        movieList.add(1.01);
        movieList.add(2.4);
        movieList.add(1.5);
        movieList.add(1.6);
        movieList.add(2.6);
        movieList.add(1.7);
        findMinTime(movieList,maxMovieDuration,watchedList);		
	}

	private static void findMinTime(List<Double> movieList, double maxMovieDuration, List<Double> watchedList) {
		List<Double> sortedMovieList = movieList.stream().sorted().collect(Collectors.toList());//[1.01, 1.5, 1.6, 1.7, 2.4, 2.6], [2.6, 2.4, 2.71, 1.6, 1.5]
		int pointerOne = 0; //0
		int pointerTwo = sortedMovieList.size()-1;//4
		while(pointerOne < pointerTwo) {
			if( sortedMovieList.get(pointerOne)+sortedMovieList.get(pointerTwo) <= maxMovieDuration ) {
				watchedList.add(sortedMovieList.get(pointerOne)+sortedMovieList.get(pointerTwo));
				pointerOne++;
				pointerTwo--;			
			}else {
				watchedList.add(sortedMovieList.get(pointerTwo));
				pointerTwo--;				
			}
		}
		if(pointerOne==pointerTwo) {
			if(!watchedList.contains(sortedMovieList.get(pointerOne))) {
				watchedList.add(sortedMovieList.get(pointerOne));
			}
		}
		System.out.println(watchedList);
		System.out.println("Minimum days required: "+watchedList.size());	
	}
}
