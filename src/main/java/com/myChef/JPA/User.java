package com.myChef.JPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mocart on 07-Mar-17.
 */
@Entity
@Table(name = "users", schema = "my_chef_db")
public class User {
    private long userId;
    private String userName;
    private String email;
    private String pswrdHash;
    private UserDetails userDetails;
    private boolean isChef;
    private ChefDetails chefDetails;
    private List<Ugroup> ugroups = new ArrayList<>();


//    private List<Event> events;
//    private List<Feedback> feedbacksFromUser;
//    private List<Feedback> feedbacksToUser;
//    private List<Message> messages;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "pswrd_hash")
    public String getPswrdHash() {
        return pswrdHash;
    }

    public void setPswrdHash(String pswrdHash) {
        this.pswrdHash = pswrdHash;
    }

    @Basic
    @Column(name = "is_chef")
    public boolean isChef() {
        return isChef;
    }


    public void setChef(boolean chef) {
        isChef = chef;
    }

    @OneToOne(mappedBy = "user")
    public ChefDetails getChefDetails() {
        return chefDetails;
    }

    public void setChefDetails(ChefDetails chefDetails) {
        this.chefDetails = chefDetails;
    }

//    @OneToMany(mappedBy = "user")
//    public List<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(List<Event> events) {
//        this.events = events;
//    }
//
//    @OneToMany(mappedBy = "fromUser")
//    public List<Feedback> getFeedbacksFromUser() {
//        return feedbacksFromUser;
//    }
//
//    public void setFeedbacksFromUser(List<Feedback> feedbacksFromUser) {
//        this.feedbacksFromUser = feedbacksFromUser;
//    }
//
//    @OneToMany(mappedBy = "toUser")
//    public List<Feedback> getFeedbacksToUser() {
//        return feedbacksToUser;
//    }
//
//    public void setFeedbacksToUser(List<Feedback> feedbacksToUser) {
//        this.feedbacksToUser = feedbacksToUser;
//    }
//
//    @OneToMany(mappedBy = "user")
//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }

    @OneToOne(mappedBy = "user")
    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @ManyToMany(mappedBy = "users")
    public List<Ugroup> getUgroups() {
        return ugroups;
    }

    public void setUgroups(List<Ugroup> ugroups) {
        this.ugroups = ugroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (isChef != user.isChef) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (pswrdHash != null ? !pswrdHash.equals(user.pswrdHash) : user.pswrdHash != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pswrdHash != null ? pswrdHash.hashCode() : 0);
        result = 31 * result + (isChef ? 1 : 0);
        return result;
    }
}
