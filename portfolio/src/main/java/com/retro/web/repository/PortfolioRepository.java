package com.retro.web.repository;

import java.util.Collection;
import java.util.List;

import com.retro.web.bean.Investment;

/**
 * @author Vinayak More
 *
 * @date 11-Apr-2017
 */
public interface PortfolioRepository {
    
    public List<Investment> getAllInvestments(Long userId);
    
    public boolean updateAllInvestments(Collection<Investment> investmentList, Long userId);

}

