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
public class building extends computerLab{
    private int totalCapacity;
    private int totalComputers;
    private String[] subjects;
    public building (int _totalCapacity, int _computers, int _capacity, int _totalComputers, String[] _subjects, String _subject, String _teacher, int _roomNumber){
        super(_computers, _capacity, _subject, _teacher, _roomNumber);
        totalCapacity = _totalCapacity;
        subjects = new String[4];
        totalComputers = _totalComputers;
    }
    
    computerLab lab1 = new computerLab(24, 32, "CompSci", "Rodriguez", 22);
    computerLab lab2 = new computerLab(25,43,"Biology", "Vasquez", 10);
    Classroom class1 = new Classroom(38, 39, "Physics", "Paton");
    Classroom class2 = new Classroom(43, 23, "Chemistry", "Berglund");
    
    public int totalComps(){
        int computers1 = lab1.getComputers();
        int computers2 = lab2.getComputers();
        return computers1+computers2;
    }
    
    public int totalCapacity(){
        int room1 = lab1.getCapacity();
        int room2 = lab2.getCapacity();
        int room3 = class1.getCapacity();
        int room4 = class2.getCapacity();
        return room1+room2+room3+room4;
    }
    
    public String[] totalSubjects(String[] array){
        array[1] = lab1.getSubject();
        array[2] = lab2.getSubject();
        array[3] = class1.getSubject();
        array[4] = class2.getSubject();
        return array;
    }

}

