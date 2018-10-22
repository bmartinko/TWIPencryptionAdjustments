package com.company;
import java.util.Arrays;
/**
 * Created by dpennebacker on 10/28/16.
 */
public class User {
    private String key; // Users personal encryption key
    private String[] keys = new String[10]; // Maximum of 10 users at once
    private Encryption crypt = new Encryption();

    public User(){
        this.key = crypt.keygen();
        int i = 0;
        for(String s : keys){
            keys[i] = "";
            i++;
        }
    }
/*
This generates the user class for the rest of the code. It generates the object for the key to which they will be later assigned.
It also shows the key the user may have.
 */
    public boolean hasAccess(User u){
        boolean status = false;
        for(int i=0;i<this.keys.length;i++){
            if(this.keys[i].equals(u.getKey())){
                status = true;
                break;
            }
        }
        return status;
    }
    public void grant(User u){
        int i = 0;
        for(String s : this.keys){
            if(s.equals("")){
                this.keys[i] = u.getKey();
            }else{
                i++;
            }
        }
    }

    public void revoke(User u){
        int count = 0;
        for(String s : this.keys){
            if(s.equals(u.getKey())){
                this.keys[count] = "";
            }else{
                count++;
            }
        }
    }
/*
These allow for the addition of giving access or revoking access to the specific users. The hasAccess class shows the status of
the user and whether they have a key or not. The grant class adds the keys to the user, which will let them view the message.
Revoke class takes away that key, restricting access to the key, which will prohibit the user from viewing the message.
 */
    public String getKey(){
        return this.key;
    }

    public String[] getKeys(){
        return this.keys;
    }

    public void newKey(){
        this.key = crypt.keygen();
    }

    public void say(String cmt, int id, User u[], int count){
        System.out.println("User " + id + " says " + cmt);
        String encrypted = crypt.encrypt(cmt, u[id].getKey());
        System.out.println("This is encrypted to " + encrypted);
        int i;
        for(i=0;i < count; i++){
            if(id == i){
                continue;
            }
            if(u[i].hasAccess(u[id])){
                System.out.println("User " + i + " sees: " + cmt);
            }else{
                System.out.println("User " + i + " sees: " + encrypted);
            }
        }
    }
/*
Class say allows for the specific user to be able to see the messages if they have the key. It states the encrypted if the
specific user has access to the correct key. If they do, it will display what the user is trying to see. If not, it will display
the encrypted message, preventing the user from being able to view the message.
 */
}
