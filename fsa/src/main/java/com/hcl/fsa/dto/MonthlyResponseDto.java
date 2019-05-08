package com.hcl.fsa.dto;

public class MonthlyResponseDto {

	public String month;
	public Balances balances;

	public MonthlyResponseDto(String month, Double totalCredits, Double totalDebits, Double closingBlances) {
		this.month = month;
		this.balances = new Balances(totalCredits, totalDebits, closingBlances);
	}

	public MonthlyResponseDto(String month) {
		super();
		this.month = month;
	}

	public static class Balances {
		public Double totalCredits;
		public Double totalDebits;
		public Double closingBlances;

		public Balances(Double totalCredits, Double totalDebits, Double closingBlances) {
			super();
			this.totalCredits = totalCredits;
			this.totalDebits = totalDebits;
			this.closingBlances = closingBlances;
		}

		public Double getTotalCredits() {
			return totalCredits;
		}

		public void setTotalCredits(Double totalCredits) {
			this.totalCredits = totalCredits;
		}

		public Double getTotalDebits() {
			return totalDebits;
		}

		public void setTotalDebits(Double totalDebits) {
			this.totalDebits = totalDebits;
		}

		public Double getClosingBlances() {
			return closingBlances;
		}

		public void setClosingBlances(Double closingBlances) {
			this.closingBlances = closingBlances;
		}

	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Balances getBalances() {
		return balances;
	}

	public void setBalances(Balances balances) {
		this.balances = balances;
	}

}
