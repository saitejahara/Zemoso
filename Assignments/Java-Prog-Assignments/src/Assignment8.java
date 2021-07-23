class Exception1 extends Exception{
    Exception1(String s){
        super(s);
    }
}
class Exception2 extends Exception{
    Exception2(String s){
        super(s);
    }
}
class Exception3 extends Exception{
    Exception3(String s){
        super(s);
    }
}
class Assignment8{

    static void validate(int var1,int var2, int var3, int n)throws Exception1, Exception2, Exception3{
        //n is used as the null pointer flag
        if(n<5){
            if(var1>18){
                if(var2>18){
                    if(var3>18){
                        System.out.println("Doesn't throw anything");
                    }
                    else{
                        throw new Exception1("not valid");
                    }
                }
                else{
                    throw new Exception2("not valid");
                }
            }
            else{
                throw new Exception3("not valid");
            }
        }
        else{
            throw new NullPointerException();
        }
    }

    public static void main(String args[]){
        try{
            int n=5;
            validate(19,13,14,8);
        }
        catch(Exception1 | Exception2 | Exception3 e) {
            System.out.println("In catch block");
            //System.out.println("Exception occurred: "+e);
            e.printStackTrace();
        }
        finally{
            System.out.println("in finally");
        }
    }
}