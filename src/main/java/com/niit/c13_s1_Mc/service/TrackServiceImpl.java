package com.niit.c13_s1_Mc.service;

import com.niit.c13_s1_Mc.domain.Track;
import com.niit.c13_s1_Mc.repository.ITrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements ITrackService{

    ITrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(ITrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track addTrack(Track track) {
        if (trackRepository.findById(track.getTrackId()).isEmpty()){
            return trackRepository.save(track);
        }
        return null;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public String deleteTrack(int trackId) {
        if (trackRepository.findById(trackId).isEmpty()){
            return "Track does not exist";
        }
        trackRepository.deleteById(trackId);
        return "Track deleted successfully";
    }

    @Override
    public Track updateTrack(Track track) {
        if (trackRepository.findById(track.getTrackId()).isEmpty()){
            return null;
        }
        Track temp =trackRepository.findById(track.getTrackId()).get();
        temp.setTrackName(track.getTrackName());
        temp.setTrackRating(track.getTrackRating());
        temp.setTrackComments(track.getTrackComments());
        temp.setTrackArtist(track.getTrackArtist());
        return trackRepository.save(temp);
    }

    @Override
    public Track getAllTrackById(int trackId) {
        return trackRepository.findById(trackId).get();
    }
}
