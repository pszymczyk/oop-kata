package com.pszymczyk.singleresponsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Arrays;
import java.util.List;

/**
 * @author pawel szymczyk
 */
class MultipleClientsItemBoughtRepository implements ItemBoughtRepository {

    private final List<ItemBoughtRepository> clients;

    @Autowired
    public MultipleClientsItemBoughtRepository(@Qualifier("rest") ItemBoughtRepository rest,
                                               @Qualifier("logstash") ItemBoughtRepository logstash) {
        this.clients = Arrays.asList(rest, logstash);
    }

    @Override
    public void save(ItemBought itemBought) {
        for (ItemBoughtRepository client: clients) {
            client.save(itemBought);
        }
    }
}
