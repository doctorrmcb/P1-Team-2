package com.revature.tuition.dao;

import com.revature.tuition.pojo.EventType;

public interface EventTypeDAO {

	public boolean createEventType(EventType eventType);
	public EventType readEventType(int eventTypeId);
	public boolean updateEventType(EventType eventType);
	public boolean deleteEventType(int eventTypeId);
	
}
