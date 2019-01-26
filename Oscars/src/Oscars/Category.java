package Oscars;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Category{
    
    private String name;
    private final ArrayList<Movie> movies;
    
    public static ArrayList<Category> createCategories(String src){
        String sepCategory = ": ", sepMovies = ", ", sepSpecification = ". ";
        ArrayList<Category> list = new ArrayList();
        Scanner in;
        
        try {
            in = new Scanner(new FileInputStream(src));
            
            while(in.hasNext()){
                String temp = in.nextLine();
                String categoryName = temp.split(sepCategory)[0];
                String[] movies = temp.split(sepCategory)[1].split(sepMovies);
                
                list.add(new Category(categoryName));
                
                for(String i : movies){
                    String movieName = i.split(sepSpecification)[0];
                    String actorName = i.split(sepSpecification)[1];
                    list.get(list.size() - 1).movies.add(new Movie(movieName, actorName));
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        
        return list;
    }
    
    public Category(String name){
        this.name = name;
        movies = new ArrayList();
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public ArrayList<Movie> getMovies(){
        return movies;
    }
    
    @Override
    public String toString(){
        String buff = "";
        
        for(Movie m : movies){
            buff += "Movie: " + m.getName() + "\nActor: " + m.getActor() + "\n";
        }
        
        return buff;
    }
}