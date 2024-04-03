package fr.emse.test;

import java.util.Objects;

public class Money implements IMoney{
	
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency) {
	  fAmount = amount;
	  fCurrency = currency;
	}
	
	public int amount() {
	  return fAmount;
	}
	
	public String currency() {
	  return fCurrency;
	}
	
	/*
	 * public Money add(Money m) { if (m.currency().equals(currency())) return new
	 * Money(amount() + m.amount(), currency()); return new MoneyBag(this, m); }
	 */
	
	//Ajout du méthode equals
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Money other = (Money) obj;
	    return fAmount == other.fAmount && Objects.equals(fCurrency, other.fCurrency);
	}

	@Override
	public IMoney add(IMoney money) {
		if (money instanceof Money) {
            Money m = (Money) money;
            if (m.currency().equals(currency()))
                return new Money(amount() + m.amount(), currency());
        } else if (money instanceof MoneyBag) {
            MoneyBag bag = (MoneyBag) money;
            return bag.add(this);
        }
        throw new IllegalArgumentException("Incompatible types");
	}


}
