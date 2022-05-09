
package com.EEStudyAbroad.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Payment {
	
	private long bookingId;
	private double amountPaid;
	private long date;

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
	
	
	public Payment() {
		super();
	}

	public Payment(long bookingId, double amountPaid, long date) {
		super();
		this.bookingId = bookingId;
		this.amountPaid = amountPaid;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Payment [bookingId=" + bookingId + ", amountPaid=" + amountPaid + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountPaid, bookingId, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Double.doubleToLongBits(amountPaid) == Double.doubleToLongBits(other.amountPaid)
				&& bookingId == other.bookingId && date == other.date;
	}

	
}
