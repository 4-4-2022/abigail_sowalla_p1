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
	
	@Column(name="amount_paid")
	private double amountPaid;
	
	@Column(name="payment_date")
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
