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
public interface NotificationInterface {
	public List<Notification> getNotification(int studentId);
}
