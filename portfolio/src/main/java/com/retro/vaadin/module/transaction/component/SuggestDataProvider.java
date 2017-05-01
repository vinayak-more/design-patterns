package com.retro.vaadin.module.transaction.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import com.retro.config.App;
import com.retro.web.bean.Stock;
import com.retro.web.service.StockService;
import com.vaadin.data.provider.AbstractBackEndDataProvider;
import com.vaadin.data.provider.Query;

/**
 * @author Vinayak More
 *
 * @date 01-May-2017
 */
public class SuggestDataProvider extends AbstractBackEndDataProvider<SuggestItem, String> {

    /**
     * @param items
     */

    private StockService service = App.get(StockService.class);
    private static final long serialVersionUID = 1L;

    @Override
    public boolean isInMemory() {
        return false;
    }

    @Override
    protected Stream<SuggestItem> fetchFromBackEnd(Query<SuggestItem, String> query) {
        if (query.getFilter().isPresent() && query.getFilter().get().length() > 2) {
            Stream<SuggestItem> extracted = extracted(query);
            return extracted;
        }
        return new ArrayList<SuggestItem>().stream();
    }

    private Stream<SuggestItem> extracted(Query<SuggestItem, String> query) {
        List<Stock> stockByPrefix = service.getStockByPrefix(query.getFilter().get());
        @SuppressWarnings("unchecked")
        Collection<SuggestItem> collect = CollectionUtils.collect(stockByPrefix, new Transformer() {

            @Override
            public SuggestItem transform(Object input) {
                Stock s = (Stock) input;
                return new SuggestItem(1, s.getName() + "-" + s.getSymbol() + "-" + s.getCode());
            }
        });
        return collect.stream();
    }

    @Override
    protected int sizeInBackEnd(Query<SuggestItem, String> query) {
        if (query.getFilter().isPresent() && query.getFilter().get().length() > 2) {
            return (int) extracted(query).count();
        }
        return 0;
    }



}
