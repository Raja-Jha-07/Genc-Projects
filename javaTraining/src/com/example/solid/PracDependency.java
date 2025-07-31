package com.example.solid;

import java.util.*;
//--------------------------------->
// public class PracDependency {
//     public static void main(String args[]) {
//         Sql sql = new Sql();
//         System.out.println(sql.getproduct());
//     }
// }

// class Sql {
//     public List<String> getproduct() {
//         return Arrays.asList("shampoo", "apple");
//     }
// }


//---------------------------------------->
//factory pattern
// class RepoFactory {
//   public static ProductRepository create() {
//     return new Sql();
//   }
// }

// //high module
// public class PracDependency {
//   private ProductRepository productRepository;

//   public PracDependency() {
//     // IoC: Factory creates the dependency
//     // this.productRepository = RepoFactory.create();
//     this.productRepository=new Sql();
//   }

//   public void show() {
//     System.out.println(productRepository.getProduct());
//   }

//   public static void main(String[] args) {
//     PracDependency prac = new PracDependency();
//     prac.show();
//   }
// }

// //abstraction layer
// interface ProductRepository {
//   List<String> getProduct();
// }

// //lower module
// class Sql implements ProductRepository {
//   @Override
//   public List<String> getProduct() {
//     return Arrays.asList("shampoo", "apple");
//     //["shampoo","apple"]
//   }
// }

//---------------------------------------------->
// public class PracDependency {
//   private ProductRepository productRepository;

//   public PracDependency(ProductRepository productRepository) {
//     this.productRepository = productRepository;
//   }

//   public void show() {
//     System.out.println(productRepository.getProduct());
//   }

//   public static void main(String args[]) {
//     ProductRepository productRepository = RepoFactory.create();
//     PracDependency pracDependency = new PracDependency(productRepository);
//     pracDependency.show();

//   }
// }

// class RepoFactory {
//   public static ProductRepository create() {
//     return new Sql();
//   }
// }

// //abstraction layer
// interface ProductRepository {
//   List<String> getProduct();
// }

// //lower module
// class Sql implements ProductRepository {
//   @Override
//   public List<String> getProduct() {
//     return Arrays.asList("shampoo", "apple");
//     //["shampoo","apple"]
//   }
// }
