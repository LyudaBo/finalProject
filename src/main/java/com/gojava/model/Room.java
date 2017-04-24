package com.gojava.model;

import java.io.Serializable;

/**
 * Simple JavaBean domain object that represents a Room in a hotel.
 *
 * @author Firsov
 * @version 1.0
 */


public class Room implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private int number;
	private boolean framed;
	private boolean delete;
	private long hotel;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean isFramed() {
		return framed;
	}
	
	public void setFramed(boolean framed) {
		this.framed = framed;
	}
	
	public boolean isDelete() {
		return delete;
	}
	
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
	public long getHotel() {
		return hotel;
	}

	public void setHotel(long hotel) {
		this.hotel = hotel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (delete ? 1231 : 1237);
		result = prime * result + (framed ? 1231 : 1237);
		result = prime * result + (int) (hotel ^ (hotel >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (delete != other.delete)
			return false;
		if (framed != other.framed)
			return false;
		if (hotel != other.hotel)
			return false;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", framed=" + framed + ", delete=" + delete + ", hotel="
				+ hotel + "]";
	}
	
}
