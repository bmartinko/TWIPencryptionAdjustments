package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User superUser;
        User users[] = new User[10];
        int count = 1;

        System.out.println("Welcome to a secure communication environment");
        System.out.println("By default the first user will be a super user");
        superUser = new User();
        users[0] = superUser;

        System.out.println("Please create more users to communicate with (up to 10)");

        String answer;
/*
This represents the original communication between the program and the user. It allows for the creation of a super user, and a
bunch of other users. This also states that the user can add up to 10 different users within the program.
 */
        while(true){
            System.out.println("Create user " + (count+1) + "(y/n)");
            answer = sc.next();
            if(answer.equalsIgnoreCase("n")){
                break;
            }else if(count > 9){
                System.out.println("Sorry, user limit reached");
                break;
            }
            users[count] = new User();
            users[0].grant(users[count]);
            count++;
        }
/*
This represents the way users are added to the program. This takes each additional user, and makes sure that the amount of users
does not go above the max 10, stopping the loop from allowing more users to be added with a prompt stating the max amount, and stopping
the user from adding anymore.
 */
        int userId, userId2;
        String say;

        while(true){
            System.out.println("Pick a user to be (0-" + count + ")");
            userId = sc.nextInt();
            System.out.println("Say something, grant access(grant), revoke access(revoke), or exit: ");
            say = sc.nextLine();
            say = sc.nextLine();
            if(say.equalsIgnoreCase("grant")){
                System.out.println("Grant who access to user " + userId + "?");
                userId2 = sc.nextInt();
                users[userId2].grant(users[userId]);
            }else if(say.equalsIgnoreCase("revoke")){
                System.out.println("Revoke who's access?");
                userId2 = sc.nextInt();
                users[userId2].revoke(users[userId]);
            }else if(say.equalsIgnoreCase("exit")){
                break;
            }else{
                users[userId].say(say, userId, users, count);
            }
        }
    }
/*
This represents how the access of the encrypted messages is handled. It allows for the picking of a specific user, and gives
prompts for granting access, revoking access, or exiting the loop. It adds the permission to the key in order for the user to be
able to access the specific messages.
 */
}
