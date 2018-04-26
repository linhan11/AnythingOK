package jp.co.saison.tvc.anythingok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import jp.co.saison.tvc.anythingok.domain.LotoUser;
import jp.co.saison.tvc.anythingok.domain.User;
//import jp.co.saison.tvc.anythingok.repository.LotoUserInfoRepository;
import jp.co.saison.tvc.anythingok.repository.UserRepository;

@Service
@Transactional
public class LotoUserInfoService {
    @Autowired
    UserRepository userRepository;

//    public List<User> findAll() {
//        return userRepository.findAllOrderByName();
//    }
//
//    public Page<LotoHistory> findAll(Pageable pageable) {
//        return lotoHistoryRepository.findAllOrderByName(pageable);
//    }

    public User findOne(String username) {
        return userRepository.findOne(username);
    }

    public User create(User lotoUser) {
        return userRepository.save(lotoUser);
    }

    public User update(User lotoUser) {
        return userRepository.save(lotoUser);
    }

//    public LotoHistory update(LotoHistory lotohistory, User user) {
//    	lotohistory.setUser(user);
//        return lotoHistoryRepository.save(lotohistory);
//    }

//    public void delete(Integer id) {
//    	lotoHistoryRepository.delete(id);
//    }
}