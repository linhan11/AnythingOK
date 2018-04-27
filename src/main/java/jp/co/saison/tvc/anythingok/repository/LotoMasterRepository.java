package jp.co.saison.tvc.anythingok.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.saison.tvc.anythingok.domain.LotoMaster;

public interface LotoMasterRepository extends JpaRepository<LotoMaster, String> {
//    @Query("SELECT x FROM LotoMaster x ORDER BY x.loto_index")
//    List<LotoMaster> findAllOrderByName();
//
//    @Query("SELECT x FROM LotoMaster x ORDER BY x.loto_index")
//    Page<LotoMaster> findAllOrderByName(Pageable pageable);
//    
//    @Query("SELECT x FROM LotoMaster x")
//    List<LotoMaster> findAll();
}

