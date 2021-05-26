/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author E-rinGZ
 */
class User {
    private String idnumber, studentnumber, lastname, firstname, middlename,
            course,cellphone,email;
   
    public User(String idnumber, String studentnumber, String lastname, String firstname, String middlename, String course, String cellphone, String email)
    {
        this.idnumber=idnumber;
        this.studentnumber=studentnumber;
        this.lastname=lastname;
        this.firstname=firstname;
        this.middlename=middlename;
        this.course = course;
        this.cellphone = cellphone;
        this.email = email;              
    }       
    public String getidnumber(){
        return idnumber;
    }
    public String getstudentnumber(){
        return studentnumber;
    }
    public String getlastname(){
        return lastname;
    }
    public String getfirstname(){
        return firstname;
    }
    public String getmiddlename(){
        return middlename;
    }
    public String getcourse(){
        return course;
    }
    public String getcellphone(){
        return cellphone;
    }
    public String getemail(){
        return email;
    }
}
