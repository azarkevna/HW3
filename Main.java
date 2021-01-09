package com.student.tasks;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("#Q1");
        System.out.println(sortString("bdcs aab aaa aaaad aaaaz abcd"));


        System.out.println("#Q2");
        System.out.println("correct password: " + checkPassw("abcd"));
        System.out.println("correct password: " + checkPassw("A1b@cdCD"));
        System.out.println("correct password: " + checkPassw("A1b@cdC%"));
        System.out.println("correct password: " + checkPassw("A1b@cdC"));

        System.out.println("#Q3");
        System.out.println(addLongInt("12345","49265"));
        System.out.println(addLongInt("12345","999999"));
        System.out.println(addLongInt("143753453223445734","76543322334487238"));

        System.out.println("#Q4");
        printAnagram("AngereD Table Pat eNraged letter taP ATP atpk");
        printAnagram("Table stRing letter");

        System.out.println("#Q5");
        System.out.println(selectCorrectEmails("aaa@bbb.com aaaa aaa@bbb.ccc.tmp aaa@aaa.temp aaa@bbb test@gmail.com","tmp aaa.temp"));

        System.out.println("#Q6");
        Person[] array={new Student("David",18,"java ppl c# db"),
                new StudentInstructor("Avi",12,"java ppl db",2,"c#"),
                new Student("Moty",20,"ppl c# db math"),new Student("Tali",12,"java db"),
                new StudentInstructor("Nensi",18,"ppl c# db",4,"java"),new Student("Ronit",24,"ppl db java math c#"), new Worker("Natan",42,"electrician"),new Worker("Fima",40,"worker"),
                new Professor("Alona",18,"java db network"), new Professor("Marina",12,"ppl"),
                new WorkerInstructor("Vlad",40,"it_project_manager",8,"testing db"),
                new WorkerInstructor("Guy",20,"engineer",8,"testing c#"),
                new Instructor("Yael",6,"logics c#"), new ProfessorInstructor("Michael",3,"c#",7,"java ppl")};

        printCourse(array,"java");
        print2MaxHoursPresent(array);
        System.out.println("max teaching hours:");
        returnMaxTeachHours(array).print();
        System.out.println("Course Teach hours: "+ sumCourseTeachHours(array,"java"));
        System.out.println("Course Students amount: "+ countCourseStudents(array,"java"));







    }

    public static boolean isinArray (String [] b, String a) {
      return   Arrays.asList(b).contains(a);

    }
    public static String sortString(String string1) {
        String[] elements = string1.split(" ");
        String temp;


        for (int i = 0; i < elements.length - 1; i ++) {
            for (int j = 0; j < elements.length - i - 1; j++) {
                if (elements[j].length() > elements[j + 1].length()) {
                    temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;


                }
                if (elements[j].length() == elements[j + 1].length()) {
                    String temp2;
                    if (elements[j].compareTo(elements[j + 1]) > 0) {
                        temp2 = elements[j + 1];
                        elements[j + 1] = elements[j];
                        elements[j] = temp2;
                    }
                }
            }
        }
        return Arrays.toString(elements);
    }


    public static boolean checkPassw(String password) {


        int digit = 0;
        int special = 0;
        int upCount = 0;
        int loCount = 0;
        int otherCount =0;
        if (password.length() <= 7) {
            System.out.println("short password");
        }

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);

                if (Character.isUpperCase(c)) {
                        upCount++;
                    }
                if (Character.isLowerCase(c)) {
                        loCount++;
                    }
                if (Character.isDigit(c)) {
                        digit++;
                    }
                if (c == 33 || c == 35 || c == 36 || c == 64) {
                        special++;
                    }
            if (!(Character.isUpperCase(c) || Character.isLowerCase(c) || Character.isDigit(c) || c== 33 || c ==35 || c== 36 ||c==64)) {
                otherCount ++;
            }



                }

            if (upCount == 0) {
                System.out.println("no capital letters");
            }
            if (loCount == 0) {
                System.out.println("no lower case letters");
            }

            if (digit == 0) {
                System.out.println("no digits");
            }

            if (special == 0) {
                System.out.println("no symbols");
            }

            if (otherCount != 0) {
                System.out.println("has other symbols");
            }





            return special >= 1 && loCount >= 1 && upCount >= 1 && digit >= 1 && otherCount ==0 && password.length()>7;
    }

    public static String addLongInt(String a, String b) {
        return Long.toString(Long.parseLong(a) + Long.parseLong(b));

    }



   public static void printAnagram(String string) {
        String [] words = string.split(" ");
       String  [] anagram  = new String[words.length];
       int anagram_count = 0;

       for (int i = 0; i < words.length - 1; i++ ) {
           int local_anagramcount = anagram_count;

           for (int j = i + 1; j < words.length; j++) {

               if (words[i].length() == words[j].length()) {


                   char[] arr1 = words[i].toLowerCase().toCharArray();
                   char[] arr2 = words[j].toLowerCase().toCharArray();

                   Arrays.sort(arr1);
                   Arrays.sort(arr2);

                   if (Arrays.equals(arr1, arr2)) {
                       if (!(isinArray(anagram,words[i]))) {
                           anagram[anagram_count] = words[i];
                           System.out.printf("%s ", words[i]);
                           anagram_count++;
                       }

                       if (!(isinArray(anagram,words[j]))) {
                           anagram[anagram_count] = words[j];
                           System.out.printf("%s ", words[j]);
                           anagram_count++;
                       }
                   }




               }
           }

           if (local_anagramcount != anagram_count){
               System.out.println(" ");
           }

       }

       if (anagram_count ==0) {
           System.out.println("Anagram not found");
       }

   }

   public static String selectCorrectEmails (String emails, String  blacklist) {
       String [] arr_emails = emails.split(" ");
       String [] arr_blacklist = blacklist.split(" ");
       String good_emails = "";

       for (String arr_email : arr_emails) {
           if (arr_email.contains("@")) {
               String suf = arr_email.substring(arr_email.indexOf("@"));
               if (suf.contains(".")) {
                   int count = 0;
                   for (String s : arr_blacklist) {
                       if (suf.contains(s)) {
                           count++;
                       }
                   }
                   if (count == 0) {
                       good_emails = good_emails + " " + arr_email;
                   }

               }
           }
       }
      return good_emails;
   }

   public static void printCourse (Person [] array, String course) {
        System.out.println("Teachers:");
       for (Person person : array) {
           if (person instanceof Professor || person instanceof Instructor || person instanceof StudentInstructor || person instanceof WorkerInstructor || person instanceof ProfessorInstructor) {
               if (isinArray(((ICourse) person).getCourse_list().split(" "), course)) {
                   person.print();
               }

           }
       }

        System.out.println("Students:");
       for (Person person : array) {
           if (person instanceof Student) {
               if (isinArray(((ILearning) person).getCourse_list().split(" "), course)) {
                   person.print();
               }
           }
       }


   }

   public static void print2MaxHoursPresent (Person [] array) {
        Person temp;
       for (int i = 0; i < array.length - 1; i ++) {
           for (int j = 0; j < array.length - i - 1; j++) {
               if (((IHours)array[j]).hoursinCollege() >((IHours)array[j+1]).hoursinCollege()) {
                   temp = array[j];
                   array[j] = array[j + 1];
                   array[j + 1] = temp;
               }


           }
       }
       System.out.println("Max hours present:");
       array[array.length-1].print();
       array[array.length-2].print();
    }

    public static Person returnMaxTeachHours (Person [] array) {
        Person max = array[0];
        int maxhours = 0;

        for (int i = 0; i < array.length - 1; i ++) {
            if (array[i] instanceof Professor || array[i] instanceof Instructor || array[i] instanceof StudentInstructor || array[i] instanceof ProfessorInstructor || array[i] instanceof WorkerInstructor) {

                if (((ICourse) array[i]).teachingLoad() > maxhours) {
                    max = array[i];
                    maxhours = ((ICourse) array[i]).teachingLoad();
                }
            }
        }


        return max;

    }

    public static int sumCourseTeachHours (Person [] array, String course) {
        int sumHours = 0;
        for (Person person : array) {
            if (person instanceof Professor || person instanceof Instructor || person instanceof StudentInstructor || person instanceof WorkerInstructor || person instanceof ProfessorInstructor) {
                if (isinArray(((ICourse) person).getCourse_list().split(" "), course)) {
                    sumHours = sumHours + ((ICourse)person).teachingLoad();
                }

            }
        }
       return sumHours;
    }

    public static int countCourseStudents (Person [] array, String course) {
        int count = 0;
        for (Person person : array) {
            if (person instanceof Student || person instanceof StudentInstructor) {
                if (isinArray(((ILearning) person).getCourse_list().split(" "), course)) {
                    count++;
                }

            }
        }
        return count;
    }





}








