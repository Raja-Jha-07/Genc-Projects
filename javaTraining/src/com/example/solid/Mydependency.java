package com.example.solid;

public class Mydependency {
    public static void main(String[] args) {
        Repo repo = new Repository();
        Service service =new Service(repo);
        service.print("tushar");
    }
}
class Service {
    private Repo repo;
   public Service(Repo repo) {
        this.repo=repo;
    }
  
  void print(String name){
    repo.print(name);
  }
}
interface Repo {
    void print(String name);
}

class Repository implements Repo {
    public void print(String name) {
        System.out.println(name);
    }
}
