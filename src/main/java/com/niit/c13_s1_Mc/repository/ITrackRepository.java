package com.niit.c13_s1_Mc.repository;

import com.niit.c13_s1_Mc.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackRepository extends JpaRepository<Track, Integer> {
}
