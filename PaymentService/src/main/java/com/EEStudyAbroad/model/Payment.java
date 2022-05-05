package com.EEStudyAbroad.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="payments")
public class Payment {
	
	@Id
	@Column(name="booking_id")
	private long bookingId;
	
	@Column(name="amount_due")
	private double amountDue;
	
	@Column(name="due_date")
	private long dueDate;

	
	
	public Payment() {
		super();
	}

	public Payment(long bookingId, double amountDue, long dueDate) {
		super();
		this.bookingId = bookingId;
		this.amountDue = amountDue;
		this.dueDate = dueDate;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	public long getDueDate() {
		return dueDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountDue, bookingId, dueDate);
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
		return Double.doubleToLongBits(amountDue) == Double.doubleToLongBits(other.amountDue)
				&& bookingId == other.bookingId && dueDate == other.dueDate;
	}

	@Override
	public String toString() {
		return "Payment [bookingId=" + bookingId + ", amountDue=" + amountDue + ", dueDate=" + dueDate + "]";
	}
	
}
