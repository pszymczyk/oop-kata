package com.pszymczyk.singleresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pawel szymczyk
 */
class LogstashItemBoughtRepository implements ItemBoughtRepository{

    private static final Logger logger = LoggerFactory.getLogger(LogstashItemBoughtRepository.class);

    @Override
    public void save(ItemBought itemBought) {
        logger.info("Item bought: " + itemBought.toString());
    }
}
