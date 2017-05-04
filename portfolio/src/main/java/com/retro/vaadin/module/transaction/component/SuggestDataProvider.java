package com.retro.vaadin.module.transaction.component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
public class SuggestDataProvider extends AbstractBackEndDataProvider<Stock, String> {

    private StockService service = App.get(StockService.class);
    private static final long serialVersionUID = 1L;

    @Override
    public boolean isInMemory() {
        return false;
    }

    @Override
    protected Stream<Stock> fetchFromBackEnd(Query<Stock, String> query) {
        if (query.getFilter().isPresent() && query.getFilter().get().length() > 2) {
            Stream<Stock> extracted = extracted(query);
            return extracted;
        }
        return new ArrayList<Stock>().stream();
    }

    private Stream<Stock> extracted(Query<Stock, String> query) {
        List<Stock> stockByPrefix = service.getStockByPrefix(query.getFilter().get());
        return stockByPrefix.stream();
    }

    @Override
    protected int sizeInBackEnd(Query<Stock, String> query) {
        if (query.getFilter().isPresent() && query.getFilter().get().length() > 2) {
            return (int) extracted(query).count();
        }
        return 0;
    }



}
