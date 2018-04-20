package jp.co.saison.tvc.anythingok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.saison.tvc.anythingok.domain.Loto6info;
import jp.co.saison.tvc.anythingok.domain.User;
import jp.co.saison.tvc.anythingok.repository.Loto6infoRepository;

import java.util.List;

@Service
@Transactional
public class Loto6infoService {
    @Autowired
    Loto6infoRepository loto6infoRepository;

    public List<Loto6info> findAll() {
        return loto6infoRepository.findAllOrderByName();
    }

    public Page<Loto6info> findAll(Pageable pageable) {
        return loto6infoRepository.findAllOrderByName(pageable);
    }

    public Loto6info findOne(Integer id) {
        return loto6infoRepository.findOne(id);
    }

    public Loto6info create(Loto6info loto6info, User user) {
        loto6info.setUser(user);
        return loto6infoRepository.save(loto6info);
    }

    public Loto6info update(Loto6info loto6info, User user) {
        loto6info.setUser(user);
        return loto6infoRepository.save(loto6info);
    }

    public void delete(Integer id) {
        loto6infoRepository.delete(id);
    }
}