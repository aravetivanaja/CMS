package com.example.CMS.User.DTO;

import java.time.LocalDateTime;

public class ScheduleRequest {
	
	private LocalDateTime dateTime;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public ScheduleRequest(LocalDateTime dateTime) {
		super();
		this.dateTime = dateTime;
	}
	
	
	public ScheduleRequest()
	{
		
	}

}
