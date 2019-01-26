package Oscars;

class Movie{
    String name, actor;
    
    public Movie(String name, String actor){
        this.name = name;
        this.actor = actor;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setActor(String actor){
        this.actor = actor;
    }
    
    public String getActor(){
        return this.actor;
    }
}