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
public class Cars {
    //Properties
    int capacity;
    double mpg;
    int maxSpeed;
    String make;
    
    //contructors
    //Cars name = new Cars()
    Cars(int _capacity, int _maxSpeed, double _mpg, String _make){
        capacity = _capacity;
        mpg = _mpg;
        maxSpeed = _maxSpeed;
        make = _make;
    }
    
    Cars(int _capacity, String _make){
        capacity = _capacity;
        make = _make;
    }
    
    //Setter Method
    public void setMpg(double _mpg){
        mpg = _mpg;
    }
    
    //Getter Methods
    public int getCapacity(){
        return capacity;
    }
    
    //methods
    public double milesDriven(double numOfGall){
        return mpg * numOfGall;
    }

    public String toString(){
        return "Your car is a "+make+" holds "+capacity+" people and drives "
                +maxSpeed+" mph!";
    }
}
