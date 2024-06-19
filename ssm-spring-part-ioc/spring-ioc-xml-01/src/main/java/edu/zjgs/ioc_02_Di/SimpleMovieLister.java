package edu.zjgs.ioc_02_Di;

public class SimpleMovieLister {

  private MovieFinder movieFinder;
  
  private String movieName;


  public void setMovieFinder(MovieFinder movieFinder) {
    this.movieFinder = movieFinder;
  }
  
  public void setMovieName(String movieName){
    this.movieName = movieName;
  }

  // business logic that actually uses the injected MovieFinder is omitted...
}