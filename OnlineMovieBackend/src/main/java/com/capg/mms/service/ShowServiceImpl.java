package com.capg.mms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.dao.MovieDao;
import com.capg.mms.dao.ShowDao;
import com.capg.mms.entity.Bookings;
import com.capg.mms.entity.Movie;
import com.capg.mms.entity.Show;
import com.capg.mms.entity.Theater;
import com.capg.mms.exceptions.ShowNotFound;
import com.capg.mms.repository.BookingsRepository;
import com.capg.mms.repository.TheaterRepository;

@Service
@Transactional
public class ShowServiceImpl implements ShowService {

	@Autowired
	private ShowDao showDao;

	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private BookingsRepository bookingDao;
	
	@Autowired
	private TheaterRepository theaterDao ;

	@Override
	public Show addShow(Show show) {
		return showDao.save(show);
	}

	@Override
	public List<Show> getShow() {
		return showDao.getShow();
	}

	@Override
	public String deleteShow(long show) {
		Optional<Show> s = showDao.findById(show);
		if (!s.isPresent()) {
			throw new ShowNotFound("Show Not Found!");
		}
		return showDao.deleteShow(show);
	}

	@Override
	public Movie findOne(long Id) {
		return movieDao.findOne(Id);
	}
//	Fetch show by Movie ID

	public List<Show> fetchByMovie(Movie m) {
		return showDao.findBytheMovie(m);
	}

	@Override
	public Show fetchById(long Id) {
		// TODO Auto-generated method stub
		return showDao.getOne(Id);

	}

//	Get the available seat for the movie 
	@Override
	public Bookings getAvailableSeat(long showId) {
		return bookingDao.findById(showId).get();
	}
	
	@Override
	public Theater findOneById(long Id) {
		// TODO Auto-generated method stub
		return theaterDao.findById(Id).get() ;
	}
}