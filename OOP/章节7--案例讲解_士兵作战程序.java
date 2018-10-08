public class SoldierDemo{
    public static void main(String []args){
        Officer officer=new Officer("范茂伟");
        officer.callToAttack();
        System.out.println("****************");
        officer.callToAttack(officer.getSoldiers()[0]);
        System.out.println("****************");
        officer.callToAttack(officer);
    }
}

//士兵抽象类
abstract class Soldier{
    private String name;
    public Soldier(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    
    public void start(){
        System.out.println("准备攻击...");
    }
    public void end(){
        System.out.println("攻击完成...");
    }
    
    public abstract void attack();
    
    //行动
    public void action(){
        start();
        attack();
        end();
    }
}

class LandSoldier extends Soldier{
    public LandSoldier(String name){
        super(name);
    }
    //实现抽象类中的抽象方法
    public void attack(){
        System.out.println(getName()+"使用步枪射击");
    }
}

class OceanSoldier extends Soldier{
    public OceanSoldier(String name){
        super(name);
    }
    //实现抽象类中的抽象方法
    public void attack(){
        System.out.println(getName()+"使用鱼雷射击");
    }
}

class Officer extends Soldier{
    private Soldier [] soldiers=new Soldier[2];//军官持有2个士兵
    public Officer(String name){
        super(name);
        soldiers[0]=new LandSoldier("张三");
        soldiers[1]=new OceanSoldier("李四");
    }
    
    public Soldier [] getSoldiers(){
        return soldiers;
    }
    //实现抽象类中的抽象方法
    public void attack(){
        System.out.println(getName()+"使用手枪射击");
    }
    //发号司令(让所持有的所有士兵一起发动攻击，包括自己)
    public void callToAttack(){
        for(int i=0;i<soldiers.length;i++){
            soldiers[i].action();//每个士兵调用其自身的行动方法
        }
        this.action();//自己也参与攻击
    }
    
    //让一个士兵去攻击
    public void callToAttack(Soldier soldier){
        soldier.action();
    }
}
