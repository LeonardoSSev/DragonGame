/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

/*
 * @author Leonardo
 */
public class Player {
    private String name;
    private int hp;
    private int pHit;
    private int pDamage;

    public Player(){
        hp = 100;
        pHit = 0;
        pDamage = 0;
        
    }
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }

   
    public int getHp() {
        return hp;
    }

    
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPHit() {
        return pHit;
    }

    
    public void setPHit(int pHit) {
        this.pHit = pHit;
    }
    
    public int getPDamage() {
        return pDamage;
    }

    
    public void setPDamage(int pDamage) {
        this.pDamage = pDamage;
    }
    
    public String sendPMsg(){
        String msg;
        msg = name + " hit the dragon and caused " + pDamage + " of damage";
        return msg;
    }
    
}
