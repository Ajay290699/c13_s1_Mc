package com.niit.c13_s1_Mc.service;

import com.niit.c13_s1_Mc.domain.Track;

import java.util.List;

public interface ITrackService {

    public Track addTrack(Track track);
    public List<Track> getAllTrack();
    public String deleteTrack(int trackId);
    public Track updateTrack(Track track);
    public Track getAllTrackById(int trackId);
}
