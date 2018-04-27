package jp.co.saison.tvc.anythingok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.saison.tvc.anythingok.domain.LotoMaster;
import jp.co.saison.tvc.anythingok.repository.LotoMasterRepository;

@Service
@Transactional
public class LotoMasterService {
    @Autowired
    LotoMasterRepository lotoMasterRepository;

    public List<LotoMaster> findAll() {
        return lotoMasterRepository.findAll();
    }

    public LotoMaster findOne(String id) {
        return lotoMasterRepository.findOne(id);
    }

    public Page<LotoMaster> findAll(Pageable pageable) {
        return lotoMasterRepository.findAll(pageable);
    }
}
