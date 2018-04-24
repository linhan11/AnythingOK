package jp.co.saison.tvc.anythingok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import jp.co.saison.tvc.anythingok.domain.Loto6info;
import jp.co.saison.tvc.anythingok.domain.LotoHistory;
import jp.co.saison.tvc.anythingok.domain.User;
import jp.co.saison.tvc.anythingok.repository.LotoHistoryRepository;

@Service
@Transactional
public class LotoHistoryService {
    @Autowired
    LotoHistoryRepository lotoHistoryRepository;

    public List<LotoHistory> findAll() {
        return lotoHistoryRepository.findAllOrderByName();
    }

    public Page<LotoHistory> findAll(Pageable pageable) {
        return lotoHistoryRepository.findAllOrderByName(pageable);
    }

    public LotoHistory findOne(Integer id) {
        return lotoHistoryRepository.findOne(id);
    }

    public LotoHistory create(LotoHistory lotohistory, User user) {
    	lotohistory.setUser(user);
        return lotoHistoryRepository.save(lotohistory);
    }

    public LotoHistory update(LotoHistory lotohistory, User user) {
    	lotohistory.setUser(user);
        return lotoHistoryRepository.save(lotohistory);
    }

    public void delete(Integer id) {
    	lotoHistoryRepository.delete(id);
    }
}