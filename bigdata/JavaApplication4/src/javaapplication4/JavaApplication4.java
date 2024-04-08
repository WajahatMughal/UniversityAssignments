/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author admin
 */
public class JavaApplication4 {

    
    public static void main(String[] args) {
         List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

        List<String> words = Arrays.asList("Math", "Computer", "Life science");

        int sum = 0;
        for (int no : numbers) {
            sum = sum + no;
        }
        System.out.println(sum);

        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);

        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);
      Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceSumWithMethodReference.get());

        Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(mulResult);
       Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxvalue);

        Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxvalueWithMethodReference);

         String longestString = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(longestString);

        //get student whose grade A
        //get marks
        
        double avgMarks = StudentDatabase.getStudents().stream()
                
                .filter(student -> student.getGrade().equalsIgnoreCase("A"))
                .map(student -> student.getMarks())
                .mapToDouble(i -> i)
                .average().getAsDouble();

        System.out.println(avgMarks);

        double sumMarks = StudentDatabase.getStudents().stream()
                .filter(student -> student.getGrade().equalsIgnoreCase("A"))
                .map(student -> student.getMarks())
                .mapToDouble(i -> i)
                .sum();
        
       
    }


}





