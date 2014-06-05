package com.design.observer;

import java.util.ArrayList;

interface Observer {
       public void update(float interest);
}

interface Subject {
       public void registerObserver(Observer observer);

       public void removeObserver(Observer observer);

       public void notifyObservers();
       
       
}

class Loan implements Subject {
       private ArrayList<Observer> observers = new ArrayList<Observer>();
       private String type;
       private float interest;
       private String bank;

       public Loan(String type, float interest, String bank) {
              this.type = type;
              this.interest = interest;
              this.bank = bank;
       }

       public float getInterest() {
              return interest;
       }

       public void setInterest(float interest) {
              this.interest = interest;
              notifyObservers();
       }

       public String getBank() {
              return this.bank;
       }

       public String getType() {
              return this.type;
       }

       @Override
       public void registerObserver(Observer observer) {
              observers.add(observer);

       }

       @Override
       public void removeObserver(Observer observer) {
              observers.remove(observer);

       }

       @Override
       public void notifyObservers() {
              for (Observer ob : observers) {
                     System.out
                                  .println("Notifying Observers on change in Loan interest rate");
                     ob.update(this.interest);
              }

       }

	@Override
	public int hashCode() {
		final int prime = 51;
		int result = 1;
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + Float.floatToIntBits(interest);
		result = prime * result
				+ ((observers == null) ? 0 : observers.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Loan other = (Loan) obj;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (Float.floatToIntBits(interest) != Float
				.floatToIntBits(other.interest))
			return false;
		if (observers == null) {
			if (other.observers != null)
				return false;
		} else if (!observers.equals(other.observers))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}

class Newspaper implements Observer {
       @Override
       public void update(float interest) {
              System.out.println("Newspaper: Interest Rate updated, new Rate is: "
                           + interest);
       }
}

class Internet implements Observer {
       @Override
       public void update(float interest) {
              System.out.println("Internet: Interest Rate updated, new Rate is: "
                           + interest);
       }
}

public class ObserverTest {

       public static void main(String args[]) {
              // this will maintain all loans information
              Newspaper printMedia = new Newspaper();
              Internet onlineMedia = new Internet();

              Loan personalLoan = new Loan("Personal Loan", 12.5f,
                           "Standard Charterd");
              Loan personalLoan2 = new Loan("Personal Loan", 12.5f,
                      "Standard Charterd");
              Loan personalLoan3 = new Loan("Personal Loan.", 12.5f,
                      "Standard Charterd");
              System.out.println(personalLoan.equals(personalLoan2));
              System.out.println(personalLoan.equals(personalLoan3));
              System.out.println(personalLoan3.equals(personalLoan2));
              System.out.println(personalLoan.hashCode());
              System.out.println(personalLoan2.hashCode());
              System.out.println(personalLoan3.hashCode());
              personalLoan.registerObserver(printMedia);
              personalLoan.registerObserver(onlineMedia);
              personalLoan.setInterest(3.5f);

       }
}


