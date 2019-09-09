/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public final class Validation {
    public boolean checkNO(String No)
    {
        try{
        if(checkNum(No)&&!No.contains(".")&&Integer.parseInt(No)>0)
            return true;
        }
        catch(Exception e){
                ;
                }
        return false;
    }
    private boolean checkNum(String str)
    {
        boolean check=true;
        int c=0;
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)>='0'&&str.charAt(i)<='9'))
                ;
            else if(str.charAt(i)=='.'){
                c++;
                if(c>1){
                check=false;
                break;
            }
            }
            else{
                check=false;
                break;
            }
        }
        
        return check;
    }
    
}
    
