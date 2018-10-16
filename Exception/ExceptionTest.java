import java.util.Random;
public class ExceptionTest{
    public static void main(String []args){
        Worker worker=new Worker();
        Doctor doctor=new Doctor();
        try{
            worker.work();
        }catch(SickException e){
            doctor.cure(worker);
            if(worker.getStatus().equals("健康")){
                System.out.println("恭喜你可以恢复了");
            }else{
                System.out.println("sorry,尽力了");
            }
        }finally{
            System.out.println("欢迎下次再来");
        }
    }
}

class Worker{
    private String status;
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }
    
    public void work()throws SickException{
        Random random=new Random();
        int rad=random.nextInt(3)+1;
        if(rad==1){
            //抛出一个自定义异常对象
            throw new SickException("我有病");
        }else{
            System.out.println("身体健康，不用治疗");
        }
    }
}

class SickException extends Exception{
    private String message;
    public SickException(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
}

class Doctor{
    public void cure(Worker worker){
        Random random=new Random();
        int rad=random.nextInt(2)+1;
        if(rad==1){
            worker.setStatus("健康");
        }else{
            worker.setStatus("死亡");
        }
    }
}