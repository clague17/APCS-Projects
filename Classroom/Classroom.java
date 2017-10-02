/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom;

/**
 *
 * @author LuisC
 */
public class Classroom {
    //Properties
    private int capacity;
    private int roomNumber;
    private String subject;
    private String teacher;
    
    //constructors
    //Classroom name = new Classroom();
    //the location will be the room number of the classroom.
    Classroom(int _capacity, int _roomNumber, String _subject, String _teacher){
        capacity = _capacity;
        roomNumber = _roomNumber;
        subject = _subject;
        teacher = _teacher;
    }
//getters for all other extensions of this class. 
    public int getCapacity(){
        return capacity;
    }
    
    public int getRoomNumber(){
        return roomNumber;
    }   
    
    public String getSubject(){
        return subject;
    }
    
    public String getTeacher(){
        return teacher;
    }
    
    //methods
    public String toString(){
        return "Your " +subject+ " class, taught by " +teacher+ " can hold " +capacity+
                " students and is located in room " +roomNumber;
    }
    
    public String atCapacity(int numOfStudents){
       
        if (numOfStudents< capacity ){
            return ("The classroom still has vacancies.");
        } else if (numOfStudents==capacity){
            return ("The classroom is full, it's at capacity.");
        }else{
            return ("The classroom is overflowing! Too many people!");
        }
        
    }
    
    public int floor(){
        //the location constructor defined earlier will be a room number (i.e. 27), strictly a number with no letters.
        int floor1 =15;
        int floor2 = 30;
        int floor3 = 45;
        int floor4 = 60; // its a pretty big building, with total 60 rooms and 15 rooms per floor. 
        
        if (roomNumber>0 && roomNumber<15){
            return 1;
        } else if (roomNumber>floor1 && roomNumber<floor2){
            return 2;
        } else if (roomNumber>floor2 && roomNumber<floor3){
            return 3;
        } else if (roomNumber>floor3 && roomNumber<floor4){
            return 4;
        }
    }
    
    public boolean coreClass(String _english, String _math, String _science){
        //English, Math, Science
        if (subject.equals(_english)){
            return true;
        } else if (subject.equals(_math)){
            return true;
        } else if (subject.equals(_science)){
            return true;
        } else {
            return false;
        }
    }
}
    
