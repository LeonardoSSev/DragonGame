
package testes;

/*
 * @author Leonardo
 */
public class Dragon {
    private int hp;
    private int dDamage;
     
    public Dragon(){
        hp = 150;
        dDamage = 0;
    }
    public int getHp() {
        return hp;
    }

    
    public void setHp(int hp) {
        this.hp = hp;
    }

   
     
    public int getDDamage() {
        return dDamage;
    }

    public void setDDamage(int dDamage) {
        this.dDamage = dDamage;
    }
    
    public String sendDMsg(){
        String msg;
        msg = "Dragon hit you and you took " + dDamage + " of damage";
        return msg;
    }
    
}
