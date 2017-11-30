package com.pszymczyk.warmup;

import com.pszymczyk.generic.Money;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pawel szymczyk
 */
public class ClientTest {

    @Test
    public void shouldChargeClient() {
        //given
        Money purchaseValue = new Money("100");
        Client client = new Client(new Money("150"));

        //when
        Purchase purchase = client.charge(purchaseValue);

        //then
        assertThat(purchase).isEqualTo(new Purchase(purchaseValue));
    }

    @Test(expected = CannotChargeClient.class)
    public void shouldNotChargeClientWhenThereAreNoSufficientFounds() {
        //given
        Money purchaseValue = new Money("100");

        //when
        Purchase purchase = new Client().charge(purchaseValue);

        //then
        assertThat(purchase).isEqualTo(new Purchase(purchaseValue));
    }

}