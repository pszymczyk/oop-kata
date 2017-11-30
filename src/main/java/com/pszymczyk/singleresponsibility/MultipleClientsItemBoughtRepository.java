package com.pszymczyk.singleresponsibility;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * @author pawel szymczyk
 */
class MultipleClientsItemBoughtRepository implements ItemBoughtRepository {

    private final List<ItemBoughtRepository> clients;

    @Autowired
    public MultipleClientsItemBoughtRepository(@Qualifier("rest") ItemBoughtRepository rest,
                                               @Qualifier("logstash") ItemBoughtRepository logstash) {
        this.clients = Lists.newArrayList(rest, logstash);
    }

    @Override
    public void save(ItemBought itemBought) {
        clients.forEach(c -> c.save(itemBought));
    }
}
