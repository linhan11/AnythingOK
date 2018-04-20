package jp.co.saison.tvc.anythingok.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.saison.tvc.anythingok.domain.Loto6info;

public interface Loto6infoRepository extends JpaRepository<Loto6info, Integer> {
    @Query("SELECT x FROM Loto6info x ORDER BY x.lotteryNo, x.lotteryDate")
    List<Loto6info> findAllOrderByName();

    @Query("SELECT x FROM Loto6info x ORDER BY x.lotteryNo, x.lotteryDate")
    Page<Loto6info> findAllOrderByName(Pageable pageable);
}

