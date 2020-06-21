package com;
public final class App
{  //Main method reponsible for calling functions
        public static void main(String[] args) throws Exception
        {

          DAO dao=new DAO();
          for (Student stu : dao.getStudent())
           {
            System.out.println(stu.getId());
            System.out.println(stu.getFirstName());
            System.out.println(stu.getLastName());
            System.out.println(stu.getAge());
           }
        //dao.addStudent();
        //dao.updateStudent();
        //dao.deleteStudent();









        }

}

