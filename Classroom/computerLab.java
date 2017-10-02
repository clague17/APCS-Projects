/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom;

/**
 *
 * @author LuisC
 * 
 */
public class computerLab extends Classroom{
    private int computers;
    public computerLab(int _computers, int _roomNumber, String _subject, String _teacher, int _capacity) {
        super(_capacity, _roomNumber, _subject, _teacher);
        computers = _computers;
    }
    
    public int getComputers(){
        return computers;
    }
    
    public String toString(){
        return "The computer lab has "+ computers+" and is in room "+getRoomNumber() +"and is a " +
                getSubject() +" class taught by "+ getTeacher();
    }
    
    public String remainingComputers(){
        int difference = computers - getCapacity();
        if (difference >=0){
            return "There are " + difference + "remaining computers.";
        }else {
            return "There are "+ difference*-1+ "remaining students without computers.";
        }
    }
}
