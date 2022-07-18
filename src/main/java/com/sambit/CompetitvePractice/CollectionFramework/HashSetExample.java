package com.sambit.CompetitvePractice.CollectionFramework;

import java.util.HashSet;
import java.util.Scanner;

class MethodsForCase{
    Scanner scanner = new Scanner(System.in);
    HashSet<String> hashSet;
    int size;

//    For Case 1
    public String createHashSet(){
        System.out.println("Enter the size of HashSet ?");
        size = scanner.nextInt();
        hashSet  = new HashSet<>(size);

        return "HashSet Created Successfully, and Data Added to HashSet Successfully.";
    }

//    For Case 2
    public String insertIntoHashSet(){
        System.out.println("Enter Data For HashSet");
        for (int i = 1; i <= size; i++){
            System.out.println("Enter Data for HashSet as String.");
            String data = scanner.nextLine();
            hashSet.add(data);
        }
     return "Data Insertion Successfully";
    }

//    For Case 3
    public String updateIntoHashSet(){
       try {
           System.out.println("Enter Data to Check in HashSet");
           String dataForUpdate = scanner.nextLine();
           if (hashSet.contains(dataForUpdate)){
               hashSet.remove(dataForUpdate);
               System.out.println("Enter new Data for Update?");
               String newDataForUpdate = scanner.nextLine();
               hashSet.add(newDataForUpdate);
           }
           else
               System.out.println("Data Doesn't Present in HashSet!!");
       }catch (Exception e){
//           e.printStackTrace();
           System.out.println("HashSet Not Created Or Empty HashSet!!");
       }
        return "Data Updated Successfully";
    }

//    For Case 4
    public String deleteData(){
        System.out.println("Enter Data to Delete from HashSet?");
        String dataForDelete = scanner.nextLine();
        hashSet.remove(dataForDelete);
        return "Data Deletion Successfully";
    }

//    For Case 5
    public String displayData(){
        System.out.println("Displaying Data of HashSet are:");
        for(String displayData : hashSet){
            System.out.print(displayData + " , ");
        }
        return "Data Displayed Successfully.";
    }

//    For Case 6
    public String checkData(){
        System.out.println("Enter Data to check");
        String check = scanner.nextLine();
        if (hashSet.contains(check))
            System.out.println(check + "Present");
        else
            System.out.println(check + "Doesn't Present");
        return "Process End";
    }

//    For Case 7
    public String deleteAllData(){
        hashSet.clear();
        System.out.println(hashSet);
        return "Data Deletion Successfully";
    }
}


public class HashSetExample {
    public static void main(String[] args) {
        int choice = 0;
        MethodsForCase methodsForCase = new MethodsForCase();
        String message;
        while(choice != 9){
            System.out.println("<------menu------>");
            System.out.println("1. Create a HashSet.\n 2. Insert data to HashSet.\n 3. Update data in Hashset.\n 4. Delete data from HashSet\n 5. Print all data of HashSet.\n 6. Check data is present in HashSet\n 7. Delete all data of HashSet.\n 8. Exit. ");
            System.out.println("Enter Your Choice ?");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    message = methodsForCase.createHashSet();
                    System.out.println(message);
                    break;
                case 2:
                    message = methodsForCase.insertIntoHashSet();
                    System.out.println(message);
                    break;
                case 3:
                    message = methodsForCase.updateIntoHashSet();
                    System.out.println(message);
                    break;
                case 4:
                    message = methodsForCase.deleteData();
                    System.out.println(message);
                    break;
                case 5:
                    message = methodsForCase.displayData();
                    System.out.println(message);
                    break;
                case 6:
                    message = methodsForCase.checkData();
                    System.out.println(message);
                    break;
                case 7:
                    message = methodsForCase.deleteAllData();
                    System.out.println(message);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid inout");
            }
        }
    }
}
