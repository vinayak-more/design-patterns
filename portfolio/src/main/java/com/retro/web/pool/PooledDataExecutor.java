package com.retro.web.pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Component;

import com.retro.web.pool.service.PoolDataThread;

/**
 * @author Vinayak More
 *
 * @date 07-Aug-2017
 */
@Component
public class PooledDataExecutor {

    public void execute(Collection<String> stocks) {
        List<List<String>> partition = ListUtils.partition(new ArrayList<String>(stocks), 10);
        ExecutorService exService = Executors.newFixedThreadPool(50);
        for (List<String> part : partition) {
            exService.execute(new PoolDataThread(part));
        }
        try {
            exService.shutdown();
            exService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

