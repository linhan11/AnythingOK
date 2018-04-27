package jp.co.saison.tvc.anythingok.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import jp.co.saison.tvc.anythingok.domain.Loto6info;
import jp.co.saison.tvc.anythingok.domain.LotoHistory;

public interface LotoHistoryRepository extends JpaRepository<LotoHistory, Integer> {
    @Query("SELECT x FROM LotoHistory x ORDER BY x.loto_index")
    List<LotoHistory> findAllOrderByName();

//    @Query(value = "SELECT * FROM loto_historys WHERE user_id = 'user1' ORDER BY loto_index", nativeQuery = true)
//    List<LotoHistory> findByUserName();

    @Query(value = "SELECT * FROM loto_historys WHERE user_id = :username ORDER BY loto_index", nativeQuery = true)
    List<LotoHistory> findByUserName(@Param("username")String username);

    @Query("SELECT x FROM LotoHistory x ORDER BY x.loto_index")
    Page<LotoHistory> findAllOrderByName(Pageable pageable);
}

