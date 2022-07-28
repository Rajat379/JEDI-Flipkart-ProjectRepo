/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import javax.management.Notification;

/**
 * @author vanshika.yadav
 *
 */
public class NotificationImpl implements NotificationInterface{

	public boolean showNotification(String message, String rollno) {

		    return true;
    }
	@Override
	public List<Notification> getNotification(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
