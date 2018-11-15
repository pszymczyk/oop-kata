package com.pszymczyk.singleresponsibility;

import java.util.List;

class ItemBoughtRepositoryChain implements ItemBoughtRepository {

    private final List<ItemBoughtRepository> chain;

    public ItemBoughtRepositoryChain(List<ItemBoughtRepository> chain) {
        this.chain = chain;
    }

    @Override
    public void save(ItemBought itemBought) {
        chain.forEach( repo -> repo.save(itemBought));
    }
}
